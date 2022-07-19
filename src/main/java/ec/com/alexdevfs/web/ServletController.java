package ec.com.alexdevfs.web;

import ec.com.alexdevfs.domain.Student;
import ec.com.alexdevfs.service.ServiceStudent;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServiceStudent serviceStudent = new ServiceStudent();
        
        List<Student> students = serviceStudent.listStudents();
        req.setAttribute("students", students);
        req.getRequestDispatcher("/WEB-INF/listStudents.jsp").forward(req, res);
        
    }
}
