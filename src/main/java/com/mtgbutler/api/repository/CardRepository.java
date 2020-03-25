package com.mtgbutler.api.repository;

import com.mtgbutler.api.model.Card;
import com.mtgbutler.api.model.QCard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CardRepository
    extends PagingAndSortingRepository<Card, Long>,
        QuerydslPredicateExecutor<Card>,
        QuerydslBinderCustomizer<QCard> {

  @Override
  default void customize(QuerydslBindings bindings, QCard root) {
    bindings.bind(root.name).first(StringExpression::startsWithIgnoreCase);

    bindings
        .bind(root.colors)
        .all(
            (path, values) -> {
              BooleanBuilder predicate = new BooleanBuilder();
              values.stream().forEach(value -> predicate.and(path.containsIgnoreCase(value)));
              return Optional.of(predicate);
            });
  }
}
