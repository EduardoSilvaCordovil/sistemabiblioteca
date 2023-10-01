package dao;

import javax.persistence.*;

public class DAOGenerico<T> {

    private final EntityManager em;
    private final Class<T> entityClass;

    public DAOGenerico(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public T findById(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public DAOGenerico(Class<T> entityClass) {
        this.entityClass = entityClass;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemabiblioteca");
        EntityManager entityManager = factory.createEntityManager();
        this.em = entityManager;
    }

    public EntityManager getEntityManager() {
        return this.em;
    }

    public T salvar(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return entity;
    }

    public T consultar(Long id) {
        return em.find(entityClass, id);
    }

    public T atualizar(T entity) {
        try {
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return entity;
    }

    public void deletar(T entity) {
        try {
            em.getTransaction().begin();
            getEntityManager().remove(getEntityManager().merge(entity));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
    
    public T exibirLista(T entity) {
        return entity;
    }
   
}
