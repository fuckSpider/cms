package com.zhou.cache;

import org.apache.log4j.Logger;

public class CacheListener {
    Logger logger = Logger.getLogger(CacheListener.class);
    private CacheManager cacheManager;

    public CacheListener(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    public void startListen(){
        new Thread(){
            @Override
            public void run() {
                while(true){
                    for(String key:cacheManager.getAllKeys()){
                        if(cacheManager.isTimeOut(key)){
                            cacheManager.clearByKey(key);
                            logger.info(key+"缓存被清除");
                        }
                    }
                }
            }
        }.start();
    }


}
