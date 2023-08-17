package hn.unah.lenguajes.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.lenguajes.dto.ClientePerfil;
import hn.unah.lenguajes.models.Cliente;
import hn.unah.lenguajes.models.PerfilFacebook;
import hn.unah.lenguajes.repositories.ClientesRepository;
import hn.unah.lenguajes.repositories.PerfilFacebookRepository;
import hn.unah.lenguajes.services.PerfilFacebookServices;

@Service
public class PerfilFacebookServicesImpl implements PerfilFacebookServices{
	
	@Autowired
	private PerfilFacebookRepository repoP;
	
	@Autowired
	private ClientesRepository repoC;

	@Override
	public boolean asociarPerfilConCliente(ClientePerfil datos) {
		
		String correo = datos.getCorreoCliente();
		String contrasenia = datos.getContraseniaPerfil();
		String usuario = datos.getUsuarioPerfil();
		
		if(repoC.existsById(correo)) {
			
			Cliente cliente = repoC.findById(correo).orElse(null);
			List<PerfilFacebook> perfilesExistentes = (List<PerfilFacebook>) repoP.findAll();
			
			for(PerfilFacebook perfil: perfilesExistentes) {
				if(perfil.getUsuario().equals(usuario)) {
					PerfilFacebook perfilAct = repoP.findById(usuario).orElse(null);
					
					if(perfilAct.getContrasenia().equals(contrasenia)) {
						
						for(PerfilFacebook perfilCliente: cliente.getPerfiles()) {
							if(perfilCliente.getUsuario().equals(perfilAct.getUsuario())) {
								return false;
							}
						}
						
						perfilAct.setCliente(cliente);
						repoP.save(perfilAct);
						
						return true;
					}
				}
			}
		}
		
		return true;
	}

}
