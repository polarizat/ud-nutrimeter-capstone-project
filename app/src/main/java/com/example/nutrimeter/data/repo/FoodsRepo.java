package com.example.nutrimeter.data.repo;

import com.example.nutrimeter.data.database.FoodsDao;

import javax.inject.Inject;

public class FoodsRepo {

    private FoodsDao mDao;

    @Inject
    public FoodsRepo(FoodsDao foodsDao) {
        mDao = foodsDao;
    }
}
