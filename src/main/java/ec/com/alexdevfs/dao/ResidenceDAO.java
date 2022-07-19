package ec.com.alexdevfs.dao;

import ec.com.alexdevfs.domain.Residence;
import java.util.List;
import javax.persistence.Query;

public class ResidenceDAO extends GenericDAO {

    public List<Residence> list() {
        String req = "SELECT r FROM Residence r";
        em = getEntityManager();
        Query query = em.createQuery(req);
        return query.getResultList();
    }

    public void insert(Residence residence) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(residence);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void update(Residence residence) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(residence);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void delete(Residence residence) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(residence));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Residence findById(Residence residence) {
        em = getEntityManager();
        return em.find(Residence.class, residence.getIdResidence());
    }
    
}
