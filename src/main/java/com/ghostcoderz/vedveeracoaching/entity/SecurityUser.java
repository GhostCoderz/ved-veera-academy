package com.ghostcoderz.vedveeracoaching.entity;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "security_user")
public class SecurityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;
    private String userName;
    private String password;
    @NotNull
    private boolean active;
    private String roles;

    public SecurityUser(String userName, String password, boolean active, String roles) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

}
