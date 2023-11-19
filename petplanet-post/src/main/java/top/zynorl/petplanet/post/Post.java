package top.zynorl.petplanet.post;

import cn.hutool.core.date.DateTime;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2023/11/19
 **/
@Data
@Document(collection = "post")
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private String content;
    private Integer likeNum;
    private Integer collectNum;
    private Integer forwardNum;
    private Integer lookNum;
    private Integer status;
    private String permissionType;
    private String tagName;
    private String ip;
    private String loc;
    private LocalDateTime lastReviewTime;
    private LocalDateTime startEditTime;
    private LocalDateTime lastEditTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDelete;
}
