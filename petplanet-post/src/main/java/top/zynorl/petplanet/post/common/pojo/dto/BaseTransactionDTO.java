package top.zynorl.petplanet.post.common.pojo.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by zynorl on 2024/1/17 10:20
 */
@Data
public class BaseTransactionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 事务id
     */
    private String transactionId;

    /**
     * kafka主题
     */
    private String topic;
}
