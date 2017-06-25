package application;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTablePosition;
import javafx.scene.control.TreeTableView.TreeTableViewSelectionModel;
import javafx.util.Callback;

public class ClientesPendientesController implements Initializable{

    @FXML
    private JFXTreeTableView<ClienteTabla> vistaTabla;

    @FXML
    private JFXTextField txtDireccion;

    @FXML
    private Label lblIdCC;
    @FXML
    private JFXTextField txtCondicPago;

    @FXML
    private JFXTextField txtRazon;

    @FXML
    private JFXTextField txtNombreE;

    @FXML
    private JFXTextField filtroRazonSocial;

    @FXML
    private JFXTextField filtroCuit;

    @FXML
    private JFXTextField txtGenero;

    @FXML
    private JFXButton btnGuardar;

    @FXML
    private JFXTextField txtCuit;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private JFXTextField filtroFechaRegistro;

    @FXML
    private JFXTextField txtTelE;

    @FXML
    private JFXTextField txtMail;

    @FXML
    private JFXTextField txtLimitePrecio;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private Label lblIdCliente;
        
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
    	
    	ObservableList<ClienteTabla> clientes = FXCollections.observableArrayList();
    	
    	
    	//agregar clientes a la tabla
    	for(ClienteTabla c: buscarClientes()){
    		clientes.add(c);
    	}
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<ClienteTabla> root = new RecursiveTreeItem<ClienteTabla>(clientes, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(idCliente, clientName,cuitColumn,telefonoColumn,fechaRegistroColumn);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
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
    	filtroCuit.textProperty().addListener(new ChangeListener<String>() {
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
    	
    	filtroFechaRegistro.textProperty().addListener(new ChangeListener<String>() {
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
	    	           
	    	           //lblIdCC.setText("ID# " + Integer.toString(seleccionado.getCuentaCorriente().getIdCuentaCorriente()));
	    	           lblIdCliente.setText("#"+Integer.toString(seleccionado.getNumeroCliente()));
	    	           txtRazon.setText(seleccionado.getNombre());
	    	           txtCuit.setText(seleccionado.getCuit());
	    	           txtTelefono.setText(seleccionado.getTelefono());
	    	           txtDireccion.setText(seleccionado.getDireccion());
	    	           txtNombreE.setText(seleccionado.getEncargado());
	    	           txtTelE.setText(seleccionado.getTelEncargado());
	    	           txtMail.setText(seleccionado.getMailEncargado());
	    	           txtGenero.setText(seleccionado.getGeneroEncargado());
	    	           txtLimitePrecio.setText(Float.toString(seleccionado.getCuentaCorriente().getLimite()));
	    	           txtCondicPago.setText(seleccionado.getCuentaCorriente().getCondiciones());
	    	           
	    	       		btnCancelar.setDisable(false);
	    	       		btnGuardar.setDisable(false);
	    	        }
    	         }
    	     });
    }

    @FXML
    void rechazarCliente(ActionEvent event) {
    	ClienteDTO nuevo = new ClienteDTO();
    	
    	String idcl = lblIdCliente.getText();
    	idcl = idcl.substring(1, idcl.length());
    	
    	nuevo.setNumeroCliente(Integer.parseInt(idcl));
    	try {
			nuevo = BusinessDelegate.getInstancia().buscarCliente(nuevo);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 
    	try {
			BusinessDelegate.getInstancia().rechazarCliente(nuevo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	btnCancelar.setDisable(true);
    	btnGuardar.setDisable(true);
    }
    
    @FXML
    void altaCliente(ActionEvent event) {
    	ClienteDTO nuevo = new ClienteDTO();
    	
    	String idcl = lblIdCliente.getText();
    	idcl = idcl.substring(1, idcl.length());
    	
    	nuevo.setNumeroCliente(Integer.parseInt(idcl));
    	try {
			nuevo = BusinessDelegate.getInstancia().buscarCliente(nuevo);
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 
    	try {
			BusinessDelegate.getInstancia().altaCliente(nuevo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	btnCancelar.setDisable(true);
    	btnGuardar.setDisable(true);
    }
    
    private ArrayList<ClienteTabla> buscarClientes() {
		ArrayList<ClienteTabla> resultado = new ArrayList<ClienteTabla>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			for(ClienteDTO c : BusinessDelegate.getInstancia().listadoClientes())
			resultado.add(new ClienteTabla(Integer.toString(c.getNumeroCliente()), c.getNombre(),c.getCuit(),c.getEstado(),df.format(c.getFechaRegistro())));
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
    
}
