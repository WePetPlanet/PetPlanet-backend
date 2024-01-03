package top.zynorl.petplanet.post.mongoServer.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.zynorl.petplanet.post.mongoServer.DO.Post;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/19
 **/
public interface PostRepository extends MongoRepository<Post, String> {
}
