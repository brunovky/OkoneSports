package br.edu.fatec.okonesports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fatec.okonesports.business.UsuarioBusiness;
import br.edu.fatec.okonesports.exception.BusinessException;
import br.edu.fatec.okonesports.exception.ViewException;
import br.edu.fatec.okonesports.model.Usuario;

@Controller
@RequestMapping("/login")
public class LoginController {

	private UsuarioBusiness usuarioBusiness;

	public LoginController() {
		usuarioBusiness = new UsuarioBusiness();
	}

	@RequestMapping(value = "")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@ExceptionHandler(ViewException.class)
	@RequestMapping(value = "/logon")
	public ModelAndView logon(@RequestParam("login") String login,
			@RequestParam("senha") String senha) throws ViewException {
		ModelAndView mv = new ModelAndView();
		Usuario usuario = usuarioBusiness.buscarUsuario(login, senha);
		if (usuario != null) {
			usuario.setAtivo(true);
			try {
				usuarioBusiness.alterarUsuario(usuario);
				mv.setViewName("index");
				return mv;
			} catch (BusinessException e) {
				throw new ViewException("Erro no login de usuário");
			}
		}
		throw new ViewException("Login e/ou senha inválidos");
	}

}