package com.ghostcoderz.vedveeracoaching.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "ADDRESS")
@Validated
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
