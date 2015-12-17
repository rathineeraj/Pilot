package com.pilot;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

/**
 * Created by Neeraj Rathi on 12/16/2015.
 */
public class OverViewActivity extends AppCompatActivity {

    private Locale current;
    TextView Skip;

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
        } else {
            conf.locale = new Locale(current.getISO3Language());
        }
        res.updateConfiguration(conf, dm);

        setContentView(R.layout.activity_overview_screen);
        Skip=(TextView)findViewById(R.id.tvSkip);
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(OverViewActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
//        Toolbar toolbar = (Toolbar) findViewById(R.id.header);
//        toolbar.setNavigationIcon(R.drawable.back_button);

//        TextView actionBarText = (TextView) toolbar.findViewById(R.id.toolbar_title);
//        actionBarText.setText(getResources().getString(R.string.invitation_activity));

//        setSupportActionBar(toolbar);

        try {
//            getSupportActionBar().setDisplayShowTitleEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openProfileScreen(View view){


        startActivity(new Intent(OverViewActivity.this, UserProfile.class));
        OverViewActivity.this.finish();
    }
}
