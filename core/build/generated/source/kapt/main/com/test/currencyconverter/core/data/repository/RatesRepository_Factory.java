package com.test.currencyconverter.core.data.repository;

import com.test.currencyconverter.core.data.service.RateService;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RatesRepository_Factory implements Factory<RatesRepository> {
  private final Provider<RateService> rateServiceProvider;

  public RatesRepository_Factory(Provider<RateService> rateServiceProvider) {
    this.rateServiceProvider = rateServiceProvider;
  }

  @Override
  public RatesRepository get() {
    return newInstance(rateServiceProvider.get());
  }

  public static RatesRepository_Factory create(Provider<RateService> rateServiceProvider) {
    return new RatesRepository_Factory(rateServiceProvider);
  }

  public static RatesRepository newInstance(RateService rateService) {
    return new RatesRepository(rateService);
  }
}
