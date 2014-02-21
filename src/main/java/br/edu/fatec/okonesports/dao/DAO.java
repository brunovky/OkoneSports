package br.edu.fatec.okonesports.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import br.edu.fatec.okonesports.exception.DAOException;
import br.edu.fatec.okonesports.hibernate.HibernateUtil;

public class DAO<T> {

	private Session session;

	public T salvar(T entity) throws DAOException {
		try {
			getSession().beginTransaction();
			getSession().save(entity);
			getSession().getTransaction().commit();
			return entity;
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			throw new DAOException("Erro na inserção de entidade");
		} finally {
			getSession().close();
		}
	}

	public T alterar(T entity) throws DAOException {
		try {
			getSession().beginTransaction();
			getSession().update(entity);
			getSession().getTransaction().commit();
			return entity;
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			throw new DAOException("Erro na atualização de entidade");
		} finally {
			getSession().close();
		}
	}

	public void excluir(T entity) throws DAOException {
		try {
			getSession().beginTransaction();
			getSession().delete(entity);
			getSession().getTransaction().commit();
		} catch (Exception e) {
			getSession().getTransaction().rollback();
			throw new DAOException("Erro na exclusão de entidade");
		} finally {
			getSession().close();
		}
	}

	@SuppressWarnings("unchecked")
	public T buscarModel(DetachedCriteria query) {
		T model = (T) query.getExecutableCriteria(getSession()).uniqueResult();
		getSession().close();
		return model;
	}

	@SuppressWarnings("unchecked")
	public List<T> buscarModels(DetachedCriteria query) {
		List<T> models = query.getExecutableCriteria(getSession()).list();
		getSession().close();
		return models;
	}

	private Session getSession() {
		if (session == null || !session.isOpen())
			session = HibernateUtil.getSessionFactory().openSession();
		return session;
	}

}