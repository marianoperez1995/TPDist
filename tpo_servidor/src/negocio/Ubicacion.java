package negocio;

public abstract class Ubicacion {
	protected int idUbicacion;
	protected String codigo;
	protected boolean ocupado;

	public boolean estaOcupado() {
		return ocupado;

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void setOcupado(){
		this.ocupado = true;
	}

}
