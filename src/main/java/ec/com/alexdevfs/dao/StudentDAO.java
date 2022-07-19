package ec.com.alexdevfs.dao;

import ec.com.alexdevfs.domain.Student;
import java.util.List;
import javax.persistence.Query;

public class StudentDAO extends GenericDAO {
    
    public List<Student> list() {
        String req = "SELECT s FROM Student s";
        em = getEntityManager();
        Query query = em.createQuery(req);
        return query.getResultList();
    }

    public void insert(Student student) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void update(Student student) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void delete(Student student) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(student));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Student findById(Student student) {
        em = getEntityManager();
        return em.find(Student.class, student.getIdStudent());
    }
}
