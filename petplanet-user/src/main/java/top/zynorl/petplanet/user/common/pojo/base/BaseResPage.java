package top.zynorl.petplanet.user.common.pojo.base;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zynorl on 2023/11/10 19:49
 */

/**
 * 基本分页响应类
 * @param <T>
 */
@Data
@Accessors(chain = true)
public class BaseResPage<T> implements Serializable {

    /**
     * 分页的总页数
     */
    private Integer pages;

    /**
     * 总记录数
     */
    private Long total;


    /**
     * 当前请求页数据量
     */
    private int size;

    /**
     * 当前请求页的响应数据
     */
    List<T> list;


    public BaseResPage(){

    }

    /**
     * 根据PageInfo赋值
     * @param pageInfo
     */
    public BaseResPage(PageInfo<T> pageInfo){
        this.total = pageInfo.getTotal();
        this.pages = pageInfo.getPages();
        this.size = pageInfo.getSize();
        this.list = pageInfo.getList();
    }
}
