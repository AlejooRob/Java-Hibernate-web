package ec.com.alexdevfs.dao;

import static ec.com.alexdevfs.dao.GenericDAO.em;
import ec.com.alexdevfs.domain.Contact;
import java.util.List;
import javax.persistence.Query;


public class ContactDAO extends GenericDAO{
    
    public List<Contact> list() {
        String req = "SELECT c FROM Contact c";
        em = getEntityManager();
        Query query = em.createQuery(req);
        return query.getResultList();
    }

    public void insert(Contact contact) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contact);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void update(Contact contact) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(contact);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void delete(Contact contact) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(contact));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Contact findById(Contact contact) {
        em = getEntityManager();
        return em.find(Contact.class, contact.getIdContact());
    }
}
