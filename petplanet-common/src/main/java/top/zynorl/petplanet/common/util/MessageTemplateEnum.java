package top.zynorl.petplanet.common.util;

import lombok.Getter;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/12/26
 **/
@Getter
public enum MessageTemplateEnum {
    EXAMPLE("example message:%s", "这个一个示例");
    /**
     * 消息模版
     */
    private final String msg;
    /**
     * 消息描述
     */
    private final String des;
    MessageTemplateEnum(String msg, String des){
        this.msg = msg;
        this.des = des;
    }

    /**
     * 获取消息
     * @param strings
     * @return
     */
    public String getString(String... strings){
        return String.format(msg, (Object) strings);
    }
}
