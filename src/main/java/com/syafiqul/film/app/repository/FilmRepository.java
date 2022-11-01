package com.syafiqul.film.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syafiqul.film.app.model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{

}