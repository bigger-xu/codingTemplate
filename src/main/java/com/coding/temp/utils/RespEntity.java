package com.coding.temp.utils;

/**
 * @author Xyang Song
 */
public class RespEntity<T> {

    protected Key key;
    protected String msg;
    protected T data;

    protected long sum;

    public RespEntity() {
    }

    public RespEntity(Key key) {
        this.key = key;
        this.msg = key.name();
    }

    public RespEntity(Key key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    public RespEntity(T data,long sum) {
        ok();
        this.data = data;
        this.sum = sum ;
    }

    public static <T> RespEntity<T> ok() {
        return new RespEntity<>(Key.OK, "OK");
    }

    public static <T> RespEntity<T> ok(T data) {
        RespEntity<T> resp = ok();
        resp.setData(data);
        return resp;
    }

    public static <T> RespEntity<T> error() {
        return new RespEntity<>(Key.ERROR);
    }

    public static <T> RespEntity<T> error(String msg) {
        RespEntity<T> resp = new RespEntity<>(Key.ERROR);
        resp.setMsg(msg);
        return resp;
    }

    public static <T> RespEntity<T> error(String msg,T data) {
        RespEntity<T> resp = new RespEntity<>(Key.ERROR);
        resp.setMsg(msg);
        resp.setData(data);
        return resp;
    }


    public Key getKey() {
        return key;
    }

    public RespEntity setKey(Key key) {
        this.key = key;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RespEntity setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RespEntity setData(T data) {
        this.data = data;
        return this;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }
}
