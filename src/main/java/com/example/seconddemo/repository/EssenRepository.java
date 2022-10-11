package com.example.seconddemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.seconddemo.models.Essen;

@Repository
public interface EssenRepository extends JpaRepository<Essen, Integer>{

}