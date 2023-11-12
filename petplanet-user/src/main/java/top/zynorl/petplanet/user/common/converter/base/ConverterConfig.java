package top.zynorl.petplanet.user.common.converter.base;

import org.mapstruct.*;

/**
 * Created by zynorl on 2023/11/12 16:10
 */
@MapperConfig(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
    unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ConverterConfig {

}
