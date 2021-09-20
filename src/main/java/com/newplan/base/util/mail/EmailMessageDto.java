package com.newplan.base.util.mail;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author JoeTwan
 * @date 2021/9/20 22:31
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailMessageDto {
    private String fromAddress;
    private String toAddress;
    private String subject;
    private Date sendDate;
    private ComplexEmailContent complexEmailContent;
}
