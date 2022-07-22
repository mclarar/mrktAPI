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

import info4.desenvolvimento.exception.EmpresaExceptio;
import info4.desenvolvimento.exception.InfluencerException;
import info4.desenvolvimento.model.EmpresaModel;
import info4.desenvolvimento.model.InfluencerModel;
import info4.desenvolvimento.service.EmpresaService;



@CrossOrigin("*")
@RestController
@RequestMapping("/empresa")
public class EmpresaControler {

	@Autowired
	EmpresaService empresaService; 

	@GetMapping("/listarEmpresa")
	public List<EmpresaModel>list() {
		return empresaService.listartudo();
	}	
	@GetMapping("/{id}")
	public ResponseEntity<EmpresaModel> getOne(@PathVariable Integer id) {
		return new ResponseEntity<EmpresaModel>(empresaService.listarEmpresa(id),HttpStatus.OK); 
	}
	
	@PostMapping("/criarEmpresa")
	@ResponseStatus(HttpStatus.CREATED)
	public EmpresaModel cadastrar(@RequestBody EmpresaModel empresa) throws EmpresaExceptio {
		return empresaService.criarEmpresa(empresa);
	}
	
	@DeleteMapping("/{id}")
	public void DeletarUsuario(@PathVariable Integer id) throws EmpresaExceptio {
		empresaService.deletarEmpresa(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public EmpresaModel put (@PathVariable Integer id, @RequestBody EmpresaModel empresaModel ) throws  EmpresaExceptio{
		return empresaService.atualizarEmpresa(empresaModel, id);
	}
}
