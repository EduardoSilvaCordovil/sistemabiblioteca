package dao;

import entidade.Emprestimo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmprestimoDAO {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemabiblioteca");
        return factory.createEntityManager();
    }

    public Emprestimo salvar(Emprestimo emprestimo) {
        EntityManager em = getEM();
        try {
            em.getTransaction().begin();
            em.persist(emprestimo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return emprestimo;
    }
}
