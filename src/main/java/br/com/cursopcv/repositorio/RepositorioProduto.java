package br.com.cursopcv.repositorio;

import br.com.cursopcv.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.spi.PersistenceProvider;
import org.hibernate.jpa.HibernatePersistenceProvider;

public class RepositorioProduto {
    EntityManagerFactory emf;
    EntityManager em;

    public RepositorioProduto() {
        PersistenceProvider provider = new HibernatePersistenceProvider();
        EntityManagerFactory emf = provider.createEntityManagerFactory("contestoque", null);
        this.em = emf.createEntityManager();
    }

    public void salvar(Produto produto) {
    }
}
