package com.ronald.sdktest;

import android.util.Log;

import com.tune.TuneListener;

import org.json.JSONObject;

/**
 * Created by ronald on 9/28/16.
 */

public class TuneListenerImpl implements TuneListener {
    @Override
    public void enqueuedActionWithRefId(String refId) {
        // call has been queued, will be sent later
    }

    @Override
    public void enqueuedRequest(String url, JSONObject postData) {
        // call has been queued, will be sent later
    }

    @Override
    public void didSucceedWithData(JSONObject data) {
        Log.d("TUNE.success", data.toString());
    }

    @Override
    public void didFailWithError(JSONObject error) {
        Log.d("TUNE.failure", error.toString());
    }
}