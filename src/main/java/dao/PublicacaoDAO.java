package dao;

import entidade.Publicacao;
import javax.persistence.*;

public class PublicacaoDAO {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemabiblioteca");
        return factory.createEntityManager();
    }

    public Publicacao salvar(Publicacao publicacao) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(publicacao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return publicacao;
    }
}
