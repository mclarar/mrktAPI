package info4.desenvolvimento.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Entity
public class UsuarioModel {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	
	@Pattern(regexp = "^[A-Z]+(.)*")
	@Column(nullable = false)
	private String nome;
	
	@Email
	@Column(unique = true)
	private String email;
	
	@JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
	@Column(nullable = false)
	private String senha;
	
//	@Column(nullable = false)
//	private String cargo;
	

//	public String getCargo() {
//		return cargo;
//	}
//
//	public void setCargo(String cargo) {
//		this.cargo = cargo;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioModel(Integer id, String nome, @Email String email, String senha, String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		
	}

	public UsuarioModel() {
		super();
	}



	
	
	
}
