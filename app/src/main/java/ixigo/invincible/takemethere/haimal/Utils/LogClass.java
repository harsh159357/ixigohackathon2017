package ixigo.invincible.takemethere.haimal.Utils;

import android.util.Log;

/**
 * <h1>Class being used to perform all the logging operations in the application.</h1>
 * Note: Logs will all be displayed in the error section and only if the app is in DEBUG mode.
 *
 * @author Haimal Khetan
 * @version 1.0
 * @since 20/4/2016
 */
public class LogClass {
    public static void displayLog(String TAG, String Message) {
      /*  if (BuildConfig.DEBUG) {*/
        try {
            Log.e(TAG, Message);
        } catch (Exception e) {
            Log.e("LogClass", e.getMessage());
        }
        //}
    }
}
