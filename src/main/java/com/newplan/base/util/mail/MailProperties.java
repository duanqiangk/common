package com.newplan.base.util.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author JoeTwan
 * @date 2021/9/20 21:17
 * @description Mail Client Properties
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailProperties {

    private String encryptKey ;

    private String account ;

    private String host ;

    private String receiveHost;

    private MailProtocolTypeEnum protocol ;

}
