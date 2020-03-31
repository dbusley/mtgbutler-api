package com.mtgbutler.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class CollectedCard {
  @Id @GeneratedValue private long id;

  @ManyToOne private User user;

  @ManyToOne private Card card;

  private int quantity;
}
