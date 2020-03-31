package com.mtgbutler.api.repository;

import com.mtgbutler.api.model.CollectedCard;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("isAuthenticated()")
public interface CollectedCardRepository extends PagingAndSortingRepository<CollectedCard, Long> {}
