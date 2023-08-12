package br.com.cursopcv.testes;
import br.com.cursopcv.dao.ProdutoDAO;
import br.com.cursopcv.modelo.Produto;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaTodosProdutos {
    private static final Logger logger = Logger.getLogger(ListaTodosProdutos.class.getName());
    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        try {
            List<Produto> produtos = produtoDAO.ListaTodosProdutos();

            for (Produto prod : produtos) {
                System.out.println("ID: " + prod.getCod());
                System.out.println("Nome: " + prod.getNome());
                System.out.println("Preço: " + prod.getPreco());
                System.out.println("Descrição: " + prod.getDescricao());
                System.out.println("===========================");
            }

            produtoDAO.fecharT();
        } catch (Exception e) {
            produtoDAO.reverterT();
            logger.log(Level.SEVERE, "Não foi possível listar os produtos.", e);
        } finally {
            produtoDAO.fechar();
        }
    }
}