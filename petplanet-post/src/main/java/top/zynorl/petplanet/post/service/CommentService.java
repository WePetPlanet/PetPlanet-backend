package top.zynorl.petplanet.post.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.post.DO.Comment;
import top.zynorl.petplanet.post.DO.Post;
import top.zynorl.petplanet.post.Dao.CommentRepository;

import java.util.List;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/25
 **/
@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }

    public List<Comment> findCommentList(){
        return commentRepository.findAll();
    }
}
