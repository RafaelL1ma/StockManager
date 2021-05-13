package br.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.models.User;
import br.com.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository ur;

	@RequestMapping(value = "/new-user", method = RequestMethod.GET)
	public String newUser() {
		return "user/newUser";
	}

	@RequestMapping(value = "/new-user", method = RequestMethod.POST)
	public String save(User user) {
		ur.save(user);
		return "redirect:list-user";
	}

	@RequestMapping(value = "/list-user", method = RequestMethod.GET)
	public ModelAndView listUser() {
		ModelAndView mv = new ModelAndView("user/listUser");
		Iterable<User> user = ur.findAll();
		mv.addObject("user", user);
		return mv;
	}

	@RequestMapping(value = "delete-user/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") long id) {
		User user = ur.findById(id);
		ur.delete(user);
		return "redirect:/list-user";
	}
	
	@RequestMapping(value = "/update-user/{id}", method = RequestMethod.GET)
	public ModelAndView updateUser(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("user/updateUser");
		User user = ur.findById(id);
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping(value = "/update-user/{id}", method = RequestMethod.POST)
	public String updateUserPost(@PathVariable("id") long id, User user) {
		ur.save(user);
		return "redirect:/list-user";
	}
	
}