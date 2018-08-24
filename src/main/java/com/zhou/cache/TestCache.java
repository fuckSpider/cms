package com.zhou.cache;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class TestCache {
    Logger logger = Logger.getLogger(TestCache.class);
    @Test
    public void testCacheManager(){
        CacheManager cacheManager = new CacheManager();
        cacheManager.putCache("test","test",10*1000L);
        cacheManager.putCache("myTest","myTest",20*1000L);
        CacheListener cacheListener = new CacheListener(cacheManager);
        cacheListener.startListen();

        logger.info("test:" + cacheManager.getCacheByKey("test").getData());
        logger.info("myTest:" + cacheManager.getCacheByKey("myTest").getData());
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("test:" + cacheManager.getCacheByKey("test"));
        logger.info("myTest:" + cacheManager.getCacheByKey("myTest"));
    }


    @Test
    public void testThredSafe() {
        final String key = "thread";
        final CacheManager cacheManager = new CacheManager();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            exec.execute(new Runnable() {
                public void run() {
                    if (!cacheManager.isContains(key)) {
                        cacheManager.putCache(key, 1, 0);
                    } else {
                        //因为+1和赋值操作不是原子性的，所以把它用synchronize块包起来
                        synchronized (cacheManager) {
                            int value = Integer.parseInt( cacheManager.getCacheDataByKey(key).toString()) + 1;
                            cacheManager.putCache(key, value, 0);
                        }
                    }
                }
            });
        }
        exec.shutdown();
        try {
            exec.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        logger.info(cacheManager.getCacheDataByKey(key).toString());
    }
    }
