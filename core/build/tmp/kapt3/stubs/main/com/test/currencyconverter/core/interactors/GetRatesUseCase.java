package com.test.currencyconverter.core.interactors;

import java.lang.System;

/**
 * Created by Hammad Akram
 * hammad.akram@hotmail.com
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/test/currencyconverter/core/interactors/GetRatesUseCase;", "", "ratesRepository", "Lcom/test/currencyconverter/core/data/repository/RatesRepository;", "(Lcom/test/currencyconverter/core/data/repository/RatesRepository;)V", "getRates", "Lio/reactivex/Single;", "Lcom/test/currencyconverter/core/domain/RateList;", "kotlin.jvm.PlatformType", "currency", "", "core"})
public final class GetRatesUseCase {
    private final com.test.currencyconverter.core.data.repository.RatesRepository ratesRepository = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Single<com.test.currencyconverter.core.domain.RateList> getRates(@org.jetbrains.annotations.NotNull()
    java.lang.String currency) {
        return null;
    }
    
    @javax.inject.Inject()
    public GetRatesUseCase(@org.jetbrains.annotations.NotNull()
    com.test.currencyconverter.core.data.repository.RatesRepository ratesRepository) {
        super();
    }
}