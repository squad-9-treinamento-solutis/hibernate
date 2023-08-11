package br.com.cursopcv.testes;

import br.com.cursopcv.dao.ProdutoDAO;
import br.com.cursopcv.modelo.Produto;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RemocaoDeProduto {
    private static final Logger logger = Logger.getLogger(RemocaoDeProduto.class.getName());

    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        try {
            produtoDAO.abrirT();
            Produto produto = produtoDAO.buscarPorCod(3);

            if (produto != null) {
                produtoDAO.removerUm(produto);
                produtoDAO.fecharT();

                System.out.println("Produto removido com sucesso");
            } else {
                System.out.println("Produto não encontrado");
            }
        } catch (Exception e) {
            produtoDAO.reverterT();
            logger.log(Level.SEVERE, "Não conseguimos remover o produto.", e);
        } finally {
            produtoDAO.fechar();
        }
    }
}
