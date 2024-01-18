package top.zynorl.petplanet.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by zynorl on 2024/1/18 15:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RepeatConsumptionException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String transactionId;

    public RepeatConsumptionException(String message, String transactionId) {
        super(message);
        this.transactionId = transactionId;
    }

}
