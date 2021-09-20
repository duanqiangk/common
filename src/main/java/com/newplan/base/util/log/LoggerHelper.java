package com.newplan.base.util.log;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @author JoeTwan
 * @date 2021/9/20 22:04
 * @description Logger Base
 */
public class LoggerHelper {

    public static <T> Logger getInstance(Class<T> tClass) {
        String path = Objects.requireNonNull(LoggerHelper.class.getClassLoader().getResource("")).getPath();
        PropertyConfigurator.configure(path + "log4j2.xml");
        return LoggerFactory.getLogger(tClass);
    }
}
