package com.ghostcoderz.vedveeracoaching.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "security_user")
public class SecurityUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long secure_id;
    @Column(nullable = false)
    private String userName;
    @Column(unique = true, nullable = false, updatable = false)
    private String password;
    @NotNull
    private boolean active;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey, name = "app_user_id")
    private AppUser appUser;

    // Fetch type eager as Spring security is not able to load roles lazily
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "secure_id")
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

    public SecurityUser(long secure_id, String userName, String password, boolean active, AppUser appUser, List<Role> roles) {
        this.secure_id = secure_id;
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.appUser = appUser;
        this.roles = roles;
    }

}
