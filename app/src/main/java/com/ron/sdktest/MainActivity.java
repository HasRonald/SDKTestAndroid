package com.ron.sdktest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tune.Tune;
import com.tune.TuneEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tune.getInstance().setPushNotificationSenderId("139959513267");



        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener()
        {
           public void onClick(View v)
            {
                EditText  e =  (EditText) findViewById(R.id.txtEvent);
                Tune.getInstance().measureEvent(new TuneEvent(e.getText().toString()));
                //Tune.getInstance().measureEvent(new TuneEvent("happy").withTagAsString("open_log_i썐", "1392d116c0bbe049efc8255c5a696675-20161005-191323"));

                //TuneManager.getInstance().getAnalyticsManager().storeAndTrackAnalyticsEvent(true, new TunePushEnabledEvent(true));
            }
        });

        findViewById(R.id.btnSubmit2).setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                EditText  e =  (EditText) findViewById(R.id.txtCustom);
                EditText  e2 =  (EditText) findViewById(R.id.txtCustom2);

                Tune.getInstance().registerCustomProfileString(e.getText().toString(), e2.getText().toString());
                //Tune.getInstance().measureEvent(new TuneEvent("happy").withTagAsString("open_log_i썐", "1392d116c0bbe049efc8255c5a696675-20161005-191323"));

                //TuneManager.getInstance().getAnalyticsManager().storeAndTrackAnalyticsEvent(true, new TunePushEnabledEvent(true));
            }
        });

        //Log.d("=======", Tune.getInstance().getValueForHookById("powerHook"));
    }

    @Override
    public void onResume() {
        super.onResume();
        // Get source of open for app re-engagement
        Tune.getInstance().setReferralSources(this);
        // Attribution Analytics will not function unless the measureSession call is included
        Tune.getInstance().measureSession();
    }

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
