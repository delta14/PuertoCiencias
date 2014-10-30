/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import dao.UsuarioDao;
import dao.UsuarioDaoImpl;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import model.Usuario;
import org.primefaces.context.RequestContext;
    
/**
 *
 * @author Roberto
 */
@Named(value="loginBean")
@SessionScoped
public class loginBean implements Serializable {

   private Usuario usuario;
   private UsuarioDao usuarioDao;
   
   public loginBean(){
       this.usuarioDao = new UsuarioDaoImpl();
       if(this.usuario==null){
           this.usuario = new Usuario();
       }
   }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   
   
   
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message;
        boolean loggedIn;
        String ruta="";
        this.usuario = this.usuarioDao.login(usuario);
        if(this.usuario!= null) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido!!!",this.usuario.getUsername());
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Usuario y/o Clave incorrecta.");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }  
}
