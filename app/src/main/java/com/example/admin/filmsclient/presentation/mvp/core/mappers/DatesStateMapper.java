package com.example.admin.filmsclient.presentation.mvp.core.mappers;

import com.example.admin.filmsclient.domain.core.mappers.BaseMappers;
import com.example.admin.filmsclient.domain.core.pojo.Dates;
import com.example.admin.filmsclient.presentation.mvp.premiers.model.DatesModel;

public class DatesStateMapper extends BaseMappers<Dates, DatesModel> {
    @Override
    public DatesModel map(Dates dates) {
        return DatesModel.builder()
                .maximum(dates.getMaximum())
                .minimum(dates.getMinimum())
                .build();
    }
}
