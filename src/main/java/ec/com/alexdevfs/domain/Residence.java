package ec.com.alexdevfs.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name="domicilio")
public class Residence implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_domicilio")
    private Integer idResidence;
    
    @Column(name ="calle")
    private String street;
    
    @Column(name ="no_calle")
    private String streetNumber;
    
    @Column(name ="ciudad")
    private String city;
    
    public Residence() {
    }

    public Residence(Integer idResidence) {
        this.idResidence = idResidence;
    }

    public Integer getIdResidence() {
        return idResidence;
    }

    public void setIdResidence(Integer idResidence) {
        this.idResidence = idResidence;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Residence{" + "idResidence=" + idResidence + ", street=" + street + ", streetNumber=" + streetNumber + ", city=" + city + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.idResidence);
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
        final Residence other = (Residence) obj;
        if (!Objects.equals(this.idResidence, other.idResidence)) {
            return false;
        }
        return true;
    }
    
    

}
