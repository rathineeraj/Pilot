package com.pilot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pilot.API.APIService;
import com.pilot.object.RegisterData;
import com.pilot.object.SetParams;

import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class PasswordActivity extends AppCompatActivity {


    public final String URL = "http://sharkbyte.co.il/bavel/backend/api/index.php";
    private ProgressDialog pDialog;

    private EditText mPassword, mConfirmPassword;
    private Button mRegisterButton;
    private UserSession mUserSession;
    private Locale current;
    private boolean isHebrew;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        current = getResources().getConfiguration().locale;

        Resources res = getResources();
        // Change locale settings in the app.
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        if (current.getISO3Language().contains("he")) {
            conf.locale = new Locale("he");
            isHebrew = true;
        } else {
            conf.locale = new Locale(current.getISO3Language());
            isHebrew = false;
        }
        res.updateConfiguration(conf, dm);

        setContentView(R.layout.activity_password_activty);
        Toolbar toolbar = (Toolbar) findViewById(R.id.header);
        setSupportActionBar(toolbar);

        try {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            if (isHebrew) {

                toolbar.setNavigationIcon(R.drawable.back_button_heb);
            } else {

                toolbar.setNavigationIcon(R.drawable.back_button_eng);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        TextView actionBarText = (TextView) toolbar.findViewById(R.id.toolbar_title);
        actionBarText.setText(getResources().getString(R.string.title_activity_password_activty));

        mUserSession = new UserSession(this);
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        TextView mEmail = (TextView) findViewById(R.id.emailtext);
        mEmail.setText("" + getIntent().getStringExtra("email"));
        mPassword = (EditText) findViewById(R.id.user_password);
        mConfirmPassword = (EditText) findViewById(R.id.user_confirm_password);
        mRegisterButton = (Button) findViewById(R.id.register_now);


        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validatePassword()) {
                    performRegistration();
                }
            }
        });

    }

    private boolean validatePassword() {

        if (mPassword.getText().length() == 0) {
            mPassword.setError(getResources().getString(R.string.password_validation));
            return false;
        }
        if (mConfirmPassword.getText().length() == 0) {
            mConfirmPassword.setError(getResources().getString(R.string.confirm_password_validation));
            return false;
        }
        if (mConfirmPassword.getText().length() > 0) {

            if (!mConfirmPassword.getText().toString().equals(mPassword.getText().toString())) {

                mConfirmPassword.setError(getResources().getString(R.string.password_mismatch));
                return false;
            }
        }
        return true;
    }

    private void performRegistration() {

        pDialog = new ProgressDialog(
                PasswordActivity.this);
        pDialog.setMessage(getResources().getString(R.string.register_message));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        SetParams params = new SetParams(getIntent().getStringExtra("email"), mPassword.getText().toString(),
                "register", getIntent().getStringExtra("role"),
                getIntent().getStringExtra("f_name"), getIntent().getStringExtra("l_name"), getIntent().getStringExtra("locale"),
                getIntent().getStringExtra("p1"),
                "" + getIntent().getStringExtra("p2"), "" + getIntent().getStringExtra("p3"),
                "" + getIntent().getStringExtra("p4"), "" + getIntent().getStringExtra("p5"),
                getIntent().getStringExtra("f_number"), getIntent().getStringExtra("c_name"));


        APIService apiService = retrofit.create(APIService.class);

        Call<RegisterData> apiCall = apiService.register(params);
        apiCall.enqueue(new Callback<RegisterData>() {


            @Override
            public void onResponse(retrofit.Response<RegisterData> registerData, Retrofit retrofit) {

                if (pDialog != null) {
                    pDialog.dismiss();
                }

                if (registerData.body() != null) {

//                    Toast.makeText(RegisterActivity.this, "Message "+ registerData.body().getMessage(), Toast.LENGTH_SHORT).show();
                    mUserSession.setUserId(registerData.body().getUserid());
                    mUserSession.setUserToken(registerData.body().getToken());
                    mUserSession.setUserEmail(getIntent().getStringExtra("email"));
                    mUserSession.setUserPassword(mPassword.getText().toString());
                    mUserSession.setUserLoggedIn(true);
                    mUserSession.setDisplayName(getIntent().getStringExtra("f_name") + " " + getIntent().getStringExtra("l_name"));
                    Intent intent = new Intent(PasswordActivity.this, OverViewActivity.class);
                    startActivity(intent);
                    setResult(RESULT_OK);
                    PasswordActivity.this.finish();
                } else {
                    Toast.makeText(PasswordActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Throwable t) {

                if (pDialog != null) {
                    pDialog.dismiss();
                }

                t.printStackTrace();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home: {
                finish();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
