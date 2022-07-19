package ec.com.alexdevfs.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO {
    
    protected static EntityManager em;
    protected static EntityManagerFactory emf;
    protected static final String PU = "HibernateJpaPU";

    public GenericDAO() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    
    protected EntityManager getEntityManager() {
        if(em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }
        return em;
    }
}
