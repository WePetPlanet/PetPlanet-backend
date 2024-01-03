package top.zynorl.petplanet.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.zynorl.petplanet.post.mongoServer.DO.Comment;
import top.zynorl.petplanet.post.mongoServer.DO.Post;
import top.zynorl.petplanet.post.mongoServer.service.CommentService;
import top.zynorl.petplanet.post.mongoServer.service.PostService;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PetplanetPostApplicationTests {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void TestSavePost(){
        Post post = new Post("小猫日常","小猫吃饭",0,0,0,0,0,"public","猫咪","192.168.11.1","浙江",LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),0);
        postService.savePost(post);
    }

    @Test
    public void TestSaveComment(){
        // String postId, Long userId, String username, String text, Integer likeNum, Integer replyNum, Integer status, String ip, String loc, String parentId, Integer isDelete
        Comment comment = new Comment("12334", 123L, "zynorl", "猫咪很好", null, null, null, "169.172.11.1", "浙江", "0", null);
        commentService.saveComment(comment);
    }

    @Test
    public void TestGetComments(){
        List<Comment> commentList = commentService.findCommentList();
        System.out.println("=================");
        System.out.println(commentList.get(0).getLikeNum());
        commentList.forEach(System.out::println);
    }


}
