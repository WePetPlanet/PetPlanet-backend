package top.zynorl.petplanet.user.sqlServer.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import top.zynorl.petplanet.user.sqlServer.service.IUserBaseDBService;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/12/26
 **/
@Slf4j
public class UserBaseDBServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IUserBaseDBService<T> {
    private static final String IS_DELETED = "isDelete";

    private static final String ID = "id";

    private static final String ORDER_RULE = "updateTime";

    @SneakyThrows
    @Override
    public T getUndeletedDBOne(T t) {
        Field f = t.getClass().getDeclaredField(IS_DELETED);
        f.setAccessible(true);
        f.set(t, 0);
        return getDBOne(t);
    }

    @Override
    public List<T> getUndeletedDBMany(T t) {
        return null;
    }

    @Override
    public T getDBOne(T t) {
        return null;
    }

    @Override
    public List<T> getDBMany(T t) {
        return null;
    }

    @Override
    public Long saveDBAfterGetId(T t) {
        return null;
    }

    @Override
    public List<T> getDBManyLikeValues(Map<String, String> map) {
        return null;
    }

    @Override
    public List<T> getDBManyInValues(String attributeName, Collection<? extends Serializable> values) {
        return null;
    }

    @Override
    public Boolean deleteDBManyById(List<T> list) {
        return null;
    }

    @Override
    public Boolean deleteDBOneById(T t) {
        return null;
    }

    @Override
    public Boolean updateDBOneByKey(T t, String key) {
        return null;
    }

    @Override
    public Boolean deleteDBOneByKey(T t, String key) {
        return null;
    }

}
