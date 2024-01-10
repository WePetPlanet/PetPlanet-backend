package top.zynorl.petplanet.post.common.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/10
 **/
@Data
public class PublishPostDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 关联用户id
     */
    private Long userId;

    /**
     * 帖子id
     */
    private String postId;
}
