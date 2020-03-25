package com.mtgbutler.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Card {
  @Id @GeneratedValue private long id;

  private String name;

  private String imageUrl;

  private String colors;

  @Transient private BigDecimal latestPrice;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "cardId")
  @OrderBy("reportedDate desc")
  private List<Price> prices;

  @PostLoad
  private void onLoad() {
    try {
      latestPrice = prices.get(0).getValue();
    } catch (IndexOutOfBoundsException e) {
      // no-op if there are no prices
    }
  }
}
