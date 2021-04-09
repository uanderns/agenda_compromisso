package br.com.cotiinformatica.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cotiinformatica.entities.Compromisso;
import br.com.cotiinformatica.interfaces.ICompromissoRepository;

@Service //classe de servi�o do spring
@Transactional //permiss�o para transacionar base de dados
public class CompromissoService {
	
	@Autowired //inje��o de depend�ncia
	private ICompromissoRepository compromissoRepository;
	

	public void createOrUpdate(Compromisso compromisso) throws Exception{
		compromissoRepository.save(compromisso);
	}
	
	public void delete(Compromisso comprimisso) throws Exception{
		compromissoRepository.delete(comprimisso);
	}
	
	public List<Compromisso> getAll() throws Exception{
		return (List<Compromisso>) compromissoRepository.findAll();
	}
	
	public Compromisso get(Integer id) throws Exception{
		return compromissoRepository.findById(id).get();
	}
	
	public List<Compromisso> get(Date dataMin, Date dataMax, Integer idUsuario) throws Exception {
		return compromissoRepository.find(dataMin, dataMax, idUsuario);
	}

}
