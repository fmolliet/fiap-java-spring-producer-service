package br.com.tomatch.producers.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.tomatch.producers.Produtor;

public class ProdutorForm {

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String nome;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String email;

    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String endereco;
    private String estado;
    private String cidade;

    @NotNull
    @NotEmpty
    @Length(min = 11)
    private String documment;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDocumment() {
        return documment;
    }

    public void setDocumment(String documment) {
        this.documment = documment;
    }

    public Produtor converter() {
        return new Produtor(nome, email, endereco, documment, estado, cidade);
    }

}
