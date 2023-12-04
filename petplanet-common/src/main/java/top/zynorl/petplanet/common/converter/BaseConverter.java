package top.zynorl.petplanet.common.converter;

import cn.hutool.core.date.DateUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created by zynorl on 2023/11/12 16:17
 */

@Mapper(config = ConverterConfig.class)
public interface BaseConverter {

    @Named("toLocalDataTime")
    default LocalDateTime toLocalDateTime(Long timestamp){
        return Instant.ofEpochMilli(timestamp)
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    @Named("toTimestamp")
    default Long toTimestamp(LocalDateTime localDateTime){
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    @Named("LocalDateTimeToString")
    default String localDateTimeToString(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    @Named("stringToTimestamp")
    default Long stringToTimeStamp(String string){
        return DateUtil.parseDateTime(string).getTime();
    }

    @Named("byteToBoolean")
    default boolean byteToBoolean(Byte b){
        return b!=null && b == 1;
    }

}
