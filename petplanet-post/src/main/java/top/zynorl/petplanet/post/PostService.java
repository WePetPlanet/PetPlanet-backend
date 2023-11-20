package top.zynorl.petplanet.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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

    public Page<Post> findPostListByTime(LocalDateTime fromTime, LocalDateTime endTime, Integer pageNum, Integer pageSize){
        // 创建查询条件
        Criteria criteria = Criteria.where("createTime").gte(fromTime).lte(endTime);
        Query query = new Query(criteria);
        // 获取总记录数
        long total = mongoTemplate.count(query, Post.class);
        // 设置分页信息
        PageRequest pageRequest = PageRequest.of(pageNum-1, pageSize, Sort.by("createTime"));
        // 添加分页条件
        query.with(pageRequest);
        // 查询结果
        List<Post> list = mongoTemplate.find(query, Post.class);
        // 封装成Page对象并返回
        return new PageImpl<>(list, pageRequest, total);
    }

}
