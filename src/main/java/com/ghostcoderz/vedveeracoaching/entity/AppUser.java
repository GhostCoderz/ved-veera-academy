package com.ghostcoderz.vedveeracoaching.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity(name="APP_USER")
@Validated
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ToString.Exclude
    private List<Course> courses;

    public AppUser(long secure_id, String secureUserName) {
        this.setApp_user_id(secure_id);
        this.setUsername(secureUserName);
    }
}
