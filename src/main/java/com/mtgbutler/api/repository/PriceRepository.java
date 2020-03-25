package com.mtgbutler.api.repository;

import com.mtgbutler.api.model.Price;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PriceRepository extends PagingAndSortingRepository<Price, Long> {}
