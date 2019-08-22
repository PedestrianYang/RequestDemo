package ymq.com.requestdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by iyunshu on 2019/8/22.
 */

public class AppContext extends Application {
    public Context context;
    private static AppContext appContext;

    public static AppContext getInstance() {
        return appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
        context = getApplicationContext();
    }
}
