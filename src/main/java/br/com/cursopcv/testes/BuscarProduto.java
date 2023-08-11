package br.com.cursopcv.testes;

import br.com.cursopcv.dao.ProdutoDAO;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BuscarProduto {
    private static final Logger logger = Logger.getLogger(BuscarProduto.class.getName());

    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        try {
            produtoDAO.abrirT();

            System.out.println("Produto encontrado com sucesso: \n" + produtoDAO.buscarPorCod(1));

            produtoDAO.fecharT();
        } catch (Exception e) {
            produtoDAO.reverterT();
            logger.log(Level.SEVERE, "Não conseguimos encontrar o produto.", e);
        } finally {
            produtoDAO.fechar();
        }
    }
}
