package info4.desenvolvimento.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class AcaoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	private String nomeDaCampanha;
	
	private String descricao;
	
	private Double orcamento;
	
	private String duracaoCampanha;
	
	private String redeSocial;

	private String publico;
	
	private String influencer;
	
	
	public String getNomeDaCampanha() {
		return nomeDaCampanha;
	}
	public void setNomeDaCampanha(String nomeDaCampanha) {
		this.nomeDaCampanha = nomeDaCampanha;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}
	public String getDuracaoCampanha() {
		return duracaoCampanha;
	}
	public void setDuracaoCampanha(String duracaoCampanha) {
		this.duracaoCampanha = duracaoCampanha;
	}
	public String getRedeSocial() {
		return redeSocial;
	}
	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}
	public String getPublico() {
		return publico;
	}
	public void setPublico(String publico) {
		this.publico = publico;
	}
	public String getInfluencer() {
		return influencer;
	}
	public void setInfluencer(String influencer) {
		this.influencer = influencer;
	}
	public Integer getId() {
		return id;
	}
	
	public AcaoModel(Integer id, String nomeDaCampanha, String descricao, Double orcamento, String duracaoCampanha,
			String redeSocial, String publico, String influencer) {
		super();
		this.id = id;
		this.nomeDaCampanha = nomeDaCampanha;
		this.descricao = descricao;
		this.orcamento = orcamento;
		this.duracaoCampanha = duracaoCampanha;
		this.redeSocial = redeSocial;
		this.publico = publico;
		this.influencer = influencer;
	}
	public AcaoModel() {
		super();
	}
	
	
	
}
