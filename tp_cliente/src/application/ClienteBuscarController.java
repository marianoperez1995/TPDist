package application;

import java.awt.List;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.TreeTablePosition;
import javafx.scene.control.TreeTableView.TreeTableViewSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;

public class ClienteBuscarController implements Initializable{
	//private ArrayList<ClienteView> clientes;
	
    @FXML
    private JFXComboBox<String> listGenero;

    @FXML
    private JFXTextField txtDireccion;

    @FXML
    private JFXTextField txtPiso;

    @FXML
    private JFXTextField txtCondicPago;

    @FXML
    private JFXTextField txtNumero;

    @FXML
    private JFXTextField txtRazon;

    @FXML
    private JFXTextField txtNombreE;

    @FXML
    private JFXTextField filtroRazonSocial;

    @FXML
    private JFXTextField filtroCuit;

    @FXML
    private JFXButton btnEditar;

    @FXML
    private JFXButton btnGuardar;

    @FXML
    private JFXTextField txtCuit;

    @FXML
    private JFXButton btnEliminar;

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
    private Label lblCantPedidos;

    @FXML
    private Label lblIdCliente;

    @FXML
    private JFXTreeTableView<ClienteTabla> vistaTabla;

    @FXML
    private FlowPane flowPanel;
    
    private TreeItem<ClienteTabla> seleccionado;
    
    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){    	
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
    	
    	JFXTreeTableColumn<ClienteTabla, String> telefonoColumn = new JFXTreeTableColumn<>("Telefono");
    	telefonoColumn.setPrefWidth(135);
    	telefonoColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ClienteTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ClienteTabla, String> param) {
				return param.getValue().getValue().telefono;
			}
		});
    	
    	JFXTreeTableColumn<ClienteTabla, String> fechaRegistroColumn = new JFXTreeTableColumn<>("Fecha de registro");
    	fechaRegistroColumn.setPrefWidth(185);
    	fechaRegistroColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ClienteTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<ClienteTabla, String> param) {
				return param.getValue().getValue().fechaRegistro;
			}
		});
    	
    	
    	clientName.setResizable(false);
    	cuitColumn.setResizable(false);
    	telefonoColumn.setResizable(false);
    	fechaRegistroColumn.setResizable(false);
    	
    	clientName.impl_setReorderable(false);
    	cuitColumn.impl_setReorderable(false);
    	telefonoColumn.impl_setReorderable(false);
    	fechaRegistroColumn.impl_setReorderable(false);
    	
    	ObservableList<ClienteTabla> clientes = FXCollections.observableArrayList();
    	
    	
    	//agregar clientes a la tabla
    	for(ClienteTabla c: buscarClientes()){
    		clientes.add(c);
    	}
    	/*clientes.add(new ClienteTabla("Natanael SRL", "2011111111X", "46326651", "10/10/2016"));
    	clientes.add(new ClienteTabla("Nicolas SA", "2022222222X", "46225584", "05/10/2013"));
    	clientes.add(new ClienteTabla("Luciano SRL", "2033333333X", "44551124", "07/11/2014"));
    	clientes.add(new ClienteTabla("Franco SH", "2044444444X", "44877754", "18/05/2016"));
    	clientes.add(new ClienteTabla("Francisco SRL", "2055555555X", "64421554", "25/04/2016"));
    	clientes.add(new ClienteTabla("Ramiro SA", "2066666666X", "49987753", "23/09/2014"));
    	clientes.add(new ClienteTabla("Maturano SRL", "2077777777X", "45557752", "30/10/2013"));
    	clientes.add(new ClienteTabla("Matias Leonel SA", "2088888888X", "43321556", "01/08/2014"));*/
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<ClienteTabla> root = new RecursiveTreeItem<ClienteTabla>(clientes, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(clientName,cuitColumn,telefonoColumn,fechaRegistroColumn);
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
    	
    	/*vistaTabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    	    @Override
    	    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
	    	        //Check whether item is selected and set value of selected item to Label
	    	        if(vistaTabla.getSelectionModel().getSelectedItem() != null) 
	    	        {
	    	           TreeTableViewSelectionModel<Cliente> selectionModel = vistaTabla.getSelectionModel();
	    	           ObservableList selectedCells = selectionModel.getSelectedCells();
	    	           TreeTablePosition tablePosition = (TreeTablePosition) selectedCells.get(0);
	    	           Object val = tablePosition.getTableColumn().getCellData(newValue);
	    	           System.out.println("Selected Value: " + val);
	    	         }
    	         }
    	     });*/
    	
    	vistaTabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    	    @Override
    	    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
	    	        //Check whether item is selected and set value of selected item to Label
	    	        if(vistaTabla.getSelectionModel().getSelectedItem() != null) 
	    	        {
	    	           TreeTableViewSelectionModel<ClienteTabla> selectionModel = vistaTabla.getSelectionModel();
	    	           ObservableList selectedCells = selectionModel.getSelectedCells();
	    	           TreeTablePosition tablePosition = (TreeTablePosition) selectedCells.get(0);
	    	           TreeItem<ClienteTabla> selectedRow = vistaTabla.getTreeItem(tablePosition.getRow());
	    	           
	    	           System.out.println(selectedRow.getValue().getRazonSocial() + " - " + selectedRow.getValue().getCuit() + " - " + selectedRow.getValue().getTelefono() + " - " + selectedRow.getValue().getFechaRegistro());	    	           
	    	           //cargar
	    	        }
    	         }
    	     });
    }
    
    private ArrayList<ClienteTabla> buscarClientes() {
		ArrayList<ClienteTabla> resultado = new ArrayList<ClienteTabla>();
		
		try {
			for(ClienteDTO c : BusinessDelegate.getInstancia().listadoClientes())
			resultado.add(new ClienteTabla(c.getNombre(),c.getCuit(),c.getTelefono(),c.getFechaRegistro()));
			return resultado;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	class ClienteTabla extends RecursiveTreeObject<ClienteTabla>{
    	StringProperty razonSocial;
    	StringProperty cuit;
    	StringProperty telefono;
    	StringProperty fechaRegistro;
    	
    	public ClienteTabla(String razonSocial, String cuit, String telefono, String fechaRegistro){
    		this.razonSocial = new SimpleStringProperty(razonSocial);
    		this.cuit = new SimpleStringProperty(cuit);
    		this.telefono = new SimpleStringProperty(telefono);
    		this.fechaRegistro = new SimpleStringProperty(fechaRegistro);
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
