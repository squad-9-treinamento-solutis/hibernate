package br.com.cursopcv.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO<T> {
    private static final Logger logger = Logger.getLogger(DAO.class.getName());
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

    public DAO() {
        this(null);
    }

    public DAO(Class<T> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO<T> abrirT() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<T> fecharT() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<T> reverterT() {
        em.getTransaction().rollback();
        return this;
    }

    public EntityManager entityManager() {
        return em;
    }

    public DAO<T> removerUm(T entidade) {
        em.remove(entidade);
        return this;
    }

    // Fechando ambos EntityManager e EntityManagerFactory
    public void fechar() {
        em.close();
        emf.close();
    }
}
