package com.newplan.base.util.log;

import org.slf4j.Logger;

/**
 * @author JoeTwan
 * @date 2021/9/20 22:54
 * @description
 */
public class LoggerBase {
    private Logger logger = LoggerHelper.getInstance(this.getClass());

    protected void logErrorAndThrowRuntimeException(String method , Exception e){
        logger.error(String.format("method=%s",method),e);
        throw new RuntimeException(e);
    }
}
