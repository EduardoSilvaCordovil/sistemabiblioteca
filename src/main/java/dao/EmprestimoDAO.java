package dao;

import entidade.Emprestimo;
import javax.persistence.EntityManager;

public class EmprestimoDAO extends DAOGenerico<Emprestimo> {
    
    public EmprestimoDAO(EntityManager em) {
        super(em, Emprestimo.class);
    }
}
