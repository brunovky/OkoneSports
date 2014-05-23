package br.edu.fatec.okonesports.business;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import br.edu.fatec.okonesports.dao.DAO;
import br.edu.fatec.okonesports.exception.BusinessException;
import br.edu.fatec.okonesports.exception.DAOException;
import br.edu.fatec.okonesports.model.Usuario;

@Service
public class UsuarioBusiness {

	private DAO<Usuario> usuarioDAO;

	public UsuarioBusiness() {
		usuarioDAO = new DAO<>();
	}

	public Usuario buscarUsuarioAtivo() {
		DetachedCriteria query = DetachedCriteria.forClass(Usuario.class);
		query.add(Restrictions.eq("ativo", true));
		return usuarioDAO.buscarModel(query);
	}

	public Usuario buscarUsuario(String nomeOuEmail, String senha) {
		DetachedCriteria query = DetachedCriteria.forClass(Usuario.class);
		Disjunction or = Restrictions.disjunction();
		or.add(Restrictions.eq("nome", nomeOuEmail));
		or.add(Restrictions.eq("email", nomeOuEmail));
		query.add(or);
		query.add(Restrictions.eq("senha", senha));
		return usuarioDAO.buscarModel(query);
	}

	public Usuario salvarUsuario(Usuario usuario) throws BusinessException {
		try {
			return usuarioDAO.salvar(usuario);
		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());
		}
	}
	
	public Usuario alterarUsuario(Usuario usuario) throws BusinessException {
		try {
			return usuarioDAO.alterar(usuario);
		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());
		}
	}

}