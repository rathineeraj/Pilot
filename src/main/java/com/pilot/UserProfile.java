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
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pilot.API.APIService;
import com.pilot.object.SetParams;
import com.pilot.object.UserProfileData;

import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class UserProfile extends AppCompatActivity {

    public final String URL = "http://sharkbyte.co.il/bavel/backend/api/index.php";
    private ProgressDialog pDialog;

    private UserSession mUserSession;
    private Locale current;
    private TextView mNameTextView, mEmailTextView, mPhoneNTextView1, mPhoneNTextView2, mPhoneNTextView3, mPhoneNTextView4, mPhoneNTextView5, localeTextView, companyTextView, faxTextView;

    private boolean isHebrew;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
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

        setContentView(R.layout.activity_user_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.header);
//        toolbar.setNavigationIcon(R.drawable.back_button);

        TextView actionBarText = (TextView) toolbar.findViewById(R.id.toolbar_title);
        actionBarText.setText(getResources().getString(R.string.title_activity_user_profile));

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

        mUserSession = new UserSession(this);

        init();


        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        getUser();
    }

    public void init() {

        mNameTextView = (TextView) findViewById(R.id.textViewName);
        mEmailTextView = (TextView) findViewById(R.id.textViewEmail);
        mPhoneNTextView1 = (TextView) findViewById(R.id.textViewPhone);
        mPhoneNTextView2 = (TextView) findViewById(R.id.textViewPhone2);
        mPhoneNTextView3 = (TextView) findViewById(R.id.textViewPhone3);
        mPhoneNTextView4 = (TextView) findViewById(R.id.textViewPhone4);
        mPhoneNTextView5 = (TextView) findViewById(R.id.textViewPhone5);
        localeTextView = (TextView) findViewById(R.id.textViewLocale);
        companyTextView = (TextView) findViewById(R.id.textViewCompany);
        faxTextView = (TextView) findViewById(R.id.faxText);

        mNameTextView.setText(mUserSession.getDisplayName());
        mEmailTextView.setText(mUserSession.getUserEmail());

        Button logout = (Button) findViewById(R.id.buttonLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserSession.destroyUserSession();
                Intent i = new Intent(UserProfile.this, MainActivity.class);
                startActivity(i);
                UserProfile.this.finish();
            }
        });
    }

    private void getUser() {

        pDialog = new ProgressDialog(
                UserProfile.this);
        pDialog.setMessage(getResources().getString(R.string.profile_loading));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        SetParams params = new SetParams(mUserSession.getUserId(), mUserSession.getUserToken(), mUserSession.getUserId(), "getUser");
        APIService apiService = retrofit.create(APIService.class);

        Call<UserProfileData> apiCall = apiService.getUser(params);
        apiCall.enqueue(new Callback<UserProfileData>() {


            @Override
            public void onResponse(retrofit.Response<UserProfileData> mUserProfileData, Retrofit retrofit) {

                if (pDialog != null) {
                    pDialog.dismiss();
                }
                if (mUserProfileData.body().getMessage().equals("success")) {

                    mPhoneNTextView1.setText(mUserProfileData.body().getPhone1());
                    mPhoneNTextView2.setText(mUserProfileData.body().getPhone2());
                    mPhoneNTextView3.setText(mUserProfileData.body().getPhone3());
                    mPhoneNTextView4.setText(mUserProfileData.body().getPhone4());
                    mPhoneNTextView5.setText(mUserProfileData.body().getPhone5());
                    localeTextView.setText(mUserProfileData.body().getLocale());
                    companyTextView.setText(mUserProfileData.body().getCompany());
                    faxTextView.setText(mUserProfileData.body().getFax());
                } else {
                    Toast.makeText(UserProfile.this, getResources().getString(R.string.profile_loading_error), Toast.LENGTH_SHORT).show();
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

    public void openInvitationActivity(View view){

        startActivity(new Intent(UserProfile.this, InvitationActivity.class));
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
