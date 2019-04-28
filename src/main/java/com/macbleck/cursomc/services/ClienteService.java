package com.macbleck.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macbleck.cursomc.domain.Cliente;
import com.macbleck.cursomc.repositories.ClienteRepository;
import com.macbleck.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired 
	private ClienteRepository repo;
		
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " 
																   + id + ", Tipo: " 
																   + Cliente.class.getName()));
	}
}
