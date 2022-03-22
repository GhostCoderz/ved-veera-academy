package com.ghostcoderz.vedveeracoaching.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private int address_id;
    private String city;
    private String state;
    private String country;

    @OneToOne
    @JoinColumn( foreignKey = @ForeignKey(), name = "app_user_id", updatable = false)
    private AppUser appUser;

}
