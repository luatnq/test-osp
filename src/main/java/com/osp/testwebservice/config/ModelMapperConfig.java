package com.osp.testwebservice.config;

import com.osp.testwebservice.mapper.MappingHelper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class ModelMapperConfig {
    public interface ModelMapperFactory {
        ModelMapper getMapper();
    }

    private ModelMapperFactory modelMapperFactory() {
        return () -> {
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return mapper;
        };
    }

    @Bean
    public MappingHelper mappingHelper() {
        return new MappingHelper(modelMapperFactory());
    }

}
