package info4.desenvolvimento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InfluencerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String contato;
	
	@Column(nullable = false)
	private String  campanhaAnterior;
	
	@Column(nullable = false)
	private String  seguimento;
	
	@Column(nullable = false)
	private String  redeSocial;
	
	@Column(nullable = false)
	private String  publicoAlvo;
	
	@Column(nullable = false)
	private String  idadePublico;
	
	@Column(nullable = false)
	private Integer  alcance;
	
	

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

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getCampanhaAnterior() {
		return campanhaAnterior;
	}

	public void setCampanhaAnterior(String campanhaAnterior) {
		this.campanhaAnterior = campanhaAnterior;
	}

	public String getSeguimento() {
		return seguimento;
	}

	public void setSeguimento(String seguimento) {
		this.seguimento = seguimento;
	}

	public String getRedeSocial() {
		return redeSocial;
	}

	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}

	public String getPublicoAlvo() {
		return publicoAlvo;
	}

	public void setPublicoAlvo(String publicoAlvo) {
		this.publicoAlvo = publicoAlvo;
	}

	public String getIdadePublico() {
		return idadePublico;
	}

	public void setIdadePublico(String idadePublico) {
		this.idadePublico = idadePublico;
	}

	public Integer getAlcance() {
		return alcance;
	}

	public void setAlcance(Integer alcance) {
		this.alcance = alcance;
	}

	public InfluencerModel(Integer id, String nome, String contato, String campanhaAnterior, String seguimento,
			String redeSocial, String publicoAlvo, String idadePublico, Integer alcance) {
		super();
		this.id = id;
		this.nome = nome;
		this.contato = contato;
		this.campanhaAnterior = campanhaAnterior;
		this.seguimento = seguimento;
		this.redeSocial = redeSocial;
		this.publicoAlvo = publicoAlvo;
		this.idadePublico = idadePublico;
		this.alcance = alcance;
	}

	public InfluencerModel() {
		super();
	}

	
	
	
	
}
