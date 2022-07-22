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

import info4.desenvolvimento.exception.AcaoException;
import info4.desenvolvimento.model.AcaoModel;
import info4.desenvolvimento.service.AcaoService;


@RestController
@RequestMapping("/acao")
public class AcaoControler {

	@Autowired
	AcaoService acaoService;

	@GetMapping
	public List<AcaoModel> list(){
		return acaoService.listartudo();
	}
	@GetMapping("/{id}")
	public ResponseEntity<AcaoModel> getOne(@PathVariable Integer id) {
		return new ResponseEntity<AcaoModel>(acaoService.listarAcao(id),HttpStatus.OK);
	}
	
	@PostMapping("/CriarAcao")
	@ResponseStatus(HttpStatus.CREATED)
	public AcaoModel cadastrar(@RequestBody AcaoModel acao) throws AcaoException {
		return acaoService.criarAcao(acao);
	}
	
	
	
	@DeleteMapping("/{id}")
	public void Deletar(@PathVariable Integer id) throws AcaoException {
		acaoService.deletarAcao(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public AcaoModel put (@PathVariable Integer id, @RequestBody AcaoModel acaoModel ) throws AcaoException  {
		return acaoService.atualizarAcao(acaoModel, id);
	}
	
}
