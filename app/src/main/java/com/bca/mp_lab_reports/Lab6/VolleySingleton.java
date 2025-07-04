package com.bca.mp_lab_reports.Lab6;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static VolleySingleton instance;
    private RequestQueue queue;

    private VolleySingleton(Context context) {
        queue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleySingleton getInstance(Context context) {
        if (instance == null)
            instance = new VolleySingleton(context);
        return instance;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        queue.add(request);
    }
}
