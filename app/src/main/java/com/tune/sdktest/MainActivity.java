package com.tune.sdktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.tune.Tune;
import com.tune.TuneEvent;
import com.tune.ma.TuneManager;
import com.tune.ma.analytics.model.event.push.TunePushEnabledEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tune.getInstance().setPushNotificationSenderId("886668531703");



        findViewById(R.id.btnSubmit).setOnClickListener(new View.OnClickListener()
        {
           public void onClick(View v)
            {
                //EditText  e =  (EditText) findViewById(R.id.txtEvent);
                //Tune.getInstance().measureEvent(new TuneEvent(e.getText().toString()));

                TuneManager.getInstance().getAnalyticsManager().storeAndTrackAnalyticsEvent(true, new TunePushEnabledEvent(true));
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
}
