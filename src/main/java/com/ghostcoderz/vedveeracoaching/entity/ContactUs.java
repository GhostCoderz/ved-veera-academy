package com.ghostcoderz.vedveeracoaching.entity;

import com.ghostcoderz.vedveeracoaching.util.constant.CONTACT_STATUS;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "CONTACT_US")
public class ContactUs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String email;
    private String message;
    private String course;
    private LocalDateTime create_dt;
    private CONTACT_STATUS status;
}
