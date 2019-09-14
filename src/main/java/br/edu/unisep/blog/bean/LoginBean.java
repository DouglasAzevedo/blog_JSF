package br.edu.unisep.blog.bean;

import br.edu.unisep.blog.dto.LoginDto;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class LoginBean {

    @Getter @Setter
    private LoginDto dadosLogin = new LoginDto();

    @Inject
    private ExternalContext externalContext;

    @Inject
    private FacesContext facesContext;

    @Inject
    private UsuarioBean usuarioBean;

    public String entrar() {

        var req = (HttpServletRequest) externalContext.getRequest();

        try {

            req.logout();

            var senha = DigestUtils.md5Hex(dadosLogin.getSenha());
            req.login(dadosLogin.getLogin(), senha);

            usuarioBean.obterUsuario(dadosLogin.getLogin());

            return "app/home?faces-redirect=true";

        } catch (Exception e) {
            e.printStackTrace();

            facesContext.addMessage("frmLogin:login",
                    new FacesMessage("Dados inválidos para o login"));

            return "login";
        }
    }

}
