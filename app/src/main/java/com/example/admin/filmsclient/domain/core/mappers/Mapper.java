package com.example.admin.filmsclient.domain.core.mappers;

import java.util.List;

public interface Mapper<FromObject, ToObject> {

    ToObject map(FromObject fromObject);

    List<ToObject> map(List<FromObject> list);
}
