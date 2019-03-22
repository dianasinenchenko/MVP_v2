package com.devitis.mvp_v2;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Diana on 22.03.2019.
 */

public class Util {
    static Toast toast;
    public static String BASE_URL = "url...";

    public static void showToast(Context context, String message) {
        if (toast != null) toast.cancel();
        toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
