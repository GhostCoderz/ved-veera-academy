package com.ghostcoderz.vedveeracoaching.entity;

import com.ghostcoderz.vedveeracoaching.util.constant.CONTACT_STATUS;
import lombok.*;
import org.springframework.validation.annotation.Validated;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "CONTACT_US")
@NonNull
@Validated
public class ContactUs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fullName;
    @Column(nullable = false)
    private String email;
    private String message;
    private String course;
    private int contactNum;
    @Column(nullable = false)
    private LocalDateTime create_dt;
    @Column(nullable = false)
    private CONTACT_STATUS status;

    public ContactUs(String fullName, String email, String message, String course, LocalDateTime create_dt, CONTACT_STATUS status, int contactNum) {
        this.fullName = fullName;
        this.email = email;
        this.message = message;
        this.course = course;
        this.create_dt = create_dt;
        this.status = status;
        this.contactNum = contactNum;
    }

}
