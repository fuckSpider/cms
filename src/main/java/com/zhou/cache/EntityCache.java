package com.zhou.cache;

import java.io.Serializable;

public class EntityCache implements Serializable {
    //保存的数据
    private Object data;
    //设置缓存失效时间
    private long timeOut;
    //缓存的最后刷新时间
    private long lastRefeshTime;

    public EntityCache(Object data, long timeOut, long lastRefeshTime) {
        this.data = data;
        this.timeOut = timeOut;
        this.lastRefeshTime = lastRefeshTime;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public long getLastRefeshTime() {
        return lastRefeshTime;
    }

    public void setLastRefeshTime(long lastRefeshTime) {
        this.lastRefeshTime = lastRefeshTime;
    }
}
