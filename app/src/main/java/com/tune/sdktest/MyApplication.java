package com.tune.sdktest;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;

import com.tune.Tune;
import com.tune.ma.application.TuneApplication;
import com.tune.ma.configuration.TuneConfiguration;

/**
 * Created by ronald on 9/28/16.
 */

public class MyApplication extends TuneApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        TuneConfiguration tc = new TuneConfiguration();
        tc.setPlaylistHostPort("http://192.168.139.192:3000");
        tc.setConfigurationHostPort("http://192.168.139.192:3000");
        tc.setAnalyticsHostPort("http://192.168.139.192:3000/analytics");
        tc.setConnectedModeHostPort("http://192.168.139.192:3000");

        Tune.init(this, "190163", "198dacaee0fd940d83ad259a27ec6fd5", true, tc);

        Tune.getInstance().registerPowerHook("powerHook", "First power hook", "2");
    }
}
