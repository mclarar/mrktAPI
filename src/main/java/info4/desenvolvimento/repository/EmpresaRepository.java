package info4.desenvolvimento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import info4.desenvolvimento.model.EmpresaModel;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer> {

	
	List<EmpresaModel> findByNome(String nome);

	List<EmpresaModel> findByCnpj(String cnpj);
	List<EmpresaModel> findByRazaoSoci(String razaoSoci);
	List<EmpresaModel> findBySeguimento(String seguimento);
	List<EmpresaModel> findByProduto(String produto);
	List<EmpresaModel> findByContato(String contato);
	List<EmpresaModel> findByFocalPont(String focalPont);
	
}
