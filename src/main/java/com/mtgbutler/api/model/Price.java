package com.mtgbutler.api.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Price {
  @Id @GeneratedValue private long id;

  @Temporal(TemporalType.TIMESTAMP)
  private Date reportedDate = new Date();

  private BigDecimal value;
}
