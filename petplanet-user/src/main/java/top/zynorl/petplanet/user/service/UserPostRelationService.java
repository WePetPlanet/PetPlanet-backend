package top.zynorl.petplanet.user.service;

import top.zynorl.petplanet.user.common.pojo.dto.PublishPostDTO;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/10
 **/
public interface UserPostRelationService {

    /**
     * 保存帖子时，附带的user信息
     * @param transactionId
     * @param publishPostDTO
     */
    void saveFromPostPublish(String transactionId, PublishPostDTO publishPostDTO);
}
