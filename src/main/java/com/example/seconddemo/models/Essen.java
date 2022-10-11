package com.example.seconddemo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "essen")
public class Essen{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private Float preis;
    
    private Integer koch_id;

    public Essen(){}

    public Essen(Integer essenId, String title, Float preis) {
        this.id = essenId;
        this.title = title;
        this.preis = preis;
    }

    public Essen(Integer id, String title, Float preis, Integer koch_id) {
        this.id = id;
        this.title = title;
        this.preis = preis;
        this.koch_id = koch_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPreis() {
        return preis;
    }

    public void setPreis(Float preis) {
        this.preis = preis;
    }

    public Integer getKoch_id() {
        return koch_id;
    }

    public void setKoch_id(Integer koch_id) {
        this.koch_id = koch_id;
    }

    @Override
    public String toString() {
        return "Essen [id=" + id + ", title=" + title + ", preis=" + preis + "]";
    }
}