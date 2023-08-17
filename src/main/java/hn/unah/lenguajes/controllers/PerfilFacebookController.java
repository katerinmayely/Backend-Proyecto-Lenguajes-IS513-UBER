package hn.unah.lenguajes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.lenguajes.dto.ClientePerfil;
import hn.unah.lenguajes.services.impl.PerfilFacebookServicesImpl;

@RestController
@RequestMapping("/perfiles")
public class PerfilFacebookController {
	
	@Autowired
	private PerfilFacebookServicesImpl impl;
	
	@PostMapping("/asociar")
	public boolean asociarPerfilConCliente(@RequestBody ClientePerfil datos){ 
		return impl.asociarPerfilConCliente(datos);
	}
	
}
