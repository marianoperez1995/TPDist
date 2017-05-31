package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

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
    private JFXTreeTableView<Cliente> vistaTabla;

    @FXML
    private FlowPane flowPanel;
    
    private TreeItem<Cliente> seleccionado;
    
    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
    	
    	JFXTreeTableColumn<Cliente, String> clientName = new JFXTreeTableColumn<>("Cliente");
    	clientName.setPrefWidth(170);
    	clientName.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Cliente,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Cliente, String> param) {
				return param.getValue().getValue().razonSocial;
			}
		});
    	
    	JFXTreeTableColumn<Cliente, String> cuitColumn = new JFXTreeTableColumn<>("CUIT");
    	cuitColumn.setPrefWidth(137);
    	cuitColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Cliente,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Cliente, String> param) {
				return param.getValue().getValue().cuit;
			}
		});
    	
    	JFXTreeTableColumn<Cliente, String> telefonoColumn = new JFXTreeTableColumn<>("Telefono");
    	telefonoColumn.setPrefWidth(135);
    	telefonoColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Cliente,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<Cliente, String> param) {
				return param.getValue().getValue().telefono;
			}
		});
    	
    	JFXTreeTableColumn<Cliente, String> fechaRegistroColumn = new JFXTreeTableColumn<>("Fecha de registro");
    	fechaRegistroColumn.setPrefWidth(185);
    	fechaRegistroColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Cliente,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<Cliente, String> param) {
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
    	
    	ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    	
    	//agergar clientes a la tabla
    	clientes.add(new Cliente("Natanael SRL", "2011111111X", "46326651", "10/10/2016"));
    	clientes.add(new Cliente("Nicolas SA", "2022222222X", "46225584", "05/10/2013"));
    	clientes.add(new Cliente("Luciano SRL", "2033333333X", "44551124", "07/11/2014"));
    	clientes.add(new Cliente("Franco SH", "2044444444X", "44877754", "18/05/2016"));
    	clientes.add(new Cliente("Francisco SRL", "2055555555X", "64421554", "25/04/2016"));
    	clientes.add(new Cliente("Ramiro SA", "2066666666X", "49987753", "23/09/2014"));
    	clientes.add(new Cliente("Maturano SRL", "2077777777X", "45557752", "30/10/2013"));
    	clientes.add(new Cliente("Matias Leonel SA", "2088888888X", "43321556", "01/08/2014"));
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<Cliente> root = new RecursiveTreeItem<Cliente>(clientes, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(clientName,cuitColumn,telefonoColumn,fechaRegistroColumn);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroRazonSocial.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<Cliente>>() {					
					@Override
					public boolean test(TreeItem<Cliente> cliente) {
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
					vistaTabla.setPredicate(new Predicate<TreeItem<Cliente>>() {					
					@Override
					public boolean test(TreeItem<Cliente> cliente) {
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
					vistaTabla.setPredicate(new Predicate<TreeItem<Cliente>>() {					
					@Override
					public boolean test(TreeItem<Cliente> cliente) {
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
	    	           TreeTableViewSelectionModel<Cliente> selectionModel = vistaTabla.getSelectionModel();
	    	           ObservableList selectedCells = selectionModel.getSelectedCells();
	    	           TreeTablePosition tablePosition = (TreeTablePosition) selectedCells.get(0);
	    	           TreeItem<Cliente> selectedRow = vistaTabla.getTreeItem(tablePosition.getRow());
	    	           
	    	           System.out.println(selectedRow.getValue().getRazonSocial() + " - " + selectedRow.getValue().getCuit() + " - " + selectedRow.getValue().getTelefono() + " - " + selectedRow.getValue().getFechaRegistro());	    	           
	    	           //cargar
	    	        }
    	         }
    	     });
    }
    
    class Cliente extends RecursiveTreeObject<Cliente>{
    	StringProperty razonSocial;
    	StringProperty cuit;
    	StringProperty telefono;
    	StringProperty fechaRegistro;
    	
    	public Cliente(String razonSocial, String cuit, String telefono, String fechaRegistro){
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
