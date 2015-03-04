package com.matrix.mym.utils;

import org.apache.http.entity.StringEntity;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class MymRestClient {
	private static final String BASE_URL = "http://bullrun2.herokuapp.com";
	private static AsyncHttpClient client = new AsyncHttpClient();

	public static void get(String url, RequestParams params,
			JsonHttpResponseHandler responseHandler) {
		client.addHeader("Accept", "application/json");
        try {
		client.get(getAbsoluteUrl(url), params, responseHandler);
        }
        catch (Exception e){

            Log.d("Get",e.toString());
            Log.d("Get",client.toString());
        }
	}

	public static void post(Context context, String url, StringEntity entity,
			JsonHttpResponseHandler responseHandler) {
		client.addHeader("Accept", "application/json");
        try {
            client.post(context, getAbsoluteUrl(url), entity, "application/json",
                    responseHandler);
            Log.d("TryPost",client.toString());
            Log.d("TryPost",responseHandler.toString());
        }
        catch (Exception e){
            Log.d("Post",e.toString());
            Log.d("Post",client.toString());
        }
	}

	private static String getAbsoluteUrl(String relativeUrl) {
        Log.i("getAbsoluteUrl",BASE_URL + relativeUrl);
        return BASE_URL + relativeUrl;
	}

}
