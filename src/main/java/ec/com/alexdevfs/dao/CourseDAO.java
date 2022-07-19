package ec.com.alexdevfs.dao;

import static ec.com.alexdevfs.dao.GenericDAO.em;
import ec.com.alexdevfs.domain.Course;
import java.util.List;
import javax.persistence.Query;

public class CourseDAO extends GenericDAO {
    
    public List<Course> list() {
        String req = "SELECT c FROM Course c";
        em = getEntityManager();
        Query query = em.createQuery(req);
        return query.getResultList();
    }

    public void insert(Course course) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void update(Course course) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void delete(Course course) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(course));
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public Course findById(Course course) {
        em = getEntityManager();
        return em.find(Course.class, course.getIdCourse());
    }
}
