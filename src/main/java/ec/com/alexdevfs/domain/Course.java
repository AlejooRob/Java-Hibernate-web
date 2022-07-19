package ec.com.alexdevfs.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="curso")
public class Course implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_curso")
    private Integer idCourse;
    
    @Column(name ="nombre")
    private String name;
    
    @Column(name="precio")
    private Double price;
    
    @OneToMany(mappedBy = "course")
    private List<Assigment> assigments;

    public Course() {
    }

    public Course(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Assigment> getAssigments() {
        return assigments;
    }

    public void setAssigments(List<Assigment> assigments) {
        this.assigments = assigments;
    }
    
    @Override
    public String toString() {
        return "Course{" + "idCourse=" + idCourse + ", name=" + name + ", price=" + price + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idCourse);
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
        final Course other = (Course) obj;
        if (!Objects.equals(this.idCourse, other.idCourse)) {
            return false;
        }
        return true;
    }
    
    
}
