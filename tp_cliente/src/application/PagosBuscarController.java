package application;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.PagoDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTablePosition;
import javafx.scene.control.TreeTableView.TreeTableViewSelectionModel;
import javafx.util.Callback;

public class PagosBuscarController implements Initializable{

    @FXML
    private Label txtFechaPago;

    @FXML
    private JFXTreeTableView<ClienteTabla> vistaTabla;

    @FXML
    private Label txtTel;

    @FXML
    private Label txtBalance;

    @FXML
    private Label txtLimitecred;

    @FXML
    private JFXTextField filtroRazonSocial;

    @FXML
    private Label lblPedido;

    @FXML
    private JFXTextField filtroFechaFactura;

    @FXML
    private Label txtCuit;

    @FXML
    private Label txtIdCliente;

    @FXML
    private JFXTreeTableView<PagoTabla> vistaTabla2;

    @FXML
    private JFXTextField filtroIdPedido;

    @FXML
    private Label txtRazonSocial;
    
    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
    	JFXTreeTableColumn<ClienteTabla, String> idCliente = new JFXTreeTableColumn<>("Nº");
    	idCliente.setPrefWidth(50);
    	idCliente.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ClienteTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ClienteTabla, String> param) {
				return param.getValue().getValue().nroCliente;
			}
		});
    	
    	JFXTreeTableColumn<ClienteTabla, String> clientName = new JFXTreeTableColumn<>("Cliente");
    	clientName.setPrefWidth(170);
    	clientName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ClienteTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ClienteTabla, String> param) {
				return param.getValue().getValue().razonSocial;
			}
		});
    	
    	JFXTreeTableColumn<ClienteTabla, String> cuitColumn = new JFXTreeTableColumn<>("CUIT");
    	cuitColumn.setPrefWidth(137);
    	cuitColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ClienteTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ClienteTabla, String> param) {
				return param.getValue().getValue().cuit;
			}
		});
    	
    	JFXTreeTableColumn<ClienteTabla, String> telefonoColumn = new JFXTreeTableColumn<>("Estado");
    	telefonoColumn.setPrefWidth(100);
    	telefonoColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ClienteTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ClienteTabla, String> param) {
				return param.getValue().getValue().telefono;
			}
		});
    	
    	JFXTreeTableColumn<ClienteTabla, String> fechaRegistroColumn = new JFXTreeTableColumn<>("Fecha de registro");
    	fechaRegistroColumn.setPrefWidth(140);
    	fechaRegistroColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ClienteTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<ClienteTabla, String> param) {
				return param.getValue().getValue().fechaRegistro;
			}
		});
    	
    	vistaTabla.setPlaceholder(new Label("No hay clientes para seleccionar"));
    	vistaTabla2.setPlaceholder(new Label("Seleccione un cliente para ver los pagos"));
    	
    	idCliente.setResizable(false);
    	clientName.setResizable(false);
    	cuitColumn.setResizable(false);
    	telefonoColumn.setResizable(false);
    	fechaRegistroColumn.setResizable(false);
    	
    	idCliente.impl_setReorderable(false);
    	clientName.impl_setReorderable(false);
    	cuitColumn.impl_setReorderable(false);
    	telefonoColumn.impl_setReorderable(false);
    	fechaRegistroColumn.impl_setReorderable(false);
    	
    	JFXTreeTableColumn<PagoTabla, String> nroPagoCol = new JFXTreeTableColumn<>("Nº");
    	nroPagoCol.setPrefWidth(190);
    	nroPagoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PagoTabla, String> param) {
				return param.getValue().getValue().idPago;
			}
		});
    	
    	JFXTreeTableColumn<PagoTabla, String> fechaPagoCol = new JFXTreeTableColumn<>("Fecha");
    	fechaPagoCol.setPrefWidth(110);
    	fechaPagoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PagoTabla, String> param) {
				return param.getValue().getValue().fecha;
			}
		});
    	
    	JFXTreeTableColumn<PagoTabla, String> montoPagoCol = new JFXTreeTableColumn<>("Monto");
    	montoPagoCol.setPrefWidth(60);
    	montoPagoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PagoTabla, String> param) {
				return param.getValue().getValue().monto;
			}
		});
    	
    	JFXTreeTableColumn<PagoTabla, String> montoAnteriorCol = new JFXTreeTableColumn<>("Anterior");
    	montoAnteriorCol.setPrefWidth(170);
    	montoAnteriorCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PagoTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<PagoTabla, String> param) {
				return param.getValue().getValue().montoAnterior;
			}
		});
    	   	
    	fechaPagoCol.setResizable(false);
    	nroPagoCol.setResizable(false);
    	montoPagoCol.setResizable(false);
    	montoAnteriorCol.setResizable(false);
    	
    	fechaPagoCol.impl_setReorderable(false);
    	nroPagoCol.impl_setReorderable(false);
    	montoPagoCol.impl_setReorderable(false);
    	montoAnteriorCol.impl_setReorderable(false);
    	
    	ObservableList<ClienteTabla> clientes = FXCollections.observableArrayList();
    	ObservableList<PagoTabla> pagosCliente = FXCollections.observableArrayList();

    	//agregar pedidos a la tabla
    	for(ClienteTabla p: buscarClientes()){
    		clientes.add(p);
    	}
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<ClienteTabla> root = new RecursiveTreeItem<ClienteTabla>(clientes, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(idCliente, clientName, cuitColumn, telefonoColumn, fechaRegistroColumn);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<PagoTabla> root2 = new RecursiveTreeItem<PagoTabla>(pagosCliente, RecursiveTreeObject::getChildren);
    	vistaTabla2.getColumns().setAll(nroPagoCol,fechaPagoCol,montoPagoCol,montoAnteriorCol);
    	vistaTabla2.setRoot(root2);
    	vistaTabla2.setShowRoot(false);
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroRazonSocial.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<ClienteTabla>>() {					
					@Override
					public boolean test(TreeItem<ClienteTabla> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().razonSocial.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroIdPedido.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<ClienteTabla>>() {					
					@Override
					public boolean test(TreeItem<ClienteTabla> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().cuit.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	filtroFechaFactura.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<ClienteTabla>>() {					
					@Override
					public boolean test(TreeItem<ClienteTabla> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().fechaRegistro.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	vistaTabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    		 @Override
     	    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
     	    		ClienteDTO seleccionado = new ClienteDTO();
 	    	        //Check whether item is selected and set value of selected item to Label
     	    		if(vistaTabla.getSelectionModel().getSelectedItem() != null) 
	    	        {
	    	           TreeTableViewSelectionModel<ClienteTabla> selectionModel = vistaTabla.getSelectionModel();
	    	           ObservableList selectedCells = selectionModel.getSelectedCells();
	    	           TreeTablePosition tablePosition = (TreeTablePosition) selectedCells.get(0);
	    	           TreeItem<ClienteTabla> selectedRow = vistaTabla.getTreeItem(tablePosition.getRow());
	    	           
	    	           seleccionado.setNumeroCliente(Integer.parseInt(selectedRow.getValue().getNroCliente().getValue()));
	    	           try {
						seleccionado = BusinessDelegate.getInstancia().buscarCliente(seleccionado);
	    	           } catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
	    	           }
	    	           
	    	           txtIdCliente.setText("ID"+Integer.toString(seleccionado.getNumeroCliente()));
	    	           txtRazonSocial.setText(seleccionado.getNombre());
	    	           txtCuit.setText(seleccionado.getCuit());
	    	           txtTel.setText(seleccionado.getTelefono());
	    	           txtBalance.setText(Float.toString(seleccionado.getCuentaCorriente().getBalanceActual()));
	    	           txtLimitecred.setText(Float.toString(seleccionado.getCuentaCorriente().getLimite()));
	    	           txtFechaPago.setText(seleccionado.getCuentaCorriente().getFecha());
	    	           
					   for(PagoTabla c : buscarPagos(seleccionado)){
						   pagosCliente.add(c);
					   }
	    	           
	    	        }
     	         }
     	     });
    }
    
    private ArrayList<PagoTabla> buscarPagos(ClienteDTO seleccionado) {
		ArrayList<PagoTabla> resultado = new ArrayList<PagoTabla>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			for(PagoDTO c : BusinessDelegate.getInstancia().buscarPagos(seleccionado)){
				resultado.add(new PagoTabla(Integer.toString(c.getIdPago()), df.format(c.getFechaPago()), Float.toString(c.getMonto()), Float.toString(c.getMontoAnterior())));
			}
			return resultado;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
		
	}

    private ArrayList<ClienteTabla> buscarClientes() {
		ArrayList<ClienteTabla> resultado = new ArrayList<ClienteTabla>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			for(ClienteDTO c : BusinessDelegate.getInstancia().listadoClientes()){
				if(!c.getEstado().equalsIgnoreCase("Pendiente")){
				resultado.add(new ClienteTabla(Integer.toString(c.getNumeroCliente()), c.getNombre(),c.getCuit(),c.getEstado(),df.format(c.getFechaRegistro())));
				}
			}
			return resultado;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	class ClienteTabla extends RecursiveTreeObject<ClienteTabla>{
    	StringProperty nroCliente;
		StringProperty razonSocial;
    	StringProperty cuit;
    	StringProperty telefono;
    	StringProperty fechaRegistro;
    
		public ClienteTabla(String nroCliente, String razonSocial, String cuit, String telefono, String fechaRegistro){
    		this.nroCliente = new SimpleStringProperty(nroCliente);
    		this.razonSocial = new SimpleStringProperty(razonSocial);
    		this.cuit = new SimpleStringProperty(cuit);
    		this.telefono = new SimpleStringProperty(telefono);
    		this.fechaRegistro = new SimpleStringProperty(fechaRegistro);
    	}
    	
    	public StringProperty getNroCliente() {
			return nroCliente;
		}

		public void setNroCliente(StringProperty nroCliente) {
			this.nroCliente = nroCliente;
		}
		
    	public String getRazonSocial(){
    		return razonSocial.get();
    	}
    	
    	public String getCuit(){
    		return cuit.get();
    	}
    	
    	public String getTelefono(){
    		return telefono.get();
    	}
    	
    	public String getFechaRegistro(){
    		return fechaRegistro.get();
    	}
    }
    
    class PagoTabla extends RecursiveTreeObject<PagoTabla>{
    	StringProperty idPago;
    	StringProperty fecha;
    	StringProperty monto;
    	StringProperty montoAnterior;
    	
    	public PagoTabla(String idPago, String fecha, String monto, String montoAnterior){
    		//Producto, Tipo Producto, Talle, Color, Cantidad
    		this.idPago = new SimpleStringProperty(idPago);
    		this.fecha = new SimpleStringProperty(fecha);	//discontinuo o en produccion
    		this.monto = new SimpleStringProperty(monto);
    		this.montoAnterior = new SimpleStringProperty(montoAnterior);
    	}

		public StringProperty getIdPago() {
			return idPago;
		}

		public StringProperty getFecha() {
			return fecha;
		}

		public StringProperty getMonto() {
			return monto;
		}

		public StringProperty getMontoAnterior() {
			return montoAnterior;
		}
    	
    	
    }
    
}
