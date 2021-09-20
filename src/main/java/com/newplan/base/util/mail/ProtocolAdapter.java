package com.newplan.base.util.mail;

import com.newplan.base.util.log.LoggerHelper;
import org.slf4j.Logger;

import java.util.Properties;

/**
 * @author JoeTwan
 * @date 2021/9/20 22:20
 * @description
 */
public class ProtocolAdapter {

    private static Logger logger = LoggerHelper.getInstance(ProtocolAdapter.class);

    public static Properties adaptDefaultProperties(MailProtocolTypeEnum protocolTypeEnum){
        if(protocolTypeEnum == MailProtocolTypeEnum.SMTP){
            return SmtpProperties.smtpDefaultProperties();
        }

        logger.error("method=adaptDefaultProperties,failed to init properties,param={}",protocolTypeEnum);
        throw new RuntimeException("IllegalParamException,failed to init Mail Properties");
    }
}
