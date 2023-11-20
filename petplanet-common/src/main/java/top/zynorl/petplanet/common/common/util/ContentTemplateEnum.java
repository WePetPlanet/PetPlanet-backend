package top.zynorl.petplanet.common.common.util;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/20
 **/

import lombok.Getter;
import com.alibaba.fastjson.JSONObject;

/**
 * 字符拼接工具类
 */
@Getter
public enum ContentTemplateEnum {
    EXAMPLE("EXAMPLE",
            "{\n" +
                    "    \"id\":\"%s\",\n" +
                    "    \"name\":\"%s\"\n" +
                    "}");

    private final String code;
    private final String parameterJsonStr;

    ContentTemplateEnum(String code, String parameterJsonStr){
        this.code = code;
        this.parameterJsonStr = parameterJsonStr;
    }
    public JSONObject getParameterJson(String... strings){
        return JSONObject.parseObject(String.format(this.parameterJsonStr, strings));
    }

}
