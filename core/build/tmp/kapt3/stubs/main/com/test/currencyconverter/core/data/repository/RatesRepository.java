package com.test.currencyconverter.core.data.repository;

import java.lang.System;

/**
 * Created by Hammad Akram
 * hammad.akram@hotmail.com
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/test/currencyconverter/core/data/repository/RatesRepository;", "", "rateService", "Lcom/test/currencyconverter/core/data/service/RateService;", "(Lcom/test/currencyconverter/core/data/service/RateService;)V", "getRates", "Lio/reactivex/Single;", "Lcom/test/currencyconverter/core/data/model/RatesResponse;", "currency", "", "core"})
public final class RatesRepository {
    private final com.test.currencyconverter.core.data.service.RateService rateService = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.test.currencyconverter.core.data.model.RatesResponse> getRates(@org.jetbrains.annotations.NotNull()
    java.lang.String currency) {
        return null;
    }
    
    @javax.inject.Inject()
    public RatesRepository(@org.jetbrains.annotations.NotNull()
    com.test.currencyconverter.core.data.service.RateService rateService) {
        super();
    }
}