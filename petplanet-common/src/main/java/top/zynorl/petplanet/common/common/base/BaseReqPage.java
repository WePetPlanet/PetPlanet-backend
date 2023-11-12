package top.zynorl.petplanet.common.common.base;

import lombok.Data;

/**
 * Created by zynorl on 2023/11/10 19:45
 */

/**
 * 基本响应请求类
 */
@Data
public class BaseReqPage {
    /**
     * 请求分页的页码，从1开始
     */
    private Integer pageNum;
    /**
     * 请求分页的大小
     */
    private Integer pageSize;
}
