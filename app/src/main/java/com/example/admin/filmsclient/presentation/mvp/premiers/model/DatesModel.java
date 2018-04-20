package com.example.admin.filmsclient.presentation.mvp.premiers.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DatesModel {

    private String maximum;
    private String minimum;
}
