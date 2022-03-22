package com.ghostcoderz.vedveeracoaching.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "security_user")
public class SecurityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    private long secure_id;
    @Column(nullable = false)
    private String userName;
    @Column(unique = true, nullable = false, updatable = false)
    private String password;
    @NotNull
    private boolean active;

    // Fetch type eager as Spring security is not able to load roles lazily
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "secure_id")
    @Cascade(CascadeType.ALL)
    private List<Role> roles;

    public SecurityUser(long secure_id, String userName, String password, boolean active, List<Role> roles) {
        this.secure_id = secure_id;
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    public SecurityUser(String userName, String password, boolean active, List<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

}
