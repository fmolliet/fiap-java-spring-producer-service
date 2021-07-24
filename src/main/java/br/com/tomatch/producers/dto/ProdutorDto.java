package br.com.tomatch.producers.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import br.com.tomatch.producers.Produtor;

public class ProdutorDto {

	private String id;
	private String nome;
	private String email;
	private String endereco;
	private String estado;
	private String cidade;
	private String documment;

	public ProdutorDto(Produtor produtor) {
		this.id = produtor.getId();
		this.nome = produtor.getNome();
		this.email = produtor.getEmail();
		this.endereco = produtor.getEndereco();
		this.estado = produtor.getEstado();
		this.cidade = produtor.getCidade();
		this.documment = produtor.getDocumment();
	}
	
	public ProdutorDto(Optional<Produtor> produtor) {
		if ( produtor.isPresent() ) {
			Produtor prod = produtor.get();
			this.id = prod.getId();
			this.nome = prod.getNome();
			this.email = prod.getEmail();
			this.endereco = prod.getEndereco();
			this.estado = prod.getEstado();
			this.cidade = prod.getCidade();
			this.documment = prod.getDocumment();
		}
	}

	public ProdutorDto() {
		
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

	public String getDocumment() {
		return documment;
	}

	public void setDocumment(String documment) {
		this.documment = documment;
	}

	public static Page<ProdutorDto> convertPage(Page<Produtor> produtor) {
		return produtor.map(ProdutorDto::new);
	}
	
	public static List<ProdutorDto> convertList(List<Produtor> produtor) {
		return produtor.stream().map(ProdutorDto::new).collect(Collectors.toList());
	}

}
