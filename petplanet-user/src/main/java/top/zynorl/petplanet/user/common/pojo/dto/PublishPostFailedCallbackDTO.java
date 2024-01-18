package top.zynorl.petplanet.user.common.pojo.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zynorl on 2024/1/18 16:14
 */
@Data
public class PublishPostFailedCallbackDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 帖子id
     */
    private String postId;

    /**
     * 地点Id
     */
    private Long locationId;
}
