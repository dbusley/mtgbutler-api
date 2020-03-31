package com.mtgbutler.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
  @Id @GeneratedValue private long id;

  private String extId;

  private OAuthVendor oAuthVendor = OAuthVendor.GOOGLE;

  private String password;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<CollectedCard> collection;
}
