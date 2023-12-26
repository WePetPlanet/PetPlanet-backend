package top.zynorl.petplanet.user.sqlServer.service;

import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/12/26
 **/

public interface IUserBaseDBService<T> extends IService<T> {

    /**
     * 根据对象属性，获取未删除的对象
     * @param t
     * @return
     */
    T getUndeletedDBOne(T t);

    /**
     * 根据对象属性，获取满足的未删除对象列表
     * @param t
     * @return
     */
    List<T> getUndeletedDBMany(T t);

    /**
     * 根据对象属性，获取满足的对象
     * @param t
     * @return
     */
    T getDBOne(T t);

    /**
     * 根据对象属性，获取满足的对象列表
     * @param t
     * @return
     */
    List<T> getDBMany(T t);

    /**
     * 保存并获取其主键
     * @param t
     * @return
     */
    Long saveDBAfterGetId(T t);

    /**
     * 批量模糊获取(未删除的数据）
     * key: 属性
     * value：属性值
     */
    List<T> getDBManyLikeValues(Map<String, String> map);

    /**
     * 批量获取返回 (未删除的数据）
     * attributeName ：属性名（需要数据库中字段的驼峰形式）
     * values : 属性值
     */
    List<T> getDBManyInValues(String attributeName, Collection<? extends Serializable> values);


    /**
     * 根据id批量逻辑删除
     * @param list
     * @return
     */
    Boolean deleteDBManyById(List<T> list);

    /**
     * 根据id逻辑删除
     * @param t
     * @return
     */
    Boolean deleteDBOneById(T t);

    /**
     * 通过主键更新
     * key ：唯一主键的属性名（需要数据库中字段的驼峰形式）
     */
    Boolean updateDBOneByKey(T t, String key);

    /**
     * 通过主键删除
     * key ：唯一主键的属性名（需要数据库中字段的驼峰形式）
     */
    Boolean deleteDBOneByKey(T t, String key);
}
