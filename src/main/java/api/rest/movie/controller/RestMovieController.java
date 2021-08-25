package api.rest.movie.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import api.rest.movie.entity.Movie;
import api.rest.movie.repository.MovieRepository;

@RestController
@ResponseBody
@RequestMapping("movie")

public class RestMovieController {

	@Autowired
	MovieRepository dao;

	@GetMapping(path= {"/{id}"} )
	public ResponseEntity buscarId(@PathVariable long id) {
		return dao.findById(id).
				map(record-> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.badRequest().build());

	}

	@GetMapping
	public List<Movie>findAll(){
		return dao.findAll();

	}

}