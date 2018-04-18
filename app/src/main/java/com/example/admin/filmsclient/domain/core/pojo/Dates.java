package com.example.admin.filmsclient.domain.core.pojo;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Dates {

    private String maximum;
    private String minimum;
}
