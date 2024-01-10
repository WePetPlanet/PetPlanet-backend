package top.zynorl.petplanet.mongoserver.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.zynorl.petplanet.mongoserver.entity.CommentMO;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/25
 **/
public interface CommentMORepository extends MongoRepository<CommentMO, String> {
}
