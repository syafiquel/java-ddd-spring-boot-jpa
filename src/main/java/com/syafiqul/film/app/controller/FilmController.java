package com.syafiqul.film.app.controller;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syafiqul.film.app.exception.ResourceNotFoundException;
import com.syafiqul.film.app.model.Film;
import com.syafiqul.film.app.repository.FilmRepository;

@RestController
@RequestMapping("/api/v1")
public class FilmController {

    @Autowired
	private FilmRepository filmRepository;

	@GetMapping("/films")
	public List<Film> getAllFilms() {
		return filmRepository.findAll();
	}

    @GetMapping("/films/{id}")
	public ResponseEntity<Film> getFilmById(@PathVariable(value = "id") Integer filmId)
			throws ResourceNotFoundException {
		Film film = filmRepository.findById(filmId)
				.orElseThrow(() -> new ResourceNotFoundException("Film title is not found for id " + filmId));
		return ResponseEntity.ok().body(film);
	}

    @PostMapping("/films")
	public Film createFilm(@Valid @RequestBody Film film) {
		return filmRepository.save(film);
	}

    @PutMapping("/films/{id}")
	public ResponseEntity<Film> updateFilm(@PathVariable(value = "id") Integer filmId,
			@Valid @RequestBody Film filmDetails) throws ResourceNotFoundException {
		Film film = filmRepository.findById(filmId)
				.orElseThrow(() -> new ResourceNotFoundException("Film title is not found for id " + filmId));

        film.setRegistrationNo(filmDetails.getRegistrationNo());
		film.setTitle(filmDetails.getTitle());
		film.setDistributor(filmDetails.getDistributor());
		film.setResult(filmDetails.getResult());
        film.setClassification(filmDetails.getClassification());
        film.setSubmissionDate(filmDetails.getSubmissionDate());
		final Film updatedFilm = filmRepository.save(film);
		return ResponseEntity.ok(updatedFilm);
	}

    @DeleteMapping("/films/{id}")
	public Map<String, Boolean> deleteFilm(@PathVariable(value = "id") Integer filmId)
			throws ResourceNotFoundException {
		Film film = filmRepository.findById(filmId)
				.orElseThrow(() -> new ResourceNotFoundException("Film title is not found for id " + filmId));

		filmRepository.delete(film);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}