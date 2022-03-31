package com.ghostcoderz.vedveeracoaching.entity;

import com.ghostcoderz.vedveeracoaching.util.constant.APP_ROLE;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int role_id;
    @Column(nullable = false, updatable = false)
    private String role_name;

    public Role(int role_id, APP_ROLE role_name) {
        this.role_id = role_id;
        this.role_name = "ROLE_" + role_name.toString();
    }

    public Role(APP_ROLE role_name) {
        this.role_name = "ROLE_" + role_name;
        role_id = 0;
    }

    public Role(int role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }
}
