package top.zynorl.petplanet.post.serializer;


import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import org.apache.commons.lang3.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import top.zynorl.petplanet.sqlServer.entity.TransactionRecordDO;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @version 1.0
 * @Author niuzy
 * @Date 2024/01/05
 **/
public class TransactionRecordSerializer implements Serializer<TransactionRecordDO> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, TransactionRecordDO data) {
        try {
            // 将TransactionRecordDO对象转换为JSON字符串
            String jsonStr = JSONUtil.toJsonStr(data);
            // 确保json字符串不为空，并转为字节数组
            if (StrUtil.isNotBlank(jsonStr)) {
                return jsonStr.getBytes(StandardCharsets.UTF_8);
            } else {
                throw new SerializationException("Error serializing TransactionRecordDO to byte array as JSON, JSON string is empty");
            }
        } catch (Exception e) {
            throw new SerializationException("Error serializing TransactionRecordDO to JSON string", e);
        }
    }

    @Override
    public void close() {

    }
}
