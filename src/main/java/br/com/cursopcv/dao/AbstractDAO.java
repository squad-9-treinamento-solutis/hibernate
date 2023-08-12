package br.com.cursopcv.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractDAO<T> {
    private static final Logger logger = Logger.getLogger(AbstractDAO.class.getName());
    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence
                    .createEntityManagerFactory("contestoque");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Não possível criar o EntityManagerFactory", e);
        }
    }

    private final EntityManager em;
    private final Class<T> classe;

    public AbstractDAO(Class<T> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public void abrirT() {
        em.getTransaction().begin();
    }

    public void fecharT() {
        em.getTransaction().commit();
    }

    public void reverterT() {
        em.getTransaction().rollback();
    }

    public T buscarPorCod(Object cod) {
        return em.find(classe, cod);
    }

    public void removerUm(T entidade) {
        em.remove(entidade);
    }

    public void atualizar(T entidade) {
        em.merge(entidade);
    }

    public void inserir(Object T) {
        em.persist(T);
    }

    public List<T> ListaTodosProdutos() {
        if (classe == null) {
            throw new UnsupportedOperationException("Classe nula.");
        }

        String jpql = "select * from " + classe.getName();
        TypedQuery<T> query = em.createQuery(jpql, classe);

        return query.getResultList();
    }

    // Fechando ambos EntityManager e EntityManagerFactory
    public void fechar() {
        em.close();
        emf.close();
    }
}
