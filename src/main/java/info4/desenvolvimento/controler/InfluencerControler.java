package info4.desenvolvimento.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import info4.desenvolvimento.exception.InfluencerException;
import info4.desenvolvimento.model.InfluencerModel;
import info4.desenvolvimento.service.InfluencerService;


@RestController
@RequestMapping("/influencer")
public class InfluencerControler {

	@Autowired
	InfluencerService influencerService;

	@GetMapping
	public List<InfluencerModel> list() {
		return influencerService.listartudo();
	}

	@GetMapping("/{id}")
	public ResponseEntity<InfluencerModel> getOne(@PathVariable Integer id) {
		return new ResponseEntity<InfluencerModel>(influencerService.listarInfluencer(id),HttpStatus.OK);
	}


	@PostMapping("/criar")
	@ResponseStatus(HttpStatus.CREATED)
	public InfluencerModel cadastrar(@RequestBody InfluencerModel influencer) throws InfluencerException {
		return influencerService.criarInfluencer(influencer);
	}

	@DeleteMapping("/{id}")
	public void DeletarUsuario(@PathVariable Integer id) throws InfluencerException {
		influencerService.deletarInfluencer(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public InfluencerModel put (@PathVariable Integer id, @RequestBody InfluencerModel influencerModel ) throws InfluencerException{
		return influencerService.atualizarInfluencer(influencerModel , id);
	}
	
	
}
