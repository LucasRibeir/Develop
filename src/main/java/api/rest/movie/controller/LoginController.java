package api.rest.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import api.rest.movie.entity.Login;

import api.rest.movie.repository.LoginRepository;

@Controller

public class LoginController {

	@Autowired

	LoginRepository dao;

	@RequestMapping(value = "/login", method =
			RequestMethod.GET)
	public String login(@ModelAttribute("login") Login
			login) {
		return "login";

	}

}