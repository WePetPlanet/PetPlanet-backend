package top.zynorl.petplanet.post.transaction;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/09
 **/
public interface TCCTransactionalService<T> {
    /**
     * TCC 模式本地事务跨数据库保存
     * @param t
     * @return
     */
    boolean doProcess(T t);

}
