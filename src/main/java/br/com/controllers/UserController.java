package br.com.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class UserController {

	@RequestMapping(value="/cadastrarUser", method=RequestMethod.GET)
		public String cadastro() {
		
		System.out.println("cheguei");
		
		return "user/cadastroUser";
}
	
}
