package ymq.com.requestdemo.model;

import com.alibaba.fastjson.JSON;

/**
 * Created by iyunshu on 2019/8/22.
 */

public class ResponseBean {
    private int status; //状态，成功还是失败
    private String message; //提示信息
    private Object data; //成功返回的结果数据

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
