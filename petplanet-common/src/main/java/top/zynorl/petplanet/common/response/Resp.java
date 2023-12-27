package top.zynorl.petplanet.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一封装响应类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resp<T> {
    //状态码
    private int code;
    //响应信息
    private String message;
    //响应数据
    private T data;

    public Resp SUCCESS(T data) {
        code = 200;
        message = "响应成功";
        this.data = data;
        return this;
    }

    public Resp FAIL(T data) {
        code = 400;
        message = "响应失败";
        this.data = data;
        return this;
    }



    /**
     * 方便链式调用
     * @param code
     * @return
     */
    public Resp setCode(int code) {
        this.code = code;
        return this;
    }

    public Resp setMessage(String message) {
        this.message = message;
        return this;
    }

    public Resp setData(T data) {
        this.data = data;
        return this;
    }


}
