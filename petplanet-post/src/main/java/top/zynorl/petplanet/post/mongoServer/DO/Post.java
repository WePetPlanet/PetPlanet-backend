package top.zynorl.petplanet.post.mongoServer.DO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/19
 **/
@Data
@NoArgsConstructor
@Document(collection = "posts")
@Accessors(chain = true)
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String title;
    private String content;
    private Integer likeNum = 0;
    private Integer collectNum = 0;
    private Integer forwardNum = 0;
    private Integer lookNum = 0;
    private Integer status = 0;
    private String permissionType;
    private String tagName;
    private String ip;
    private String loc;
    private LocalDateTime lastReviewTime;
    private LocalDateTime startEditTime;
    private LocalDateTime lastEditTime;
    /**
     * 创建时间，也即发布时间
     */
    @CreatedDate
    private LocalDateTime createTime = LocalDateTime.now();
    @LastModifiedDate
    private LocalDateTime updateTime = LocalDateTime.now();
    private Integer isDelete = 0;

    public Post(String title, String content, Integer likeNum, Integer collectNum, Integer forwardNum, Integer lookNum, Integer status, String permissionType, String tagName, String ip, String loc, LocalDateTime lastReviewTime, LocalDateTime startEditTime, LocalDateTime lastEditTime, Integer isDelete) {
        this.title = title;
        this.content = content;
        this.likeNum = likeNum;
        this.collectNum = collectNum;
        this.forwardNum = forwardNum;
        this.lookNum = lookNum;
        this.status = status;
        this.permissionType = permissionType;
        this.tagName = tagName;
        this.ip = ip;
        this.loc = loc;
        this.lastReviewTime = lastReviewTime;
        this.startEditTime = startEditTime;
        this.lastEditTime = lastEditTime;
        this.isDelete = isDelete;
    }
}
