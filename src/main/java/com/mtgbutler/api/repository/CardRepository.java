package com.mtgbutler.api.repository;

import com.mtgbutler.api.model.Card;
import com.mtgbutler.api.model.QCard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.Optional;

@PreAuthorize("isAuthenticated()")
public interface CardRepository
    extends PagingAndSortingRepository<Card, Long>,
        QuerydslPredicateExecutor<Card>,
        QuerydslBinderCustomizer<QCard> {
  @Override
  @RestResource(exported = false)
  <S extends Card> S save(S s);

  @Override
  @RestResource(exported = false)
  <S extends Card> Iterable<S> saveAll(Iterable<S> iterable);

  @Override
  @RestResource(exported = false)
  void deleteById(Long aLong);

  @Override
  @RestResource(exported = false)
  void delete(Card card);

  @Override
  @RestResource(exported = false)
  void deleteAll(Iterable<? extends Card> iterable);

  @Override
  @RestResource(exported = false)
  void deleteAll();

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
