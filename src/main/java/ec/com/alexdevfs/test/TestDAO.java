package ec.com.alexdevfs.test;

import ec.com.alexdevfs.dao.AssigmentDAO;
import ec.com.alexdevfs.dao.CourseDAO;
import ec.com.alexdevfs.dao.ResidenceDAO;
import ec.com.alexdevfs.dao.StudentDAO;
import java.util.List;

public class TestDAO {
    public static void main(String[] args) {
        StudentDAO studentDao = new StudentDAO();
        System.out.println("Alumnos:");
        print(studentDao.list());
        
        System.out.println("Domicilios:");
        ResidenceDAO residenceDao = new ResidenceDAO();
        print(residenceDao.list());
        
        System.out.println("Cursos:");
        CourseDAO courseDao = new CourseDAO();
        print(courseDao.list());
        
        System.out.println("Asignaciones:");
        AssigmentDAO assigmentDao = new AssigmentDAO();
        print(assigmentDao.list());
    }
    
    private static void print(List collection) {
        for(Object c: collection) {
            System.out.println("valor = " + c);
        }
    }
}
