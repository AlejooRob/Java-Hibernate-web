package ec.com.alexdevfs.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="asignacion")
public class Assigment implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_asignacion")
    private Integer idAssigment;
    
    @Column(name = "turno")
    private String turn;
    
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    @ManyToOne
    private Student student;
    
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private Course course;

    public Assigment() {
    }

    public Assigment(Integer idAssigment) {
        this.idAssigment = idAssigment;
    }

    public Integer getIdAssigment() {
        return idAssigment;
    }

    public void setIdAssigment(Integer idAssigment) {
        this.idAssigment = idAssigment;
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Assigment{" + "idAssigment=" + idAssigment + ", turn=" + turn + ", student=" + student + ", course=" + course + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.idAssigment);
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
        final Assigment other = (Assigment) obj;
        if (!Objects.equals(this.idAssigment, other.idAssigment)) {
            return false;
        }
        return true;
    }
    
    
    
}
