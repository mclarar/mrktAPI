package info4.desenvolvimento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info4.desenvolvimento.exception.EmpresaExceptio;
import info4.desenvolvimento.model.EmpresaModel;
import info4.desenvolvimento.repository.EmpresaRepository;

@Service
public class EmpresaService {
	@Autowired
	EmpresaRepository empresaRepository;

	// get
	public List<EmpresaModel> listartudo() {
		return empresaRepository.findAll();
	}

	// get id
	public EmpresaModel listarEmpresa(Integer id) {
		Optional<EmpresaModel> optional = empresaRepository.findById(id);
		return null;
	}

	// post
	public EmpresaModel criarEmpresa(EmpresaModel empresaModel) throws EmpresaExceptio {
	//	verificarEmpresa(empresaModel);
		return empresaRepository.save(empresaModel);
	}
	// put
	public EmpresaModel atualizarEmpresa(EmpresaModel empresaModel, Integer id) throws EmpresaExceptio {
		Optional<EmpresaModel> optional = empresaRepository.findById(id);
		if (optional.isEmpty()) {
			throw new EmpresaExceptio("Empresa não encontrada");
		}
		EmpresaModel oldEmpresa = optional.get();
		if (empresaModel.getCnpj() != null && !empresaModel.getCnpj().equals("")) {
			oldEmpresa.setCnpj(empresaModel.getCnpj());
		}

		if (empresaModel.getNome() != null && !empresaModel.getNome().equals("")) {
			oldEmpresa.setNome(empresaModel.getNome());
		}
		if (empresaModel.getContato() != null && !empresaModel.getContato().equals("")) {
			oldEmpresa.setContato(empresaModel.getContato());
		}
		if (empresaModel.getFocalPont() != null && !empresaModel.getFocalPont().equals("")) {
			oldEmpresa.setFocalPont(empresaModel.getFocalPont());
		}
		if (empresaModel.getProduto() != null && !empresaModel.getProduto().equals("")) {
			oldEmpresa.setProduto(empresaModel.getProduto());
		}
		if (empresaModel.getRazaoSoci() != null && !empresaModel.getRazaoSoci().equals("")) {
			oldEmpresa.setRazaoSoci(empresaModel.getRazaoSoci());
		}
		if (empresaModel.getSeguimento() != null && !empresaModel.getSeguimento().equals("")) {
			oldEmpresa.setSeguimento(empresaModel.getSeguimento());
		}
		
		return empresaRepository.save(oldEmpresa);
	}

	// delete
	public void deletarEmpresa(Integer id) throws EmpresaExceptio {
		Optional<EmpresaModel> optional = empresaRepository.findById(id);
		if (optional.isEmpty()) {
			throw new EmpresaExceptio("Empresa não existe");
		}
		empresaRepository.deleteById(id);
	}

	public void verificarEmpresa(EmpresaModel empresaModel) throws EmpresaExceptio {
		Optional<EmpresaModel> optional = empresaRepository.findById(empresaModel.getId());
		if (optional.isPresent()) {
			throw new EmpresaExceptio("Empresa já existe");
		}
	}
}
