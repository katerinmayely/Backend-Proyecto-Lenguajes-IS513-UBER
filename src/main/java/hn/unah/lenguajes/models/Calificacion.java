package hn.unah.lenguajes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="calificacion")
public class Calificacion {

	   @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="idcalificacion")
	    private int idCalificacion;
	  	
	  	@Column(name="calificaciondeservicio")
	  	private int calificacionDeServicio;
	  	
	  	@Column(name="comentario")
	  	private String comentario;
	  	
		@JsonIgnore
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="correocliente", referencedColumnName="correo")
		private Cliente cliente;
		
		@JsonIgnore
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="idconductor", referencedColumnName="idconductor")
		private Conductor conductor;
}
