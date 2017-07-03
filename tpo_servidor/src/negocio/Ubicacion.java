package negocio;

import dto.UbicacionDTO;
import entities.UbicacionEntity;

public class Ubicacion {
	protected String codigo;
	protected String estado;

	public Ubicacion(UbicacionEntity ue) {
		this.estado = ue.getEstado();
		this.codigo = ue.getCodigo();
	}

	public UbicacionDTO toDTO() {
		UbicacionDTO ubiDTO = new UbicacionDTO();
		ubiDTO.setCodigo(this.codigo);
		ubiDTO.setEstado(this.estado);
		return ubiDTO;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
