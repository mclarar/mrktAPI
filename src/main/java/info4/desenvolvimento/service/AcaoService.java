package info4.desenvolvimento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info4.desenvolvimento.exception.AcaoException;
import info4.desenvolvimento.model.AcaoModel;
import info4.desenvolvimento.repository.AcaoRepository;

@Service
public class AcaoService {

	@Autowired
	AcaoRepository acaoRepository;

	// get
	public List<AcaoModel> listartudo() {
		return acaoRepository.findAll();
	}

	// get id
	public AcaoModel listarAcao(Integer id) {
		Optional<AcaoModel> optional = acaoRepository.findById(id);
		return null;
	}

	// post
	public AcaoModel criarAcao(AcaoModel acaoModel) throws AcaoException {
	//	verificarAcao(acaoModel);
		return acaoRepository.save(acaoModel);
	}
	// put
	public AcaoModel atualizarAcao(AcaoModel acaoModel, Integer id) throws AcaoException {
		Optional<AcaoModel> optional = acaoRepository.findById(id);
		if (optional.isEmpty()) {
			throw new AcaoException("Ação não encontrada");
		}
		AcaoModel oldAcao = optional.get();
		if (acaoModel.getNomeDaCampanha() != null && !acaoModel.getNomeDaCampanha().equals("")) {
			oldAcao.setNomeDaCampanha(acaoModel.getNomeDaCampanha());
		}
		if (acaoModel.getDescricao() != null && !acaoModel.getDescricao().equals("")) {
			oldAcao.setDescricao(acaoModel.getDescricao());
		}
		if (acaoModel.getDuracaoCampanha() != null && !acaoModel.getDuracaoCampanha().equals("")) {
			oldAcao.setDuracaoCampanha(acaoModel.getDuracaoCampanha());
		}
		if (acaoModel.getInfluencer() != null && !acaoModel.getInfluencer().equals("")) {
			oldAcao.setInfluencer(acaoModel.getInfluencer());
		}
		if (acaoModel.getOrcamento() != null) {
			oldAcao.setOrcamento(acaoModel.getOrcamento());
		}
		if (acaoModel.getPublico() != null && !acaoModel.getPublico().equals("")) {
			oldAcao.setPublico(acaoModel.getPublico());
		}
		if (acaoModel.getRedeSocial() != null && !acaoModel.getRedeSocial().equals("")) {
			oldAcao.setRedeSocial(acaoModel.getRedeSocial());
		}
		
		
		return acaoRepository.save(oldAcao);
	}

	// delete
	public void deletarAcao(Integer id) throws AcaoException {
		Optional<AcaoModel> optional = acaoRepository.findById(id);
		if (optional.isEmpty()) {
			throw new AcaoException("Ação não existe");
		}
		acaoRepository.deleteById(id);
	}

	public void verificarAcao(AcaoModel acaoModel) throws AcaoException {
		Optional<AcaoModel> optional = acaoRepository.findById(acaoModel.getId());
		if (optional.isPresent()) {
			throw new AcaoException("Ação já existe");
		}
	}
}

