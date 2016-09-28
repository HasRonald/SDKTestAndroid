package com.ronald.sdktest;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.tune.Tune;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tune.init(this, "190163", "198dacaee0fd940d83ad259a27ec6fd5");

        Tune.getInstance().setDebugMode(true);

        Tune.getInstance().setReferralSources(this);
        Tune.getInstance().setAndroidId(Secure.getString(getContentResolver(), Secure.ANDROID_ID));
        String deviceId = ((TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        Tune.getInstance().setDeviceId(deviceId);
        try {
            WifiManager wm = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            Tune.getInstance().setMacAddress(wm.getConnectionInfo().getMacAddress());
        } catch (NullPointerException e) {
        }

        Tune.getInstance().setListener(new TuneListenerImpl());

        Tune.getInstance().measureSession();
    }
}
