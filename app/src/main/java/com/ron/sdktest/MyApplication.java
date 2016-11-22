package com.ron.sdktest;

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

        tc.setAnalyticsHostPort("https://qa.ma.tune.com:8443/analytics-receiver/analytics");
        tc.setPlaylistHostPort("http://192.168.139.107:3000");
        tc.setConfigurationHostPort("http://192.168.139.107:3000");
        tc.setConnectedModeHostPort("http://192.168.139.107:3000");
        tc.setStaticContentHostPort("https://s3.amazonaws.com/uploaded-assets-qa2");

        tc.setAnalyticsHostPort("https://qa.ma.tune.com:8443/analytics-receiver/analytics");
        tc.setConfigurationHostPort("https://qa.ma.tune.com");
        tc.setPlaylistHostPort("https://qa.ma.tune.com");
        tc.setConnectedModeHostPort("https://qa.ma.tune.com");
        tc.setStaticContentHostPort("https://s3.amazonaws.com/uploaded-assets-qa2");

        Tune.init(this, "190163", "198dacaee0fd940d83ad259a27ec6fd5", true, tc);

        Tune.getInstance().registerPowerHook("powerHook", "First power hook", "2");
    }
}
