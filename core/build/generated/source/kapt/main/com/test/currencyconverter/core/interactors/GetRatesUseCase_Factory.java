package com.test.currencyconverter.core.interactors;

import com.test.currencyconverter.core.data.repository.RatesRepository;
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
public final class GetRatesUseCase_Factory implements Factory<GetRatesUseCase> {
  private final Provider<RatesRepository> ratesRepositoryProvider;

  public GetRatesUseCase_Factory(Provider<RatesRepository> ratesRepositoryProvider) {
    this.ratesRepositoryProvider = ratesRepositoryProvider;
  }

  @Override
  public GetRatesUseCase get() {
    return newInstance(ratesRepositoryProvider.get());
  }

  public static GetRatesUseCase_Factory create(Provider<RatesRepository> ratesRepositoryProvider) {
    return new GetRatesUseCase_Factory(ratesRepositoryProvider);
  }

  public static GetRatesUseCase newInstance(RatesRepository ratesRepository) {
    return new GetRatesUseCase(ratesRepository);
  }
}
