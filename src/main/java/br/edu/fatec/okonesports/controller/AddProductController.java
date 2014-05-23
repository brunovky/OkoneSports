package br.edu.fatec.okonesports.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.edu.fatec.okonesports.business.ProdutoBusiness;
import br.edu.fatec.okonesports.business.UsuarioBusiness;
import br.edu.fatec.okonesports.enums.TipoUsuario;
import br.edu.fatec.okonesports.exception.BusinessException;
import br.edu.fatec.okonesports.model.Produto;
import br.edu.fatec.okonesports.model.Usuario;
import br.edu.fatec.okonesports.util.CurrencyUtils;

@Controller
@RequestMapping("/add_product")
public class AddProductController {
	
	private ProdutoBusiness produtoBusiness;
	private UsuarioBusiness usuarioBusiness;
	
	public AddProductController() {
		produtoBusiness = new ProdutoBusiness();
		usuarioBusiness = new UsuarioBusiness();
	}
	
	@RequestMapping(value = "")
	public ModelAndView addProduct() {
		ModelAndView mv = new ModelAndView("add_product");
		Usuario usuarioAtivo = usuarioBusiness.buscarUsuarioAtivo(); 
		mv.addObject("is_logged", usuarioAtivo != null);
		if (usuarioAtivo != null) {
			mv.addObject("is_admin", usuarioAtivo.getTipo().equals(TipoUsuario.ADMIN));
			mv.addObject("username", usuarioAtivo.getNome());
		}
		return mv;
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView saveProduct(@RequestParam("nome") String nome, 
			@RequestParam("descricao") String descricao,
			@RequestParam("preco") String preco, 
			@RequestParam("imagem") String imagem) {
		ModelAndView mv = new ModelAndView("add_product");
		Produto produto = new Produto(nome, descricao, imagem, CurrencyUtils.formatStringToBigDecimal(preco.replace(".", ",")));
		try {
			produtoBusiness.salvarProduto(produto);
			return mv;
		} catch (BusinessException e) {
			return mv;
		}
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