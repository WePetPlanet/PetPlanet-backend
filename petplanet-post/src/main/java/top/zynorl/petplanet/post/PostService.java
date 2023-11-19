package top.zynorl.petplanet.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.post.Dao.PostRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/19
 **/
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public void savePost(Post post){
        postRepository.save(post);
    }
    public void updatePost(Post post){
        postRepository.save(post);
    }
    public void deletePostById(String id){
        postRepository.deleteById(id);
    }
    public List<Post> findPostList(){
        return postRepository.findAll();
    }
    public Optional<Post> findPostById(String id){
        return postRepository.findById(id);
    }

    public Page<Post> findPostListByTime(LocalDateTime fromTime, LocalDateTime endTime, Integer page, Integer size){
        Criteria criteria = new Criteria();
        Query query = Query.query(criteria);
        return postRepository.findAll(PageRequest.of(page, size));
    }

}
