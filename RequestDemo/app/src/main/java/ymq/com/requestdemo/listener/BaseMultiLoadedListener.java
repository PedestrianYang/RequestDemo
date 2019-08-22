package ymq.com.requestdemo.listener;

/**
 * Created by iyunshu on 2019/8/22.
 */

public interface BaseMultiLoadedListener<T> {
    /**
     * when data call back success
     *
     * @param event_tag
     * @param data
     */
    void onSuccess(int event_tag, T data);

    /**
     * when data call back error
     *
     * @param event_tag
     * @param msg
     */
    void onError(int event_tag, String msg);

    /**
     * when data call back occurred exception
     *
     * @param event_tag
     * @param msg
     */
    void onException(int event_tag, String msg);
}
