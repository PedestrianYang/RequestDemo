package ymq.com.requestdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import java.util.HashMap;

import ymq.com.requestdemo.presenter.NetPresenter;
import ymq.com.requestdemo.presenter.impl.NetPresenterImpl;
import ymq.com.requestdemo.view.BaseView;

/**
 * Created by iyunshu on 2019/8/22.
 */

public class BaseActivity extends FragmentActivity implements BaseView {
    private NetPresenter networkImpl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        networkImpl = new NetPresenterImpl(this);
    }

    protected void postNetwork(int tag, String url, HashMap<String, String> requestParams, boolean isTest) {
        networkImpl.doPost(this.getClass().getSimpleName(), tag, url, requestParams, isTest);
    }

    protected void getNetwork(int tag, String url, HashMap<String, String> requestParams, boolean isTest) {
        networkImpl.doGet(this.getClass().getSimpleName(), tag, url, requestParams, isTest);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onSuccess(int event_tag, int status, Object data) {

    }

    @Override
    public void onFail(int event_tag, int status, String message) {

    }
}
