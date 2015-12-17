package com.pilot;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class SplashScreenActivity extends Activity {
    ImageView logo;
    private UserSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        logo = (ImageView) findViewById(R.id.logo_splash);
        session = new UserSession(SplashScreenActivity.this);

        new Handler().postDelayed(new Runnable() {

            @SuppressLint("PrivateResource")
            @Override
            public void run() {
                if (session.getUserLoggedIn()) {
                    Intent i = new Intent(SplashScreenActivity.this,
                            UserProfile.class);
                    overridePendingTransition(R.anim.abc_slide_out_bottom,
                            R.anim.abc_slide_in_top);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(SplashScreenActivity.this,
                            OverViewActivity.class);
                    overridePendingTransition(R.anim.abc_slide_out_bottom,
                            R.anim.abc_slide_in_top);
                    startActivity(i);
                    finish();
                }
            }
        }, 4000);
    }

}
