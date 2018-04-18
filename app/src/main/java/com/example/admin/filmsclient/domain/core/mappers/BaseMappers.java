package com.example.admin.filmsclient.domain.core.mappers;

import java.util.List;

import io.reactivex.Observable;

public abstract class BaseMappers<FromObject, ToObject> implements Mapper<FromObject, ToObject> {

    public List<ToObject> map(List<FromObject> list) {
        return Observable.fromIterable(list)
                .map(this::map)
                .toList()
                .blockingGet();
    }
}
