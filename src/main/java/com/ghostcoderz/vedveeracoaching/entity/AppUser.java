package com.ghostcoderz.vedveeracoaching.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity(name="APP_USER")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long app_user_id;
    private String username;
    private String name;
    private String email;
    private String contactNum;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "secure_id")
    private SecurityUser securityUser;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Course> courses;

}
