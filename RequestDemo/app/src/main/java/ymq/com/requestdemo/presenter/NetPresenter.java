package ymq.com.requestdemo.presenter;

import java.util.HashMap;

/**
 * Created by iyunshu on 2019/8/22.
 */

public interface NetPresenter {
    void doPost(String requestTag, int event_tag, String url, HashMap<String, String> param, boolean isTest);
    void doGet(String requestTag, int event_tag, String url, HashMap<String, String> param, boolean isTest);
}
