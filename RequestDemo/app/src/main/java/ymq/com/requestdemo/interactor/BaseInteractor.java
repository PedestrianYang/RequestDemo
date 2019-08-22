package ymq.com.requestdemo.interactor;

import java.util.HashMap;

/**
 * Created by iyunshu on 2019/8/22.
 */

public interface BaseInteractor {
    void post(String requestTag, int event_tag, HashMap<String, String> params, String url, boolean cancelAll, boolean isTest);

    void get(String requestTag, int event_tag, HashMap<String, String> params, String url, boolean cancelAll, boolean isTest);
}
