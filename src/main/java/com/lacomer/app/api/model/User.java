package com.lacomer.app.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "LAST_NAME_ONE", nullable = false)
    private String lastNameOne;

    @Column(name = "LAST_NAME_TWO", nullable = false)
    private String lastNameTwo;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "IP")
    private String ip;

} 