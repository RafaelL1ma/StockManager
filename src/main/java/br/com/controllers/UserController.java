package br.com.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.com.models.User;
import br.com.repository.UserRepository;



@Controller
public class UserController {
	
	@Autowired
	private UserRepository ur;

	@RequestMapping(value="/new-user", method=RequestMethod.GET)
		public String cadastro() {
		return "user/cadastroUser";
}
	@RequestMapping(value="/new-user", method=RequestMethod.POST)
	public String save(User user) {
		ur.save(user);
		return "redirect:newUser";
	}
}
