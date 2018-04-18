package com.example.admin.filmsclient.data.remote.mappers;

import com.example.admin.filmsclient.data.remote.dto.DatesDto;
import com.example.admin.filmsclient.domain.core.mappers.BaseMappers;
import com.example.admin.filmsclient.domain.core.pojo.Dates;

import javax.inject.Inject;

public class DatesDtoMapper extends BaseMappers<DatesDto, Dates> {

    @Inject
    public DatesDtoMapper() {
    }

    @Override
    public Dates map(DatesDto datesDto) {
        return Dates.builder()
                .maximum(datesDto.getMaximum())
                .minimum(datesDto.getMinimum())
                .build();
    }
}
