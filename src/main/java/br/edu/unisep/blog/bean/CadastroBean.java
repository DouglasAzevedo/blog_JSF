package br.edu.unisep.blog.bean;


import br.edu.unisep.blog.dto.CadastroDto;
import br.edu.unisep.blog.entity.Usuario;
import br.edu.unisep.blog.repository.CadastroRepository;
import com.rcpadilha.hibernate.exception.DaoException;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CadastroBean {

    @Setter
    @Getter
    private CadastroDto novoCadastro = new CadastroDto();

    private CadastroRepository repo = new CadastroRepository();


    public String salvar() {
        try {
            repo.salvar(novoCadastro);
            return "/index?faces-redirect-true";
        } catch (DaoException e) {
            e.printStackTrace();
            return "Erro ao Cadastrar.";
        }
    }

}
