package com.newplan.base.util.mail;

import java.util.Properties;

/**
 * @author JoeTwan
 * @date 2021/9/20 22:18
 * @description
 */
public class SmtpProperties {
    public static Properties smtpDefaultProperties(){
        Properties properties=new Properties();
        properties.put("mail.transport.protocal", "smtp");
        properties.put("mail.store.protocal", "imap");
        properties.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.setProperty("mail.imap.socketFactory.fallback", "false");
        properties.setProperty("mail.imap.port", "993");
        properties.setProperty("mail.imap.socketFactory.port", "993");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.transport.class", "com.sun.mail.smtp.SMTPTransport");
        properties.put("mail.imap.class", "com.sun.mail.imap.IMAPStore");
        return properties;
    }
}
