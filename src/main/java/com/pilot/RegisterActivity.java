package com.pilot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pilot.API.APIService;
import com.pilot.object.Base;
import com.pilot.object.GetRoleData;
import com.pilot.object.SetParams;

import java.util.List;
import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class RegisterActivity extends AppCompatActivity {

    private int REGISTER_CODE = 101;
    public final String URL = "http://sharkbyte.co.il/bavel/backend/api/";


    private ProgressDialog pDialog;
    private ImageView add_anOther_number;
    private Button mRegisterButton;
    private Spinner mRoleSpinner, languageSpinner;
    private Locale current;
    private TextView termsTextView;
    private boolean isHebrew = false;

    private Retrofit retrofit;
    private int[] mRolesId;

    private EditText mFirstName, mLastName, mEmailAddress, mCompanyName, mPhoneNumber, mFaxNumber;
    private EditText optionalNumber2, optionalNumber3, optionalNumber4, optionalNumber5;
    private int count = 1;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        current = getResources().getConfiguration().locale;
        gson = new Gson();
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

        setContentView(R.layout.activity_register);

        Toolbar toolbar = (Toolbar) findViewById(R.id.header);
//        toolbar.setNavigationIcon(R.drawable.back_button);

        TextView actionBarText = (TextView) toolbar.findViewById(R.id.toolbar_title);
        actionBarText.setText(getResources().getString(R.string.register));

        setSupportActionBar(toolbar);

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

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
        init();
        setClickListeners();
        getRoles();

    }

    public void init() {

        add_anOther_number = (ImageView) findViewById(R.id.add_another);
        mRegisterButton = (Button) findViewById(R.id.register_now);
        mRoleSpinner = (Spinner) findViewById(R.id.spinner_role);
        languageSpinner = (Spinner) findViewById(R.id.locale_spinner);
        mRoleSpinner.setSelection(0);

        if (isHebrew) {
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this, R.layout.spinner_layout_heb, getResources().getStringArray(R.array.languages));
            languageSpinner.setAdapter(adapter);

            languageSpinner.setSelection(1);
            languageSpinner.setBackgroundResource(R.drawable.spinner_background_for_heb);

            adapter = new ArrayAdapter<String>(RegisterActivity.this, R.layout.spinner_layout_heb, getResources().getStringArray(R.array.role));
            mRoleSpinner.setAdapter(adapter);

            mRoleSpinner.setBackgroundResource(R.drawable.spinner_background_for_heb);
        } else {

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterActivity.this, R.layout.spinner_layout_eng, getResources().getStringArray(R.array.languages));
            languageSpinner.setAdapter(adapter);

            languageSpinner.setSelection(0);
            languageSpinner.setBackgroundResource(R.drawable.spinner_background_for_eng);

            adapter = new ArrayAdapter<String>(RegisterActivity.this, R.layout.spinner_layout_eng, getResources().getStringArray(R.array.role));
            mRoleSpinner.setAdapter(adapter);

            mRoleSpinner.setBackgroundResource(R.drawable.spinner_background_for_eng);
        }

        mFirstName = (EditText) findViewById(R.id.first_name);
        mLastName = (EditText) findViewById(R.id.last_name);
        mEmailAddress = (EditText) findViewById(R.id.user_email);

        mCompanyName = (EditText) findViewById(R.id.company_name);
        mPhoneNumber = (EditText) findViewById(R.id.phone_number);
        mFaxNumber = (EditText) findViewById(R.id.fax);

        optionalNumber2 = (EditText) findViewById(R.id.phone_number2);
        optionalNumber3 = (EditText) findViewById(R.id.phone_number3);
        optionalNumber4 = (EditText) findViewById(R.id.phone_number4);
        optionalNumber5 = (EditText) findViewById(R.id.phone_number5);

        current = getResources().getConfiguration().locale;

        termsTextView = (TextView) findViewById(R.id.terms_text_view);

        SpannableString content = new SpannableString(getResources().getString(
                R.string.term));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        termsTextView.setText(content);

        Log.e("locale ", "locale  = " + current.getDisplayName());
//
    }

    public void setClickListeners() {

        add_anOther_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (count < 5) {
                    switch (count) {

                        case 1:
                            optionalNumber2.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            optionalNumber3.setVisibility(View.VISIBLE);
                            break;
                        case 3:
                            optionalNumber4.setVisibility(View.VISIBLE);
                            break;
                        case 4:
                            optionalNumber5.setVisibility(View.VISIBLE);
                            break;
                    }

                    count = count + 1;
                }
            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateInput()) {

                    Intent registerIntent = new Intent(RegisterActivity.this, PasswordActivity.class);
                    registerIntent.putExtra("f_name", mFirstName.getText().toString());
                    registerIntent.putExtra("l_name", mLastName.getText().toString());
                    registerIntent.putExtra("email", mEmailAddress.getText().toString());
                    registerIntent.putExtra("p1", mPhoneNumber.getText().toString());
                    registerIntent.putExtra("p2", "" + optionalNumber2.getText().toString());
                    registerIntent.putExtra("p3", "" + optionalNumber3.getText().toString());
                    registerIntent.putExtra("p4", "" + optionalNumber4.getText().toString());
                    registerIntent.putExtra("p5", "" + optionalNumber5.getText().toString());
                    registerIntent.putExtra("c_name", mCompanyName.getText().toString());
                    registerIntent.putExtra("f_number", mFaxNumber.getText().toString());
                    registerIntent.putExtra("locale", current.getISO3Language());
                    registerIntent.putExtra("role", mRolesId[mRoleSpinner.getSelectedItemPosition()]);

                    startActivityForResult(registerIntent, REGISTER_CODE);
                }
            }
        });

        mRoleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        termsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }


    public boolean validateInput() {

        if (mFirstName.getText().length() == 0) {
            mFirstName.setError(getResources().getString(R.string.first_name_validation));
            return false;
        }
        if (mLastName.getText().length() == 0) {
            mLastName.setError(getResources().getString(R.string.last_name_validation));
            return false;
        }
        if (mCompanyName.getText().length() == 0) {
            mCompanyName.setError(getResources().getString(R.string.company_name_validation));
            return false;
        }
        if (mEmailAddress.getText().length() == 0) {
            mEmailAddress.setError(getResources().getString(R.string.email_validation));
            return false;
        }
        if (mPhoneNumber.getText().length() == 0) {
            mPhoneNumber.setError(getResources().getString(R.string.phone_number_validation));
            return false;
        }
        if (mPhoneNumber.getText().length() == 0) {
            mPhoneNumber.setError(getResources().getString(R.string.phone_number_validation));
            return false;
        }
        if (mFaxNumber.getText().length() == 0) {
            mFaxNumber.setError(getResources().getString(R.string.fax_validation));
            return false;
        } else {
            return true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REGISTER_CODE && resultCode == RESULT_OK) {

            RegisterActivity.this.finish();
        }
    }

    private void getRoles() {

        pDialog = new ProgressDialog(
                RegisterActivity.this);
        pDialog.setMessage(getResources().getString(R.string.get_role_message));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        SetParams params;
        if (isHebrew) {
            params = new SetParams("getRoles", "he");
        } else {
            params = new SetParams("getRoles", "en");
        }

        APIService apiService = retrofit.create(APIService.class);

        Call<GetRoleData> apiCall = apiService.getUserRoles(params);
        apiCall.enqueue(new Callback<GetRoleData>() {


            @Override
            public void onResponse(retrofit.Response<GetRoleData> mUserProfileData, Retrofit retrofit) {

                if (pDialog != null) {
                    pDialog.dismiss();
                }
                if (mUserProfileData.body().getMessage().equals("success")) {

                    if (mUserProfileData.body().getHe().size() > 0){

                        String[] mRolesArray = new String[mUserProfileData.body().getHe().size()];
                        mRolesId = new int[mUserProfileData.body().getHe().size()];
                        for (int size=0; size <mUserProfileData.body().getHe().size(); size++ ){
                            mRolesArray[size] = mUserProfileData.body().getHe().get(size).getName();
                            mRolesId[size] = mUserProfileData.body().getHe().get(size).getType();
                        }
                        if (isHebrew) {
                            ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterActivity.this, R.layout.spinner_layout_heb, mRolesArray);
                            mRoleSpinner.setAdapter(adapter);
                            mRoleSpinner.setSelection(0);
                            mRoleSpinner.setBackgroundResource(R.drawable.spinner_background_for_heb);
                        } else {

                            ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterActivity.this, R.layout.spinner_layout_eng, mRolesArray);
                            mRoleSpinner.setAdapter(adapter);
                            mRoleSpinner.setSelection(0);
                            mRoleSpinner.setBackgroundResource(R.drawable.spinner_background_for_eng);
                        }
                    }else{

                        String[] mRolesArray = new String[mUserProfileData.body().getEn().size()];
                        mRolesId = new int[mUserProfileData.body().getEn().size()];
                        for (int size=0; size <mUserProfileData.body().getEn().size(); size++ ){
                            mRolesArray[size] = mUserProfileData.body().getEn().get(size).getName();
                            mRolesId[size] = mUserProfileData.body().getEn().get(size).getType();
                        }

                        if (isHebrew) {

                            ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterActivity.this, R.layout.spinner_layout_heb, mRolesArray);
                            mRoleSpinner.setAdapter(adapter);
                            mRoleSpinner.setSelection(0);
                            mRoleSpinner.setBackgroundResource(R.drawable.spinner_background_for_heb);
                        } else {

                            ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisterActivity.this, R.layout.spinner_layout_eng, mRolesArray);
                            mRoleSpinner.setAdapter(adapter);
                            mRoleSpinner.setSelection(0);
                            mRoleSpinner.setBackgroundResource(R.drawable.spinner_background_for_eng);
                        }
                    }

                } else {
                    Toast.makeText(RegisterActivity.this, getResources().getString(R.string.get_role_error), Toast.LENGTH_SHORT).show();
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
