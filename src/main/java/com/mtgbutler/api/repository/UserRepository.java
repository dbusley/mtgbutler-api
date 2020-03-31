package com.mtgbutler.api.repository;

import com.mtgbutler.api.model.User;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@PreAuthorize("isAuthenticated()")
public interface UserRepository
    extends PagingAndSortingRepository<User, Long>, QuerydslPredicateExecutor<User> {}
