package br.edu.fatec.okonesports.business;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;

import br.edu.fatec.okonesports.dao.DAO;
import br.edu.fatec.okonesports.exception.BusinessException;
import br.edu.fatec.okonesports.exception.DAOException;
import br.edu.fatec.okonesports.model.Produto;

@Service
public class ProdutoBusiness {
	
	private DAO<Produto> produtoDAO;
	
	public ProdutoBusiness() {
		produtoDAO = new DAO<>();
	}
	
	public List<Produto> buscarProdutos() {
		return produtoDAO.buscarModels(DetachedCriteria.forClass(Produto.class));
	}
	
	public Produto salvarProduto(Produto produto) throws BusinessException {
		try {
			return produtoDAO.salvar(produto);
		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());
		}
	}

}