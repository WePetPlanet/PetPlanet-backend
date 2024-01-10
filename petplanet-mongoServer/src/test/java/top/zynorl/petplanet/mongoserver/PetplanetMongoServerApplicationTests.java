package top.zynorl.petplanet.mongoserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.zynorl.petplanet.mongoserver.entity.CommentMO;
import top.zynorl.petplanet.mongoserver.entity.PostMO;
import top.zynorl.petplanet.mongoserver.service.CommentMOService;
import top.zynorl.petplanet.mongoserver.service.PostMOService;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PetplanetMongoServerApplicationTests {

	@Autowired
	private PostMOService postMOService;
	@Autowired
	private CommentMOService commentMOService;


	@Test
	public void TestSavePost(){
		PostMO post = new PostMO("小猫日常","小猫吃饭",0,0,0,0,0,"public","猫咪","192.168.11.1","浙江", LocalDateTime.now(),LocalDateTime.now(),LocalDateTime.now(),0);
		postMOService.savePost(post);
	}

	@Test
	public void TestSaveComment(){
		// String postId, Long userId, String username, String text, Integer likeNum, Integer replyNum, Integer status, String ip, String loc, String parentId, Integer isDelete
		CommentMO comment = new CommentMO("12334", 123L, "zynorl", "猫咪很好", null, null, null, "169.172.11.1", "浙江", "0", null);
		commentMOService.saveComment(comment);
	}

	@Test
	public void TestGetComments(){
		List<CommentMO> commentList = commentMOService.findCommentList();
		System.out.println("=================");
		System.out.println(commentList.get(0).getLikeNum());
		commentList.forEach(System.out::println);
	}

}
