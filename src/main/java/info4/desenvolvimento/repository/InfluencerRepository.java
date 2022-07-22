package info4.desenvolvimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import info4.desenvolvimento.model.InfluencerModel;

@Repository
public interface InfluencerRepository extends JpaRepository<InfluencerModel, Integer> {

	
	List<InfluencerModel> findByNome(String nome);
	
	List<InfluencerModel> findByRedeSocial(String nome);
	
	List<InfluencerModel> findByPublicoAlvo(String Publico);
	
	List<InfluencerModel> findByIdadePublico(String Idade);
	
	List<InfluencerModel> findByAlcance(String Alcance);
	
	
	
}
