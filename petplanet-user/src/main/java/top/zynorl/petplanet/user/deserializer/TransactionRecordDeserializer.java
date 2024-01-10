package top.zynorl.petplanet.user.deserializer;

import cn.hutool.json.JSONUtil;
import org.apache.commons.lang3.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import top.zynorl.petplanet.sqlServer.entity.TransactionRecordDO;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/05
 **/
public class TransactionRecordDeserializer implements Deserializer<TransactionRecordDO> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public TransactionRecordDO deserialize(String topic, byte[] data) {
        try {
            // 将字节数组还原为JSON字符串并反序列化为TransactionRecordDO对象
            String jsonStr = new String(data, StandardCharsets.UTF_8);
            return JSONUtil.toBean(jsonStr, TransactionRecordDO.class);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing TransactionRecordDO from JSON", e);
        }
    }

    @Override
    public void close() {

    }
}
