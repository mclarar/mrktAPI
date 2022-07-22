package info4.desenvolvimento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class EmpresaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column (nullable = false)
	private String nome;
	
	@CNPJ
	private String cnpj;
	
	@Column (nullable = false)
	private String razaoSoci;
	
	@Column (nullable = false)
	private String seguimento;
	
	@Column (nullable = false)
	private String produto;
	
	@Column (nullable = false)
	private String contato;
	
	@Column (nullable = false)
	private String focalPont;
	
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getRazaoSoci() {
		return razaoSoci;
	}
	public void setRazaoSoci(String razaoSoci) {
		this.razaoSoci = razaoSoci;
	}
	public String getSeguimento() {
		return seguimento;
	}
	public void setSeguimento(String seguimento) {
		this.seguimento = seguimento;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getFocalPont() {
		return focalPont;
	}
	public void setFocalPont(String focalPont) {
		this.focalPont = focalPont;
	}
	public Integer getId() {
		return id;
	}
	
	public EmpresaModel(Integer id, String nome, String cnpj, String razaoSoci, String seguimento, String produto,
			String contato, String focalPont) {
		super();
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.razaoSoci = razaoSoci;
		this.seguimento = seguimento;
		this.produto = produto;
		this.contato = contato;
		this.focalPont = focalPont;
	}
	public EmpresaModel() {
		super();
	}
	
	
	
	
	
}
