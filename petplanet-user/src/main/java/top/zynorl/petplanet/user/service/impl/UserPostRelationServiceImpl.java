package top.zynorl.petplanet.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.zynorl.petplanet.user.common.pojo.dto.PublishPostTransactionDTO;
import top.zynorl.petplanet.user.service.UserPostRelationService;
import top.zynorl.petplanet.user.sqlServer.entity.UserPostRelationDO;
import top.zynorl.petplanet.user.sqlServer.service.IUserPostRelationDBService;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/10
 **/
@Service
@Slf4j
public class UserPostRelationServiceImpl implements UserPostRelationService {

    @Autowired
    private IUserPostRelationDBService userPostRelationDBService;


    @Override
    public void saveFromPostPublish(PublishPostTransactionDTO publishPostDTO) {
        UserPostRelationDO userPostRelationDO = UserPostRelationDO.builder()
                .postMongoId(publishPostDTO.getPostId()).userId(publishPostDTO.getUserId()).build();
        userPostRelationDBService.save(userPostRelationDO);
    }
}

