package com.aws.spring.project.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_user")
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String address;

}
