package com.ashot.musicat.entity;


import jakarta.persistence.*;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(length = 25000)
    private String description;
    @Column
    private String members;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
