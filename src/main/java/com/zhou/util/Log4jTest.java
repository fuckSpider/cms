package com.zhou.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * 1. 输出在控制台，并且格式有所变化，如图所示，会显示是哪个类的哪一行输出的信息
 * 2. 不仅仅在控制台有输出，在把日志输出到了 ${projectPath}\example.log 这个位置
 */
public class Log4jTest {
    static Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        PropertyConfigurator.configure("E:\\java\\ideaProjects\\myShiro\\src\\main\\resources\\log4jTest.properties");
        for (int i = 0; i < 5000; i++) {
            logger.trace("跟踪信息");
            logger.debug("调试信息");
            logger.info("输出信息");
            logger.warn("警告信息");
            logger.error("错误信息");
            logger.fatal("致命信息");
        }
    }
}
