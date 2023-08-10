package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.spi.PersistenceProvider;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RemocaoDeProduto {
    private static final Logger logger = Logger.getLogger(RemocaoDeProduto.class.getName());

    public static void main(String[] args) {
        PersistenceProvider provider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory = provider.createEntityManagerFactory("contestoque", null);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction  = entityManager.getTransaction();
        transaction.begin();

        try {
            Produto produto = entityManager.find(Produto.class, 3);

            if (produto != null) {
                entityManager.remove(produto);
                transaction.commit();

                System.out.println("Produto removido com sucesso");
            } else {
                System.out.println("Produto não encontrado");
            }
        } catch (Exception e) {
            transaction.rollback();
            logger.log(Level.SEVERE, "Um erro ocorreu na execução do programa.", e);
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
