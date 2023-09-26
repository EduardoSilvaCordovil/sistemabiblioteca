package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class DAOFachada<T> {


    private Class<T> entityClass;
    private EntityManager em;

    public DAOFachada(Class<T> entityClass) {
        this.entityClass = entityClass;
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("sistemabiblioteca");
        EntityManager entityManager = factory.createEntityManager();
        this.em = entityManager;
    }

    public EntityManager getEntityManager() {
        return this.em;
    }

    public void insert(T entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        getEntityManager().persist(entity);
        transaction.commit();
    }

    public void update(T entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        getEntityManager().merge(entity);
        transaction.commit();
    }

    public void delete(T entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        transaction.commit();
    }

    public T findById(Object id) {
        return getEntityManager().find(entityClass, id);
    }

}
