package com.ghostcoderz.vedveeracoaching.entity;

import com.ghostcoderz.vedveeracoaching.util.constant.CONTACT_STATUS;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "CONTACT_US")
@NonNull
public class ContactUs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    @Column(nullable = false)
    private String email;
    private String message;
    private String course;
    @Column(nullable = false)
    private LocalDateTime create_dt;
    @Column(nullable = false)
    private CONTACT_STATUS status;
}
