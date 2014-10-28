package model;
// Generated 28/10/2014 02:52:49 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Usuario generated by hbm2java
 */
@Entity
@Table(name="usuario"
    ,catalog="proyectoingsoft"
    , uniqueConstraints = @UniqueConstraint(columnNames="username") 
)
public class Usuario  implements java.io.Serializable {


     private String idCuenta;
     private String username;
     private String correo;
     private String pass;
     private Set comentarios = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(String idCuenta, String username, String correo, String pass) {
        this.idCuenta = idCuenta;
        this.username = username;
        this.correo = correo;
        this.pass = pass;
    }
    public Usuario(String idCuenta, String username, String correo, String pass, Set comentarios) {
       this.idCuenta = idCuenta;
       this.username = username;
       this.correo = correo;
       this.pass = pass;
       this.comentarios = comentarios;
    }
   
     @Id 

    
    @Column(name="idCuenta", unique=true, nullable=false, length=9)
    public String getIdCuenta() {
        return this.idCuenta;
    }
    
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    
    @Column(name="username", unique=true, nullable=false, length=30)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="correo", nullable=false, length=50)
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    @Column(name="pass", nullable=false, length=32)
    public String getPass() {
        return this.pass;
    }
    
    public void setPass(String pass) {
        this.pass = pass;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
    public Set getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(Set comentarios) {
        this.comentarios = comentarios;
    }




}


