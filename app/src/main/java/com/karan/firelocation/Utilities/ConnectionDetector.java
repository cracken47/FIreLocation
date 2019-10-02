package com.karan.firelocation.Utilities;

import android.content.Context;
import android.net.ConnectivityManager;

import java.util.Objects;

public class ConnectionDetector {
    private Context mContext;

    public ConnectionDetector(Context context) {
        this.mContext = context;
    }

    public boolean isConnectingToInternet() {

        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        return Objects.requireNonNull(cm).getActiveNetworkInfo() != null && Objects.requireNonNull(cm.getActiveNetworkInfo()).isConnected();

    }
}
