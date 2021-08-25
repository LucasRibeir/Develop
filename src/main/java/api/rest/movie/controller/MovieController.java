package api.rest.movie.controller;

import java.io.Serializable;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import api.rest.movie.entity.Movie;
import api.rest.movie.repository.MovieRepository;

@Controller
public class MovieController {

	@Autowired

	private MovieRepository dao;
	@PostMapping(value="/movie/Record",
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE

			)

	public void Record( @RequestParam String name,
			@RequestParam String title,
			@RequestParam String releseDate,
			@RequestParam String genre,
			@RequestParam String overview,
			@RequestParam String image,
			@RequestParam String Rating,
			HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session

			) {

		session = request.getSession(true);
		try {
			Movie v = new Movie(null, name,title,releseDate, genre, overview, image, Rating);
			dao.save(v);
			session.setAttribute("list", dao.findAll());
			response.sendRedirect("/");
		}catch(Exception ex) {
			ex.printStackTrace();
			session.setAttribute("msg", "error :" + ex.getMessage());
			System.out.println("ok");

		}

	}

	@GetMapping(value="/")
	public ModelAndView init() {
		ModelAndView mv = new ModelAndView("system");
		try {
			List <Movie> Movies =(List<Movie>)dao.findAll();
			mv.addObject("msgInit", "Welcome");
			mv.addObject("msg", "system");
			mv.addObject("list", Movies);
		}catch(Exception ex) {

		}

		return mv;

	}
	@GetMapping(value="/edit")
	public ModelAndView editr(
			HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session) {
		session = request.getSession(true);
		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("movie", session.getAttribute("movie"));
		return mv;

	}

	@GetMapping(value="/moviedelete/{id}")
	public void DeleteID(@PathVariable Long id,
			HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session

			) {

		session = request.getSession(true);
		try {
			Movie answer = dao.findById(id).get();
			dao.delete(answer);
			List <Movie> Movies =(List<Movie>) dao.findAll();
			session.setAttribute("msgInit", "Exclude");
			session.setAttribute("msg", "Exclude by id");
			session.setAttribute("list", dao.findAll());
			response.sendRedirect("/");
		}catch(Exception ex) {

		}

	}

	@GetMapping(value="/movieeditar/{id}"
			)
	public void edit (@PathVariable Long id,
			HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session
			) {
		session = request.getSession(true);
		try {
			Movie answer = dao.findById(id).get();
			session.setAttribute("msg", "Edit by Id");
			session.setAttribute("movie", answer);
			response.sendRedirect("/edit");
		}catch(Exception ex) {
			ex.printStackTrace();

		}

	}

	@PostMapping(value="/moviealter/alter",
			consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE,
			produces = MediaType.TEXT_PLAIN_VALUE)
	public void alterar(@RequestParam Long id,
			@RequestParam String name,
			@RequestParam String title,
			@RequestParam String releseDate,
			@RequestParam String genre,
			@RequestParam String overview,
			@RequestParam String image,
			@RequestParam String Rating,
			HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session

			) {

		session = request.getSession(true);
		try {
			Movie v = new Movie(new Long (id),name,title,releseDate, genre, overview, image, Rating);
			dao.save(v);
			session.setAttribute("msgInit", "change data");
			response.sendRedirect("/");
		}catch(Exception ex) {
			ex.printStackTrace();

		}

	}

}