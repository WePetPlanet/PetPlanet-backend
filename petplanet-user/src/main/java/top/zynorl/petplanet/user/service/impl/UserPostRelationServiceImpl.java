package top.zynorl.petplanet.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.zynorl.petplanet.common.enums.TransactionStatusEnum;
import top.zynorl.petplanet.sqlServer.entity.TransactionRecordDO;
import top.zynorl.petplanet.sqlServer.entity.UserPostRelationDO;
import top.zynorl.petplanet.sqlServer.service.ITransactionRecordService;
import top.zynorl.petplanet.sqlServer.service.IUserInfoDBService;
import top.zynorl.petplanet.sqlServer.service.IUserPostRelationDBService;
import top.zynorl.petplanet.user.common.pojo.dto.PublishPostDTO;
import top.zynorl.petplanet.user.service.UserPostRelationService;

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

    @Autowired
    private ITransactionRecordService transactionRecordService;

    @Override
    @Transactional
    public void saveFromPostPublish(String transactionId, PublishPostDTO publishPostDTO) {
        UserPostRelationDO userPostRelationDO = UserPostRelationDO.builder()
                .postMongoId(publishPostDTO.getPostId()).userId(publishPostDTO.getUserId()).build();
        userPostRelationDO.setTransactionId(transactionId);
        userPostRelationDBService.save(userPostRelationDO);
        QueryWrapper<TransactionRecordDO> queryWrapper = new QueryWrapper<TransactionRecordDO>().eq("transaction_id", transactionId);
        TransactionRecordDO transactionRecordDO = transactionRecordService.getOne(queryWrapper);
        if (transactionRecordDO != null) {
            if (TransactionStatusEnum.SUCCESS.getCode().equals(transactionRecordDO.getStatus())) {
                throw new DuplicateKeyException("重复消费异常");
            }
            transactionRecordDO.setStatus(TransactionStatusEnum.SUCCESS.getCode());
            transactionRecordService.updateById(transactionRecordDO);
            String logMeg = String.format("%s事务状态更新为:%s", transactionId, TransactionStatusEnum.SUCCESS.getCode());
            log.info(logMeg);
        } else {
            throw new RuntimeException("无事务信息，消费失败");
        }
    }
}

