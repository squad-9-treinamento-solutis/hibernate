package br.com.cursopcv.testes;

import br.com.cursopcv.modelo.Produto;
import br.com.cursopcv.repositorio.ProdutoDAO;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RemocaoDeProduto {
    private static final Logger logger = Logger.getLogger(RemocaoDeProduto.class.getName());

    public static void main(String[] args) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.abrirT();

        try {
            Produto produto = produtoDAO.entityManager().find(Produto.class, 3);

            if (produto != null) {
                produtoDAO.removerUm(produto);
                produtoDAO.fecharT();

                System.out.println("Produto removido com sucesso");
            } else {
                System.out.println("Produto não encontrado");
            }
        } catch (Exception e) {
            produtoDAO.reverterT();
            logger.log(Level.SEVERE, "Um erro ocorreu na execução do programa.", e);
        } finally {
            produtoDAO.fechar();
        }
    }
}
