package top.zynorl.petplanet.post.common.pojo.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/03
 **/
@Data
public class PostDTO {
    /**
     * 关联用户id
     */
    private Long userId;
    /**
     * 帖子标题
     */
    private String title;
    /**
     * 帖子的正文
     */
    private String content;
    /**
     * 帖子标签的名称, 比如狗狗、猫咪
     */
    private String tagName;
    /**
     * 发布ip
     */
    private String ip;
    /**
     * 帖子权限类型
     */
    private String permissionType;
    /**
     * 是否为定时发布
     */
    private Boolean isTiming;
    /**
     * 首次开始编写帖子的时间
     */
    private LocalDateTime startEditTime;
    /**
     * 最近帖子修改时间
     */
    private LocalDateTime lastEditTime;
}
