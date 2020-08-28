package org.apache.dubbo.demo;

/**
 * @author wangyuanqing1
 * 2020-08-26
 */
public class Result<T> {
    private T data;
    private boolean success;
    private String msg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", success=" + success +
                ", msg='" + msg + '\'' +
                '}';
    }
}
