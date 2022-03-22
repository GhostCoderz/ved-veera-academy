package com.ghostcoderz.vedveeracoaching.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.Clock;
import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@Entity(name = "COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long course_id;
    private String course_name;
    private String description;
    @Column(nullable = false)
    private LocalDateTime create_dt;

    @ManyToOne
    private AppUser appUser;

}
