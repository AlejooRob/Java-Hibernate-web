package ec.com.alexdevfs.web;

import ec.com.alexdevfs.domain.Contact;
import ec.com.alexdevfs.domain.Residence;
import ec.com.alexdevfs.domain.Student;
import ec.com.alexdevfs.service.ServiceStudent;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletUpdate")
public class ServletUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String idStudentS = req.getParameter("idStudent");
        Integer idStudent = Integer.parseInt(idStudentS);

        Student student = new Student();
        student.setIdStudent(idStudent);

        ServiceStudent serviceStudent = new ServiceStudent();
        student = serviceStudent.findStudent(student);

        HttpSession session = req.getSession();
        session.setAttribute("student", student);

        req.getRequestDispatcher("WEB-INF/updateStudent.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        ServiceStudent serviceStudent = new ServiceStudent();
        String action = req.getParameter("Modificar");

        if (action != null) {
            
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String street = req.getParameter("street");
            String streetNumber = req.getParameter("streetNumber");
            String city = req.getParameter("city");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");

            HttpSession session = req.getSession();
            Student student = (Student) session.getAttribute("student");

            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.getResidence().setStreet(street);
            student.getResidence().setStreetNumber(streetNumber);
            student.getResidence().setCity(city);
            student.getContact().setEmail(email);
            student.getContact().setPhone(phone);

            serviceStudent.saveStudent(student);

            session.removeAttribute("student");

        } else {
            String idStudentS = req.getParameter("idStudent");
            Integer idStudent = Integer.parseInt(idStudentS);
            Student student =new Student(idStudent);
            serviceStudent.deleteStudent(student);
            
        }
        req.getRequestDispatcher("index.jsp").forward(req, res);

    }

}
