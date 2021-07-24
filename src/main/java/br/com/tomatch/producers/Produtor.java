package br.com.tomatch.producers;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtores")
public class Produtor {

    @Id
    private String id;
    private String nome;
    private String email;
    private String endereco;
    private String estado;
    private String cidade;
    private String documment;

    private StatusProdutor status = StatusProdutor.ACTIVATED;

    public Produtor(String nome, String email, String endereco, String documment, String estado, String cidade) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.estado = estado;
        this.cidade = cidade;
        this.documment = documment;
    }

    public Produtor(String id, String nome, String email, String endereco, String estado, String cidade,
            String documment, StatusProdutor status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.estado = estado;
        this.cidade = cidade;
        this.documment = documment;
        this.status = status;
    }

    public Produtor() {

    }

    public Produtor(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public StatusProdutor getStatus() {
        return status;
    }

    public void setStatus(StatusProdutor status) {
        this.status = status;
    }

    // public List<Produto> getProdutos() {
    // return produtos;
    // }

    // public void setProdutos(List<Produto> produtos) {
    // this.produtos = produtos;
    // }

    public String getDocumment() {
        return documment;
    }

    public void setDocumment(String documment) {
        this.documment = documment;
    }

}
