package model;
// Generated 28/10/2014 02:52:49 PM by Hibernate Tools 3.6.0


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Comentario generated by hbm2java
 */
@Entity
@Table(name="comentario"
    ,catalog="proyectoingsoft"
)
public class Comentario  implements java.io.Serializable {


     private int idComentario;
     private Date timestamp;
     private Usuario usuario;
     private Curso curso;
     private BigDecimal valNum;
     private String text;
     private int votos;

    public Comentario() {
    }

    public Comentario(int idComentario, Usuario usuario, Curso curso, BigDecimal valNum, String text, int votos) {
       this.idComentario = idComentario;
       this.usuario = usuario;
       this.curso = curso;
       this.valNum = valNum;
       this.text = text;
       this.votos = votos;
    }
   
     @Id 

    
    @Column(name="idComentario", unique=true, nullable=false)
    public int getIdComentario() {
        return this.idComentario;
    }
    
    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    /**
     *
     * @return
     */
    @Version@Temporal(TemporalType.TIMESTAMP)
    @Column(name="timestamp", nullable=false, length=19)
    public Date getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="usaurio", nullable=false)
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="curso", nullable=false)
    public Curso getCurso() {
        return this.curso;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    
    @Column(name="valNum", nullable=false, precision=2, scale=1)
    public BigDecimal getValNum() {
        return this.valNum;
    }
    
    public void setValNum(BigDecimal valNum) {
        this.valNum = valNum;
    }

    
    @Column(name="text", nullable=false)
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }

    
    @Column(name="votos", nullable=false)
    public int getVotos() {
        return this.votos;
    }
    
    public void setVotos(int votos) {
        this.votos = votos;
    }




}


