package ec.com.alexdevfs.web;

import ec.com.alexdevfs.domain.Contact;
import ec.com.alexdevfs.domain.Residence;
import ec.com.alexdevfs.domain.Student;
import ec.com.alexdevfs.service.ServiceStudent;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/ServletAdd")
public class ServletAdd extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String street = req.getParameter("street");
        String streetNumber = req.getParameter("streetNumber");
        String city = req.getParameter("city");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        
        Residence residence = new Residence();
        residence.setStreet(street);
        residence.setStreetNumber(streetNumber);
        residence.setCity(city);
        
        Contact contact = new Contact();
        contact.setEmail(email);
        contact.setPhone(phone);
        
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setResidence(residence);
        student.setContact(contact);
        
        ServiceStudent serviceStudent = new ServiceStudent();
        serviceStudent.saveStudent(student);
        
        req.getRequestDispatcher("index.jsp").forward(req, res);
    }
}
