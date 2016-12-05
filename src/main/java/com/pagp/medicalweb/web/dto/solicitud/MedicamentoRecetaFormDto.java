package com.pagp.medicalweb.web.dto.solicitud;

import java.util.Date;

import com.pagp.medicalweb.web.enums.TipoAdministracionEnum;

public class MedicamentoRecetaFormDto {

	private int idReceta;
	private int idMedicamento;
	private String dosis;
	private String toma;
	private TipoAdministracionEnum tipo_administracion;
	private Date desde;
	private Date hasta;

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public int getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(int idMedicamento) {
		this.idMedicamento = idMedicamento;
	}

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	public String getToma() {
		return toma;
	}

	public void setToma(String toma) {
		this.toma = toma;
	}

	public TipoAdministracionEnum getTipo_administracion() {
		return tipo_administracion;
	}

	public void setTipo_administracion(TipoAdministracionEnum tipo_administracion) {
		this.tipo_administracion = tipo_administracion;
	}

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

}
