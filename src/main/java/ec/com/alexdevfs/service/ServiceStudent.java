package ec.com.alexdevfs.service;

import ec.com.alexdevfs.dao.StudentDAO;
import ec.com.alexdevfs.domain.Student;
import java.util.List;

public class ServiceStudent {
    
    StudentDAO studentDao = new StudentDAO();
    
    public List<Student> listStudents() {
        return studentDao.list();
    }
    
    public void saveStudent(Student student) {
        if(student != null && student.getIdStudent() == null) {
            studentDao.insert(student);
        }
        else {
            studentDao.update(student);
        }
    }
    
    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }
    
    public Student findStudent(Student student) {
        return studentDao.findById(student);
    }
}
