package br.edu.fatec.okonesports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fatec.okonesports.business.UsuarioBusiness;
import br.edu.fatec.okonesports.enums.TipoUsuario;
import br.edu.fatec.okonesports.exception.BusinessException;
import br.edu.fatec.okonesports.model.Usuario;
import br.edu.fatec.okonesports.util.CalendarUtils;

@Controller
@RequestMapping("/new_user")
public class NewUserController {

	private UsuarioBusiness usuarioBusiness;

	public NewUserController() {
		usuarioBusiness = new UsuarioBusiness();
	}

	@RequestMapping(value = "")
	public ModelAndView newUser() {
		ModelAndView mv = new ModelAndView("new_user");
		return mv;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveUser(@RequestParam("nome") String nome,
			@RequestParam("dataNascimento") String dataNascimento,
			@RequestParam("rg") String rg, @RequestParam("cpf") String cpf,
			@RequestParam("email") String email,
			@RequestParam("senha") String senha) {
		ModelAndView mv = new ModelAndView();
		Usuario user = new Usuario(nome, email, senha, rg, cpf, CalendarUtils.parseStringToCalendar(dataNascimento),
				TipoUsuario.CLIENTE, true);
		try {
			usuarioBusiness.salvarUsuario(user);
			mv.setViewName("index");
			return mv;
		} catch (BusinessException e) {
			mv.setViewName("new_user");
			mv.addObject("login_error", true);
			mv.addObject("msg_error", e.getMessage());
			return mv;
		}
	}

}