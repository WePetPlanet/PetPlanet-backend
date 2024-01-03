package top.zynorl.petplanet.post.mongoServer.Dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.zynorl.petplanet.post.mongoServer.DO.Comment;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/25
 **/
public interface CommentRepository extends MongoRepository<Comment, String> {
}
