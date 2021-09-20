package com.newplan.base.util.mail;

import com.google.common.base.Preconditions;
import com.newplan.base.util.log.LoggerHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.util.Date;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * 简单发送和接收邮件
 *
 * @author u1
 */
public class EmailSendClient {

    private static Logger logger = LoggerHelper.getInstance(EmailSendClient.class);

    private Session session;
    private Store store;
    private MailProperties mailProperties;

    public static void main(String[] args) {
        EmailSendClient emailSendClient = EmailSendClient.getInstance(new MailProperties());
        try {
            ComplexEmailContent complexEmailContent = new ComplexEmailContent();
            complexEmailContent.appendText("这是一封测试邮件");

            emailSendClient.send(EmailMessageDto.builder()
                    .fromAddress("1692603568@qq.com")
                    .toAddress("xiaoduan0320@163.com")
                    .complexEmailContent(complexEmailContent)
                    .subject("主题")
                    .sendDate(new Date())
                    .build());
        } catch (Exception e) {
            logger.error("cause error", e);
        }finally {
            emailSendClient.close();
        }
    }

    public static EmailSendClient getInstance(MailProperties mailProperties) {
        return new EmailSendClient(mailProperties);
    }

    private EmailSendClient(MailProperties mailProperties) {
        Preconditions.checkNotNull(mailProperties);
        Properties properties = ProtocolAdapter.adaptDefaultProperties(mailProperties.getProtocol());
        properties.put("mail.smtp.host", mailProperties.getHost());
        initEmailClient(mailProperties, properties);
        this.mailProperties = mailProperties;
    }

    private void initEmailClient(MailProperties mailProperties, Properties properties) {
        try {
            session = Session.getDefaultInstance(properties, new MailAuthenticator(mailProperties.getAccount(), mailProperties.getEncryptKey()));
            store = session.getStore("imap");
            store.connect(mailProperties.getReceiveHost(), null, null);
        } catch (MessagingException e) {
            logger.error("method=initEmailClient", e);
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            store.close();
        } catch (MessagingException e) {
            logger.error("method=close", e);
            throw new RuntimeException(e);
        }
    }

    private Message createMessage(EmailMessageDto emailMessageDto) {
        try {
            MimeMessage message = new MimeMessage(session);
            if (StringUtils.isNotEmpty(this.mailProperties.getAccount())) {
                message.setFrom(new InternetAddress(this.mailProperties.getAccount()));
            }
            if (StringUtils.isNotEmpty(emailMessageDto.getToAddress())) {
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(emailMessageDto.getToAddress()));
            }
            if (StringUtils.isNotEmpty(emailMessageDto.getSubject())) {
                message.setSubject(emailMessageDto.getSubject());
            }
            if (emailMessageDto.getComplexEmailContent() != null) {
                message.setContent(emailMessageDto.getComplexEmailContent().parseContent());
            }
            if (emailMessageDto.getSendDate() != null) {
                message.setSentDate(emailMessageDto.getSendDate());
            }

            return message;
        } catch (MessagingException e) {
            logger.error("method=createSimpleMessage", e);
            throw new RuntimeException(e);
        }
    }

    public void send(EmailMessageDto emailMessageDto) throws MessagingException {
        Transport.send(createMessage(emailMessageDto));
    }


    /**
     * 登陆认证
     *
     * @author u1
     */
    private static class MailAuthenticator extends Authenticator {

        private String username;
        private String encryptCode;

        MailAuthenticator(String username, String encryptCode) {
            this.username = username;
            this.encryptCode = encryptCode;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, encryptCode);
        }
    }
}