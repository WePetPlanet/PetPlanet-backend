package top.zynorl.petplanet.mongoserver.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.zynorl.petplanet.mongoserver.entity.PostMO;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/19
 **/
public interface PostMORepository extends MongoRepository<PostMO, String> {
}
