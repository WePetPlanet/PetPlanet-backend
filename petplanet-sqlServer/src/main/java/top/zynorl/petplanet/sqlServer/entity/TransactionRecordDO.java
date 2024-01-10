package top.zynorl.petplanet.sqlServer.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 事务记录表
 * </p>
 *
 * @author zynorl/niuzy
 * @since 2024-01-05
 */
@TableName("transaction_record")
@Builder
@Data
@ApiModel(value = "TransactionRecord对象", description = "事务记录表")
public class TransactionRecordDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("事务uuid")
    private String transactionId;

    @ApiModelProperty("此次事务涉及到的交易数据")
    private String data;

    @ApiModelProperty("事务状态")
    private String status;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否删除")
    private Boolean isDelete;

}
