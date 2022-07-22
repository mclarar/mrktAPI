package info4.desenvolvimento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info4.desenvolvimento.exception.InfluencerException;
import info4.desenvolvimento.exception.InfluencerException;
import info4.desenvolvimento.model.InfluencerModel;
import info4.desenvolvimento.repository.InfluencerRepository;

@Service
public class InfluencerService {

	@Autowired
	InfluencerRepository influencerRepository;

	// get
	public List<InfluencerModel> listartudo() {
		return influencerRepository.findAll();
	}

	// get id
	public InfluencerModel listarInfluencer(Integer id) {
		Optional<InfluencerModel> optional = influencerRepository.findById(id);
		return optional.get();
	}

	// post
	public InfluencerModel criarInfluencer(InfluencerModel influencerModel) throws InfluencerException {
		//verificarInfluencer(influencerModel);
		return influencerRepository.save(influencerModel);
	}

	// put
	public InfluencerModel atualizarInfluencer(InfluencerModel influencerModel, Integer id) throws InfluencerException {
		Optional<InfluencerModel> optional = influencerRepository.findById(id);
		if (optional.isEmpty()) {
			throw new InfluencerException("Influencer não encontrado");
		}

		InfluencerModel oldInfluencer = optional.get();
		if (influencerModel.getNome() != null && !influencerModel.getNome().equals("")) {
			oldInfluencer.setNome(influencerModel.getNome());
		}
		if (influencerModel.getAlcance() != null && !influencerModel.getAlcance().equals("")) {
			oldInfluencer.setAlcance(influencerModel.getAlcance());
		}
		if (influencerModel.getCampanhaAnterior() != null && !influencerModel.getCampanhaAnterior().equals("")) {
			oldInfluencer.setCampanhaAnterior(influencerModel.getCampanhaAnterior());
		}
		if (influencerModel.getContato() != null && !influencerModel.getContato().equals("")) {
			oldInfluencer.setContato(influencerModel.getContato());
		}
		if (influencerModel.getIdadePublico() != null && !influencerModel.getIdadePublico().equals("")) {
			oldInfluencer.setIdadePublico(influencerModel.getIdadePublico());
		}
		if (influencerModel.getPublicoAlvo() != null && !influencerModel.getPublicoAlvo().equals("")) {
			oldInfluencer.setPublicoAlvo(influencerModel.getPublicoAlvo());
		}
		if (influencerModel.getRedeSocial() != null && !influencerModel.getRedeSocial().equals("")) {
			oldInfluencer.setRedeSocial(influencerModel.getRedeSocial());
		}
		if (influencerModel.getSeguimento() != null && !influencerModel.getSeguimento().equals("")) {
			oldInfluencer.setSeguimento(influencerModel.getSeguimento());
		}

		return influencerRepository.save(oldInfluencer);
	}

	// delete
	public void deletarInfluencer(Integer id) throws InfluencerException {
		Optional<InfluencerModel> optional = influencerRepository.findById(id);
		if (optional.isEmpty()) {
			throw new InfluencerException("Influencer não existe");
		}
		influencerRepository.deleteById(id);
	}

	public void verificarInfluencer(InfluencerModel influencerModel) throws InfluencerException {
		Optional<InfluencerModel> optional = influencerRepository.findById(influencerModel.getId());
		if (optional.isPresent()) {
			throw new InfluencerException("Influencer já existe");
		}

	}
}