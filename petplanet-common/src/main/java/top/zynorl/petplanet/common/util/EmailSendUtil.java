package top.zynorl.petplanet.common.util;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/12/25
 **/

@Slf4j
@Component
public class EmailSendUtil {

    public void sendEmail(String subject, String context, List<String> receivers) {
        MailAccount mailAccount = new MailAccount();
        mailAccount.setHost("");
        mailAccount.setPort(0);
        mailAccount.setAuth(true);
        mailAccount.setUser("");
        mailAccount.setPass("");
        mailAccount.setSslEnable(true);
        mailAccount.setFrom("");
        try {
            MailUtil.send(mailAccount, receivers, subject, context, false);
            log.debug("Email sent successfully.");
        } catch (Exception e) {
            log.error("Email sent failed." + e);
            throw new RuntimeException("Email sent failed.");
        }
    }
}
