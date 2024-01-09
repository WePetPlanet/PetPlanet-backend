package top.zynorl.petplanet.mongoserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.mongoserver.dao.CommentMORepository;
import top.zynorl.petplanet.mongoserver.entity.CommentMO;

import java.util.List;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/25
 **/
@Service
public class CommentMOService {
    @Autowired
    private CommentMORepository commentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public void saveComment(CommentMO comment){
        commentRepository.save(comment);
    }

    public List<CommentMO> findCommentList(){
        return commentRepository.findAll();
    }
}
