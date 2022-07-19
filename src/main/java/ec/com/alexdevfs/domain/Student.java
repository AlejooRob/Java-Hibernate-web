package ec.com.alexdevfs.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="alumno")
public class Student implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_alumno")
    private Integer idStudent;
    
    @Column(name="nombre")
    private String firstName;
    
    @Column(name = "apellido")
    private String lastName;
    
    @JoinColumn(name="id_domicilio", referencedColumnName = "id_domicilio")
    @ManyToOne(cascade = CascadeType.ALL)
    private Residence residence;
    
    @JoinColumn(name="id_contacto", referencedColumnName = "id_contacto")
    @ManyToOne(cascade = CascadeType.ALL)
    private Contact contact;
    
    @OneToMany(mappedBy = "student")
    private List<Assigment> assigments;

    public Student() {
    }

    public Student(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Assigment> getAssigments() {
        return assigments;
    }

    public void setAssigments(List<Assigment> assigments) {
        this.assigments = assigments;
    }

    @Override
    public String toString() {
        return "Student{" + "idStudent=" + idStudent + ", firstName=" + firstName + ", lastName=" + lastName + ", residence=" + residence + ", contact=" + contact + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idStudent);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.idStudent, other.idStudent)) {
            return false;
        }
        return true;
    }
    
    
    
}
