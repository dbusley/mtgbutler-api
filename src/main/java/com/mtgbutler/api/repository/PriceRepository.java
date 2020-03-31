package com.mtgbutler.api.repository;

import com.mtgbutler.api.model.Price;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("isAnonymous() or isAuthenticated()")
public interface PriceRepository extends PagingAndSortingRepository<Price, Long> {
  @Override
  @RestResource(exported = false)
  <S extends Price> S save(S s);

  @Override
  @RestResource(exported = false)
  <S extends Price> Iterable<S> saveAll(Iterable<S> iterable);

  @Override
  @RestResource(exported = false)
  void deleteById(Long aLong);

  @Override
  @RestResource(exported = false)
  void delete(Price price);

  @Override
  @RestResource(exported = false)
  void deleteAll(Iterable<? extends Price> iterable);

  @Override
  @RestResource(exported = false)
  void deleteAll();
}
