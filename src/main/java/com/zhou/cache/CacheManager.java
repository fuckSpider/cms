package com.zhou.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CacheManager implements ICacheManager {
    private static Map<String,EntityCache> caches = new ConcurrentHashMap<>();

    @Override
    public void putCache(String key, EntityCache entityCache) {
        caches.put(key,entityCache);
    }

    @Override
    public void putCache(String key, Object data, long timeout) {
        timeout=timeout>0?timeout:0L;
        EntityCache entityCache = new EntityCache(key,timeout,System.currentTimeMillis());
        caches.put(key,entityCache);
    }

    @Override
    public EntityCache getCacheByKey(String key) {
        if(this.isContains(key)){
            return caches.get(key);
        }
         return null;
    }

    @Override
    public Object getCacheDataByKey(String key) {
        if(this.isContains(key)){
            return caches.get(key).getData();
        }
        return null;
    }

    @Override
    public Map<String, EntityCache> getCacheAll() {
        return caches;
    }

    @Override
    public boolean isContains(String key) {
        return caches.containsKey(key);
    }

    @Override
    public void clearAll() {
        caches.clear();
    }

    @Override
    public void clearByKey(String key) {
        if(this.isContains(key)){
            caches.remove(key);
        }
    }

    @Override
    public boolean isTimeOut(String key) {
        if(this.isContains(key)){
            return true;
        }
        EntityCache entityCache = caches.get(key);
        long timeout = entityCache.getTimeOut();
        long lastRefeshTime = entityCache.getLastRefeshTime();
        if(timeout==0||System.currentTimeMillis()-lastRefeshTime>timeout){
            return true;
        }
        return false;
    }

    @Override
    public Set<String> getAllKeys() {
        return caches.keySet();
    }
}
