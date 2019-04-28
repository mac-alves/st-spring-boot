package com.macbleck.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macbleck.cursomc.domain.Pedido;
import com.macbleck.cursomc.repositories.PedidoRepository;
import com.macbleck.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired 
	private PedidoRepository repo;
		
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " 
																   + id + ", Tipo: " 
																   + Pedido.class.getName()));
	}
}
