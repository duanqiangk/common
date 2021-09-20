package com.newplan.base.util.mail;

import com.newplan.base.util.log.LoggerHelper;
import org.slf4j.Logger;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import java.io.File;

/**
 * @author JoeTwan
 * @date 2021/9/20 22:44
 * @description
 */
public class ComplexEmailContent {

    private static Logger logger = LoggerHelper.getInstance(ComplexEmailContent.class);

    private Multipart multipart ;

    public ComplexEmailContent(){
        this.multipart = new MimeMultipart();
    }

    public ComplexEmailContent appendText(String textString){
        BodyPart bodyPart =new MimeBodyPart();
        try {
            bodyPart.setText(textString);
            this.multipart.addBodyPart(bodyPart);
            return this;
        } catch (MessagingException e) {
            logger.error("method=appendText",e);
            throw new RuntimeException(e);
        }
    }


    public ComplexEmailContent appendResourceFile(File file , String fileName){
        try {
            MimeBodyPart bodyPart2=new MimeBodyPart();
            DataHandler dh = new DataHandler(new FileDataSource(file));
            bodyPart2.setDataHandler(dh);
            bodyPart2.setDisposition(Part.ATTACHMENT);
            bodyPart2.setFileName(fileName);
            this.multipart.addBodyPart(bodyPart2);
            return this;
        } catch (MessagingException e) {
            logger.error("method=appendResourceFile",e);
            throw new RuntimeException(e);
        }
    }

    public Multipart parseContent(){
        return this.multipart;
    }
}
