package ymq.com.requestdemo.view;

/**
 * Created by iyunshu on 2019/8/22.
 */

public interface BaseView<T> {
    /**
     * when data call back success
     *
     * @param status
     * @param data
     */
    void onSuccess(int event_tag, int status, T data);

    /**
     * when data call back error
     *
     * @param status
     * @param message
     */
    void onFail(int event_tag, int status, String message);
}
