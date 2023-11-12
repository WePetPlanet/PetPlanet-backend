package top.zynorl.petplanet.common.common.base;

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
     * 响应结果数据
     */
    private T data;

}
