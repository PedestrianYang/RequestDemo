package ymq.com.requestdemo.presenter.impl;

import java.util.HashMap;

import ymq.com.requestdemo.interactor.BaseInteractor;
import ymq.com.requestdemo.interactor.impl.BaseInteractorImpl;
import ymq.com.requestdemo.listener.BaseMultiLoadedListener;
import ymq.com.requestdemo.model.ResponseBean;
import ymq.com.requestdemo.presenter.NetPresenter;
import ymq.com.requestdemo.view.BaseView;

/**
 * Created by iyunshu on 2019/8/22.
 */

public class NetPresenterImpl implements NetPresenter, BaseMultiLoadedListener<ResponseBean> {
    public BaseInteractor mInteractor;
    public BaseView mView;

    public NetPresenterImpl(BaseView mView) {
        this.mView = mView;
        this.mInteractor = new BaseInteractorImpl(this);
    }

    @Override
    public void doPost(String requestTag, int event_tag, String url, HashMap<String, String> param, boolean isTest) {
        mInteractor.post(requestTag, event_tag,param, url, true, isTest);
    }

    @Override
    public void doGet(String requestTag, int event_tag, String url, HashMap<String, String> param, boolean isTest) {
        mInteractor.post(requestTag, event_tag,param, url, true, isTest);
    }

    @Override
    public void onSuccess(int event_tag, ResponseBean data) {
        mView.onSuccess(event_tag, 1, data);
    }

    @Override
    public void onError(int event_tag, String msg) {
        fail(event_tag, msg);
    }

    @Override
    public void onException(int event_tag, String msg) {
        fail(event_tag, msg);
    }

    private void fail(int event_tag, String msg){
        mView.onFail(event_tag, 0, msg);
    }
}
