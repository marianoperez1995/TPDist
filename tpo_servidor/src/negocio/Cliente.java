package negocio;

import java.util.ArrayList;

import dto.ClienteDTO;
import dto.PedidoClienteDTO;
import entities.ClienteEntity;
import entities.PedidoClienteEntity;
import persistencia.ClienteDAO;

public class Cliente {
	private int idCliente;
	private String direccion;
	private String cuit;
	private CuentaCorriente cuentaCorriente;
	private String nombre;
	private String telefono;
	private String encargado;
	private String telEncargado;
	private String mailEncargado;
	private String generoEncargado;

	public String getTelEncargado() {
		return telEncargado;
	}

	public void setTelEncargado(String telEncargado) {
		this.telEncargado = telEncargado;
	}

	public String getMailEncargado() {
		return mailEncargado;
	}

	public void setMailEncargado(String mailEncargado) {
		this.mailEncargado = mailEncargado;
	}

	public String getGeneroEncargado() {
		return generoEncargado;
	}

	public void setGeneroEncargado(String generoEncargado) {
		this.generoEncargado = generoEncargado;
	}

	private String estado;
	private Sucursal sucursal;
	private ArrayList<PedidoCliente> pedidosCliente;

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente(ClienteEntity cliE) {

		this.idCliente = cliE.getNumeroCliente();
		this.direccion = cliE.getDireccion();
		this.cuit = cliE.getCuit();
		this.cuentaCorriente = new CuentaCorriente(cliE.getCuentaCorriente());
		this.nombre = cliE.getNombre();
		this.sucursal = new Sucursal(cliE.getSucursal());
		this.telefono = cliE.getTelefono();
		this.mailEncargado = cliE.getMailEncargado();
		this.generoEncargado = cliE.getGeneroencargado();
		this.telEncargado = cliE.getTelencargado();
		this.pedidosCliente = new ArrayList<PedidoCliente>();
		for (PedidoClienteEntity p : cliE.getPedidosCliente()) {
			this.pedidosCliente.add(new PedidoCliente(p));
		}
		this.encargado = cliE.getEncargado();
		this.estado = cliE.getEstado();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Cliente(ClienteDTO cliDTO) {
		this.idCliente = cliDTO.getNumeroCliente();
		this.direccion = cliDTO.getDireccion();
		this.cuit = cliDTO.getCuit();
		this.cuentaCorriente = new CuentaCorriente(cliDTO.getCuentaCorriente());
		this.nombre = cliDTO.getNombre();
		this.telefono = cliDTO.getTelefono();
		this.sucursal = new Sucursal(cliDTO.getSucursal());
		this.mailEncargado = cliDTO.getMailEncargado();
		this.generoEncargado = cliDTO.getGeneroEncargado();
		this.telEncargado = cliDTO.getTelEncargado();
		this.pedidosCliente = new ArrayList<PedidoCliente>();
		if (cliDTO.getPedidosCliente() != null) {
			for (PedidoClienteDTO p : cliDTO.getPedidosCliente()) {
				this.pedidosCliente.add(new PedidoCliente(p));
			}
		}
		this.encargado = cliDTO.getEncargado();
		this.estado = cliDTO.getEstado();
	}

	public Cliente() {

	}

	public void agregarPedido(PedidoCliente pedidoCliente) {
		this.pedidosCliente.add(pedidoCliente);
	}

	public boolean sosElCliente(int numero) {
		return (this.idCliente == numero);

	}

	public void modificarLimiteCredito(float limite) {
		this.cuentaCorriente.setLimite(limite);
	}

	// TODOS LOS GETTERS Y SETTERS

	public void setNumeroCliente(int numeroCliente) {
		this.idCliente = numeroCliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public CuentaCorriente getCuentaCorriente() {
		return cuentaCorriente;
	}

	public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
		this.cuentaCorriente = cuentaCorriente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public ArrayList<PedidoCliente> getPedidosCliente() {
		return pedidosCliente;
	}

	public void setPedidosCliente(ArrayList<PedidoCliente> pedidosCliente) {
		this.pedidosCliente = pedidosCliente;
	}

	public void insertar() {
		ClienteDAO.getInstancia().insert(this);

	}

	public void borrar() {
		ClienteDAO.getInstancia().eliminar(this.idCliente);

	}

	public String getEncargado() {

		return encargado;
	}

	public String getEstado() {

		return estado;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
