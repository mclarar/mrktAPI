package info4.desenvolvimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import info4.desenvolvimento.model.AcaoModel;

public interface AcaoRepository extends JpaRepository<AcaoModel, Integer> {

	
	List<AcaoModel>findByNomeDaCampanha(String nomeDaCampanha);

	List<AcaoModel>findByOrcamento(Double orcamento);
	List<AcaoModel>findByRedeSocial(String redeSocial);
	List<AcaoModel>findByPublico(String publico);
}
