package com.spring.task.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.IdGeneratorType;

import java.util.Date;

@Table(name = "tasks")
@Entity
@ToString
@EqualsAndHashCode
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "")
    private Long id;

    @Getter @Setter @Column(name = "title")
    private String title;

    @Getter @Setter @Column(name = "description")
    private String description;

    @Getter @Setter @Column(name = "status")
    private String status;

    @Getter @Setter @Column(name = "due_date")
    private Date due_date;
}
