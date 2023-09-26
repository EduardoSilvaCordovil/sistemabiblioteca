package dao;

import entidade.Emprestimo;
import java.util.List;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class EmprestimoDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemabiblioteca"); // Substitua pelo nome da sua unidade de persistência.

    public void incluirEmprestimo(Emprestimo emprestimo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(emprestimo);
        em.getTransaction().commit();
        em.close();
    }

    public void alterarEmprestimo(Emprestimo emprestimo) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(emprestimo);
        em.getTransaction().commit();
        em.close();
    }

    public void deletarEmprestimo(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Emprestimo emprestimo = em.find(Emprestimo.class, id);
        if (emprestimo != null) {
            em.remove(emprestimo);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Emprestimo consultarEmprestimo(Long id) {
        EntityManager em = emf.createEntityManager();
        Emprestimo emprestimo = em.find(Emprestimo.class, id);
        em.close();
        return emprestimo;
    }
}
