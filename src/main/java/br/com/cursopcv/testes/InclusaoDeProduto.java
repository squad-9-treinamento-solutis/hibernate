package br.com.cursopcv.testes;

import org.hibernate.jpa.HibernatePersistenceProvider;

import br.com.cursopcv.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.spi.PersistenceProvider;

public class InclusaoDeProduto {
    public static void main(String[] args) {
        // Configurar a sessão do Hibernate
        PersistenceProvider provider = new HibernatePersistenceProvider();
        EntityManagerFactory entityManagerFactory = provider.createEntityManagerFactory("contestoque", null);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction  = entityManager.getTransaction();
        transaction.begin();
        try {
            // Cadastrar os produtos
            Produto prop1 = new Produto("Panela", "Panela de Pressão 10 Litros", 56.80);
            Produto prop2 = new Produto("Cama", "Cama de casal Big", 450.68);
            Produto prop3 = new Produto("Caixa Som", "Caixa de Som JBL", 160.00);

            entityManager.persist(prop1);
            entityManager.persist(prop2);
            entityManager.persist(prop3);

            // Confirmar a transação
            transaction.commit();
            System.out.println("Produtos cadastrados com sucesso!");
        } catch (Exception e) {
            // Em caso de erro, fazer rollback da transação
            transaction.rollback();
            e.printStackTrace();
        } finally {
            // Fechar a sessão do Hibernate
            entityManager.close();
        }
    }
}