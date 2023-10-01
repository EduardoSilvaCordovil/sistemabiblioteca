package dao;

import entidade.Publicacao;
import javax.persistence.EntityManager;

public class PublicacaoDAO extends DAOGenerico<Publicacao> {

    public PublicacaoDAO(EntityManager em) {
        super(em, Publicacao.class);
    }
}
