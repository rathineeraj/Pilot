package com.pilot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.pilot.API.APIService;
import com.pilot.object.LoginData;
import com.pilot.object.SetParams;

import java.util.Locale;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    public final String URL = "http://sharkbyte.co.il/bavel/backend/api/";
    private ProgressDialog pDialog;
    private EditText mEmailEditText, mPasswordEditText;
    private Button mLoginButton;
    private UserSession mUserSession;
    private Locale current;
    private TextView registerTextView;
    private boolean isHebrew = false;
    private Spinner languageSpinner;

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

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.header);
//        toolbar.setNavigationIcon(R.drawable.back_button);

        TextView actionBarText = (TextView) toolbar.findViewById(R.id.toolbar_title);
        actionBarText.setText(getResources().getString(R.string.login));
        setSupportActionBar(toolbar);
        try {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }


        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mUserSession = new UserSession(this);

        registerTextView = (TextView) findViewById(R.id.register);

        SpannableString content = new SpannableString(getResources().getString(
                R.string.register_here));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        registerTextView.setText(content);

        mEmailEditText = (EditText) findViewById(R.id.email);
        mPasswordEditText = (EditText) findViewById(R.id.password);
        mLoginButton = (Button) findViewById(R.id.login);
        languageSpinner = (Spinner) findViewById(R.id.locale_spinner);

        if (isHebrew){

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner_layout_heb, getResources().getStringArray(R.array.languages));
//            adapter.setDropDownViewResource(R.layout.spinner_item_layout);
            languageSpinner.setAdapter(adapter);
            languageSpinner.setSelection(1, true);
            languageSpinner.setBackgroundResource(R.drawable.spinner_background_for_heb);
            languageSpinner.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            languageSpinner.setTextDirection(View.TEXT_DIRECTION_ANY_RTL);
        }else{
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner_layout_eng, getResources().getStringArray(R.array.languages));
//            adapter.setDropDownViewResource(R.layout.spinner_item_layout);
            languageSpinner.setAdapter(adapter);
            languageSpinner.setSelection(0, true);
            languageSpinner.setBackgroundResource(R.drawable.spinner_background_for_eng);
            languageSpinner.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            languageSpinner.setTextDirection(View.TEXT_DIRECTION_ANY_RTL);
        }

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                login(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
                performLogin(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
            }
        });

        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

   /* public void login(final String user_email, final String user_pass) {


        pDialog = new ProgressDialog(
                MainActivity.this);
        pDialog.setMessage("Logging in...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();


        JSONObject jsonbObjj = new JSONObject();
        try {
            jsonbObjj.put("request", "login");
            jsonbObjj.put("email", user_email);
            jsonbObjj.put("password", user_pass);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Log.e("jsonbObjj", "" + jsonbObjj.toString());
        JsonObjectRequest loginRequest = new JsonObjectRequest(
                Request.Method.POST, URL, jsonbObjj,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        if (pDialog != null) {
                            pDialog.dismiss();
                        }
                        try {
                            if (jsonObject.getString("message").equals("success")) {
                                mUserSession.setUserId(jsonObject.getString("userid"));
                                mUserSession.setUserEmail(user_email);
                                mUserSession.setUserPassword(user_pass);
                                mUserSession.setUserLoggedIn(true);
                                mUserSession.setDisplayName(jsonObject.getString("display_name"));
                                Intent intent = new Intent(MainActivity.this, UserProfile.class);
                                startActivity(intent);
                                MainActivity.this.finish();
                            } else {
                                Toast.makeText(MainActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (pDialog != null) {
                    pDialog.dismiss();
                }
                Log.e("onErrorResponse", String.valueOf(error.getCause()));
            }
        }) {
            @Override
            protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
                try {
                    String jsonString = new String(response.data, "UTF-8");

                    return Response.success(new JSONObject(jsonString),
                            HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    return Response.error(new ParseError(e));
                } catch (JSONException je) {
                    return Response.error(new ParseError(je));
                }
            }
        };
        ApplicationController.getInstance().addToRequestQueue(loginRequest, "login");
    }*/

    private void performLogin(final String user_email, final String user_pass) {

        pDialog = new ProgressDialog(
                MainActivity.this);
        pDialog.setMessage(getResources().getString(R.string.login_message));
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();

        SetParams params = new SetParams("login", user_email, user_pass);
        APIService apiService = retrofit.create(APIService.class);

        Call<LoginData> apiCall = apiService.login(params);
        apiCall.enqueue(new Callback<LoginData>() {


            @Override
            public void onResponse(retrofit.Response<LoginData> loginData, Retrofit retrofit) {

                if (pDialog != null) {
                    pDialog.dismiss();
                }


                if (loginData.body() != null) {
                    mUserSession.setUserId(loginData.body().getUserid());
                    mUserSession.setUserToken(loginData.body().getToken());
                    mUserSession.setUserEmail(user_email);
                    mUserSession.setUserPassword(user_pass);
                    mUserSession.setUserLoggedIn(true);
                    mUserSession.setUserLanguage(languageSpinner.getSelectedItem().toString());
                    mUserSession.setDisplayName(loginData.body().getDisplay_name());
                    Intent intent = new Intent(MainActivity.this, OverViewActivity.class);
                    startActivity(intent);
                    MainActivity.this.finish();
                } else {
                    Toast.makeText(MainActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
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

}
