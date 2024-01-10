package top.zynorl.petplanet.sqlServer.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/09
 **/
@Data
public class BaseTransactionalDO {
    @ApiModelProperty("关联事务uuid")
    private String transactionId;
}
