package br.com.cursopcv.testes;

import br.com.cursopcv.dao.ProdutoDAO;
import br.com.cursopcv.modelo.Produto;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AlteracaoDeProduto {
    private static final Logger logger = Logger.getLogger(AlteracaoDeProduto.class.getName());

    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        try {
            produtoDAO.abrirT();

            Produto produto = produtoDAO.buscarPorCod(2);

            if (produto != null) {
                produto.setPreco(345.0);

                produtoDAO.atualizar(produto);
                produtoDAO.fecharT();

                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Produto não encontrado!");
            }
        } catch (Exception e) {
            produtoDAO.reverterT();
            logger.log(Level.SEVERE, "Não foi possível atualizar o produto.", e);
        } finally {
            produtoDAO.fechar();
        }
    }
}
