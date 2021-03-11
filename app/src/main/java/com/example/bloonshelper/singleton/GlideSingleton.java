package com.example.bloonshelper.singleton;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.bloonshelper.R;

public class GlideSingleton {

    public static GlideSingleton instance;
    private RequestManager requestManager;

    public GlideSingleton(Context context) {
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        this.requestManager = Glide.with(context).setDefaultRequestOptions(options);
    }

    public static GlideSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new GlideSingleton(context);
        }
        return instance;
    }

    public RequestManager getRequestManager() {
        return requestManager;
    }
}
