package ymq.com.requestdemo.interactor.impl;

import android.text.TextUtils;

import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

import ymq.com.android.volley.AuthFailureError;
import ymq.com.android.volley.DefaultRetryPolicy;
import ymq.com.android.volley.Response;
import ymq.com.android.volley.VolleyError;
import ymq.com.android.volley.toolbox.GsonRequest;
import ymq.com.requestdemo.AppContext;
import ymq.com.requestdemo.interactor.BaseInteractor;
import ymq.com.requestdemo.listener.BaseMultiLoadedListener;
import ymq.com.requestdemo.model.ResponseBean;
import ymq.com.requestdemo.util.URLUtil;
import ymq.com.requestdemo.util.VolleyHelper;

/**
 * Created by iyunshu on 2019/8/22.
 */

public class BaseInteractorImpl implements BaseInteractor {

    private BaseMultiLoadedListener<ResponseBean> loadedListener = null;

    public BaseInteractorImpl(BaseMultiLoadedListener<ResponseBean> loadedListener) {
        this.loadedListener = loadedListener;
    }

    @Override
    public void post(String requestTag, final int event_tag, final HashMap<String, String> params, String url, boolean cancelAll, boolean isTest) {
        GsonRequest<ResponseBean> gsonRequest = new GsonRequest<ResponseBean>(
                isTest? URLUtil.getTestUrl(AppContext.getInstance().context, url) : URLUtil.getUrl(AppContext.getInstance().context, url),
                new TypeToken<ResponseBean>() {
                }.getType(),
                new Response.Listener<ResponseBean>() {
                    @Override
                    public void onResponse(ResponseBean response) {
                        loadedListener.onSuccess(event_tag, response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loadedListener.onException(event_tag, error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                return params;
            }
        };
        doRequest(gsonRequest,requestTag,isTest);
    }

    @Override
    public void get(String requestTag, final int event_tag, HashMap<String, String> params, String url, boolean cancelAll, boolean isTest) {
        String paramString = URLUtil.getUrlParamsByMap(params);
        String fullURL = isTest? URLUtil.getTestUrl(AppContext.getInstance().context, url) : URLUtil.getUrl(AppContext.getInstance().context, url);
        if (!TextUtils.isEmpty(paramString)){
            fullURL = fullURL + "?" + paramString;
        }
        GsonRequest<ResponseBean> gsonRequest = new GsonRequest<ResponseBean>(
                fullURL,
                null,
                new TypeToken<ResponseBean>() {
                }.getType(),
                new Response.Listener<ResponseBean>() {
                    @Override
                    public void onResponse(ResponseBean response) {
                        loadedListener.onSuccess(event_tag, response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loadedListener.onException(event_tag, error.getMessage());
                    }
                }
        ) ;
        doRequest(gsonRequest,requestTag,isTest);
    }

    private void doRequest(GsonRequest<ResponseBean> gsonRequest, final String requestTag, boolean cancelAll){

        gsonRequest.setShouldCache(false);
        gsonRequest.setTag(requestTag);
        gsonRequest.setRetryPolicy(new DefaultRetryPolicy(60000, 0, 1f));

        if (cancelAll){
            //取消之前的请求，避免前一次请求未完成再次请求
            VolleyHelper.getInstance().getRequestQueue().cancelAll(requestTag);
        }

        VolleyHelper.getInstance().getRequestQueue().add(gsonRequest);
    }
}
