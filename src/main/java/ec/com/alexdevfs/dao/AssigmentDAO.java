package ec.com.alexdevfs.dao;

import static ec.com.alexdevfs.dao.GenericDAO.em;
import ec.com.alexdevfs.domain.Assigment;
import java.util.List;
import javax.persistence.Query;

public class AssigmentDAO extends GenericDAO{
    
    public List<Assigment> list() {
        String req = "SELECT a FROM Assigment a";
        em = getEntityManager();
        Query query = em.createQuery(req);
        return query.getResultList();
    }

    public void insert(Assigment assigment) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(assigment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void update(Assigment assigment) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(assigment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void delete(Assigment assigment) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(assigment));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Assigment findById(Assigment assigment) {
        em = getEntityManager();
        return em.find(Assigment.class, assigment.getIdAssigment());
    }
}
