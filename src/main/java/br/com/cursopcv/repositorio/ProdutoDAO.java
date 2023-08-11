package br.com.cursopcv.repositorio;

import br.com.cursopcv.infra.DAO;
import br.com.cursopcv.modelo.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDAO extends DAO<Produto> {
    public ProdutoDAO() {
        super(Produto.class);
    }

    @Override
    public DAO<Produto> abrirT() {
        return super.abrirT();
    }

    @Override
    public DAO<Produto> fecharT() {
        return super.fecharT();
    }

    @Override
    public DAO<Produto> reverterT() {
        return super.reverterT();
    }

    @Override
    public DAO<Produto> removerUm(Produto entidade) {
        return super.removerUm(entidade);
    }

    @Override
    public EntityManager entityManager() {
        return super.entityManager();
    }

    @Override
    public void fechar() {
        super.fechar();
    }
}
