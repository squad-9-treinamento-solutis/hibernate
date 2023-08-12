package br.com.cursopcv.testes;

import br.com.cursopcv.dao.ProdutoDAO;
import br.com.cursopcv.modelo.Produto;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InclusaoDeProduto {
    private static final Logger logger = Logger.getLogger(AlteracaoDeProduto.class.getName());

    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        try {
            produtoDAO.abrirT();

            Produto prop1 = new Produto("Panela", "Panela de Pressão 10 Litros", 56.80);
            Produto prop2 = new Produto("Cama", "Cama de casal Big", 450.68);
            Produto prop3 = new Produto("Caixa Som", "Caixa de Som JBL", 160.00);

            produtoDAO.inserir(prop1);
            produtoDAO.inserir(prop2);
            produtoDAO.inserir(prop3);

            produtoDAO.fecharT();
            System.out.println("Produtos cadastrados com sucesso!");
        } catch (Exception e) {
            produtoDAO.reverterT();
            logger.log(Level.SEVERE, "Não foi possível criar o produto.", e);
        } finally {
            produtoDAO.fechar();
        }
    }
}