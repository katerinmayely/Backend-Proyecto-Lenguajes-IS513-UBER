package hn.unah.lenguajes.services.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnore;

import hn.unah.lenguajes.dto.NuevoConductor;
import hn.unah.lenguajes.models.Automovil;
import hn.unah.lenguajes.models.Calificacion;
import hn.unah.lenguajes.models.Conductor;
import hn.unah.lenguajes.models.ViajeOrdenServicio;
import hn.unah.lenguajes.repositories.ConductoresRepository;
import hn.unah.lenguajes.services.ConductorServices;

@Service
public class ConductoresServicesImpl implements ConductorServices{
	
	@Autowired
	private ConductoresRepository repo;
	
	@Override
	public List<Conductor> obtenerConductoreses() {
		return (List<Conductor>) repo.findAll();
		
	}

	@Override
	public Conductor buscarConductoresPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public boolean contratarConductor(NuevoConductor infoConductor) {

		if(infoConductor.getConDni() == 1 && infoConductor.getLicenciaValida() == 1 &&
				infoConductor.getPermisoCirculacion() == 1 && infoConductor.getTelefonoValido() == 1 && infoConductor.getEdad() >= 23) {
			
			Date fechaIngreso = new Date();
			
			Conductor nvoConductor = new Conductor();
			nvoConductor.setNombre(infoConductor.getNombre());
			nvoConductor.setApellido(infoConductor.getApellido());
			nvoConductor.setTelefono(infoConductor.getCelular());
			nvoConductor.setCorreo(infoConductor.getCorreo());
			nvoConductor.setFecha_ingreso(fechaIngreso);
			repo.save(nvoConductor);
			
			return true;
		}
		
		
		return false;
	}

	@Override
	public Conductor eliminarConductores(int id) {
		repo.deleteById(id);
		return null;
	}

	@Override
	public Conductor actualizarConductores(int id, Conductor conductor) {
		Conductor nvoConductor=repo.findById(id).get();
	
		nvoConductor.setFecha_ingreso(conductor.getFecha_ingreso());
		nvoConductor.setCalificacion(conductor.getCalificacion());
		repo.deleteById(id);
		repo.save(nvoConductor);
		return conductor;}
		
}
