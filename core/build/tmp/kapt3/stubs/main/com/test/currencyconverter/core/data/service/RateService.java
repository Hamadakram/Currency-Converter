package com.test.currencyconverter.core.data.service;

import java.lang.System;

/**
 * Created by Hammad Akram
 * hammad.akram@hotmail.com
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/test/currencyconverter/core/data/service/RateService;", "", "getRates", "Lio/reactivex/Single;", "Lcom/test/currencyconverter/core/data/model/RatesResponse;", "currency", "", "core"})
public abstract interface RateService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "/latest")
    public abstract io.reactivex.Single<com.test.currencyconverter.core.data.model.RatesResponse> getRates(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "base")
    java.lang.String currency);
}