package top.zynorl.petplanet.common.enums;

import lombok.Getter;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/05
 **/
@Getter
public enum TransactionStatusEnum {
    STARTED("started", "事务开始", "本地保存"),
    SUCCESS("success", "事务执行成功", "收到ack"),
    FAILED("failed", "事务执行失败", "未收到ack");

    private final String code;
    private final String name;
    private final String desc;
    TransactionStatusEnum(String code, String name, String desc){
        this.code = code;
        this.name = name;
        this.desc = desc;
    }
}
