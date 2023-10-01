package dao;

import entidade.Aluno;
import javax.persistence.EntityManager;

public class AlunoDAO extends DAOGenerico<Aluno> {

    public AlunoDAO(EntityManager em) {
        super(em, Aluno.class);
    }
}
