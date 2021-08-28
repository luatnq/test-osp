package com.osp.testwebservice.mapper;

import com.osp.testwebservice.config.ModelMapperConfig;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MappingHelper {
    private ModelMapper modelMapper;
    private final ModelMapperConfig.ModelMapperFactory modelMapperFactory;

    public <T, H> List<T> mapList(List<H> inputData, Class<T> clazz) {
        return CollectionUtils.isEmpty(inputData) ?
                Collections.emptyList() :
                inputData.stream()
                        .map(i -> modelMapper.map(i, clazz))
                        .collect(Collectors.toList());
    }

    public <T, H> Page<T> mapPage(Page<H> inputData, Class<T> clazz) {
        return inputData
                .map(i -> modelMapper.map(i, clazz));
    }

    public <T, H> T map(H inputData, Class<T> clazz) {
        return modelMapper.map(inputData, clazz);
    }

}
