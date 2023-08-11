package br.com.cursopcv.dao;

import br.com.cursopcv.modelo.Produto;

public class ProdutoDAO extends AbstractDAO<Produto> {
    public ProdutoDAO() {
        super(Produto.class);
    }
}
