package com.pagp.medicalweb.db.entity.receta;

import java.util.Date;

public class MedicamentoRecetaEntity {

	private int idReceta;
	private Integer idMedicamento;
	private String dosis;
	private String toma;
	private String tipo_administracion;
	private Date desde;
	private Date hasta;

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public Integer getIdMedicamento() {
		return idMedicamento;
	}

	public void setIdMedicamento(Integer idMedicamento) {
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

	public String getTipo_administracion() {
		return tipo_administracion;
	}

	public void setTipo_administracion(String tipo_administracion) {
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
