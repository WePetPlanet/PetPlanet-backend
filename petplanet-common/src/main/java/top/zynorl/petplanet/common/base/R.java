package top.zynorl.petplanet.common.base;

/**
 *
 * Created by zynorl on 2023/11/10 19:59
 */

import lombok.Data;

import java.io.Serializable;

/**
 * 通用响应结构类
 * @param <T>
 */
@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 响应状态码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 相关异常
     */
    private Throwable throwable;

    /**
     * 响应结果数据
     */
    private T data;

    public static <T> R<T> result(Integer code, String message, T data){
        R<T> tr = new R<>();
        tr.setCode(code);
        tr.setMessage(message);
        tr.setData(data);
        return tr;
    }

    public static <T> R<T> ok(T data){
        R<T> tr = new R<>();
        tr.setCode(200);
        tr.setMessage("success");
        tr.setData(data);
        return tr;
    }

    public static <T> R<T> no(String message){
        R<T> tr = new R<>();
        tr.setCode(500);
        tr.setMessage(message);
        return tr;
    }
    public static <T> R<T> resultDetail(Integer code, String message, Throwable throwable, T data){
        R<T> tr = new R<>();
        tr.setCode(code);
        tr.setMessage(message);
        tr.setThrowable(throwable);
        tr.setData(data);
        return tr;
    }

}
