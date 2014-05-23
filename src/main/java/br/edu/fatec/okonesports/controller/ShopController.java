package br.edu.fatec.okonesports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fatec.okonesports.business.ProdutoBusiness;
import br.edu.fatec.okonesports.business.UsuarioBusiness;
import br.edu.fatec.okonesports.enums.TipoUsuario;
import br.edu.fatec.okonesports.exception.BusinessException;
import br.edu.fatec.okonesports.model.Usuario;

@Controller
@RequestMapping("/cart")
public class ShopController {

	private ProdutoBusiness produtoBusiness;
	private UsuarioBusiness usuarioBusiness;

	public ShopController() {
		produtoBusiness = new ProdutoBusiness();
		usuarioBusiness = new UsuarioBusiness();
	}

	@RequestMapping(value = "")
	public ModelAndView shop() {
		ModelAndView mv = new ModelAndView("shop");
		mv.addObject("produtos", produtoBusiness.buscarProdutos());
		Usuario usuarioAtivo = usuarioBusiness.buscarUsuarioAtivo();
		mv.addObject("is_logged", usuarioAtivo != null);
		if (usuarioAtivo != null) {
			mv.addObject("is_admin",
					usuarioAtivo.getTipo().equals(TipoUsuario.ADMIN));
			mv.addObject("username", usuarioAtivo.getNome());
		}
		return mv;
	}
	
	@RequestMapping(value = "logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("index");
		Usuario usuarioAtivo = usuarioBusiness.buscarUsuarioAtivo();
		usuarioAtivo.setAtivo(false);
		try {
			usuarioBusiness.alterarUsuario(usuarioAtivo);
			return mv;
		} catch (BusinessException e) {
			return mv;
		}
	}

}