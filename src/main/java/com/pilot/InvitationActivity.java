package com.pilot;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

import java.util.Locale;

/**
 * Created by Neeraj Rathi on 12/16/2015.
 */

public class InvitationActivity extends AppCompatActivity {

    private Locale current;
    boolean isHebrew;

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

        setContentView(R.layout.activity_invitation_code);
        Toolbar toolbar = (Toolbar) findViewById(R.id.header);
//        toolbar.setNavigationIcon(R.drawable.back_button);

        TextView actionBarText = (TextView) toolbar.findViewById(R.id.toolbar_title);
        actionBarText.setText(getResources().getString(R.string.invitation_activity));

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
