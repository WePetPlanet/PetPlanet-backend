package top.zynorl.petplanet.post.mongoServer.DO;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/25
 **/

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Document(collection = "comments")
@Accessors(chain = true)
public class Comment {
    @Id
    private String id;
    /**
     * '帖子ID'
     */
    @Field("post_id")
    private String postId;
    /**
     * '评论人的ID'
     */
    @Field("user_id")
    private Long userId;
    /**
     * '评论人名称'
     */
    private String username;
    /**
     * '评论的内容'
     */
    private String text;
    /**
     * 点赞数
     */
    @Field("like_num")
    private Integer likeNum = 0;
    /**
     * 回复数
     */
    @Field("reply_num")
    private Integer replyNum = 0;
    /**
     * 0:不可见，1:可见
     */
    private Integer status = 1;
    /**
     * 发表ip
     */
    private String ip;
    /**
     * 发表地址，省份
     */
    private String loc;
    /**
     * 上级ID，如果为0表示文章的顶级评论
     */
    @Field("parent_id")
    private String parentId;
    /**
     * 评论的创建时间
     */
    @Field("create_time")
    @CreatedDate
    private LocalDateTime createTime = LocalDateTime.now();
    /**
     * 评论的更新的时间
     */
    @Field("update_time")
    @LastModifiedDate
    private LocalDateTime updateTime = LocalDateTime.now();
    /**
     * 1表示删除，实现逻辑删除
     */
    @Field("is_delete")
    private Integer isDelete = 0;

    public Comment(String postId, Long userId, String username, String text, Integer likeNum, Integer replyNum, Integer status, String ip, String loc, String parentId, Integer isDelete) {
        this.postId = postId;
        this.userId = userId;
        this.username = username;
        this.text = text;
        this.likeNum = likeNum;
        this.replyNum = replyNum;
        this.status = status;
        this.ip = ip;
        this.loc = loc;
        this.parentId = parentId;
        this.isDelete = isDelete;
    }
}
