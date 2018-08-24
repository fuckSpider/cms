package com.zhou.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    static Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args) throws InterruptedException {
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        Thread.sleep(1000);
        logger.warn("警告信息");
        logger.error("错误信息");
    }
}
