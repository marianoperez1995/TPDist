package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
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

public class ReclamosBuscarController implements Initializable{

    @FXML
    private JFXTreeTableView<Cliente> vistaTabla;

    @FXML
    private JFXTextField txtMailEncargado;

    @FXML
    private JFXTextField txtRazon;

    @FXML
    private JFXTextField filtroRazonSocial;

    @FXML
    private JFXTextField filtroCuit;

    @FXML
    private JFXTextField txtTelefonoEncargado;

    @FXML
    private JFXTextField txtCuit;

    @FXML
    private JFXTextArea txtReclamo;

    @FXML
    private JFXTextField txtTelefono;

    @FXML
    private JFXTextField filtroIdReclamo;

    @FXML
    private JFXTextField txtNombreEncargado;
    
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
    	
    	JFXTreeTableColumn<Cliente, String> idReclamoCol = new JFXTreeTableColumn<>("ID Reclamo");
    	idReclamoCol.setPrefWidth(130);
    	idReclamoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<Cliente,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<Cliente, String> param) {
				return param.getValue().getValue().idReclamo;
			}
		});
    	
    	
    	clientName.setResizable(false);
    	cuitColumn.setResizable(false);
    	telefonoColumn.setResizable(false);
    	idReclamoCol.setResizable(false);
    	
    	clientName.impl_setReorderable(false);
    	cuitColumn.impl_setReorderable(false);
    	telefonoColumn.impl_setReorderable(false);
    	idReclamoCol.impl_setReorderable(false);
    	
    	ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    	
    	//agergar clientes a la tabla
    	clientes.add(new Cliente("Natanael SRL", "2011111111X", "46326651", "111"));
    	clientes.add(new Cliente("Nicolas SA", "2022222222X", "46225584", "123"));
    	clientes.add(new Cliente("Luciano SRL", "2033333333X", "44551124", "1234"));
    	clientes.add(new Cliente("Franco SH", "2044444444X", "44877754", "231"));
    	clientes.add(new Cliente("Francisco SRL", "2055555555X", "64421554", "345"));
    	clientes.add(new Cliente("Ramiro SA", "2066666666X", "49987753", "765"));
    	clientes.add(new Cliente("Maturano SRL", "2077777777X", "45557752", "3234"));
    	clientes.add(new Cliente("Matias Leonel SA", "2088888888X", "43321556", "1245"));
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<Cliente> root = new RecursiveTreeItem<Cliente>(clientes, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(idReclamoCol,clientName,cuitColumn,telefonoColumn);
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
    	
    	filtroIdReclamo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<Cliente>>() {					
					@Override
					public boolean test(TreeItem<Cliente> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().idReclamo.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
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
	    	           
	    	           System.out.println(selectedRow.getValue().getRazonSocial() + " - " + selectedRow.getValue().getCuit() + " - " + selectedRow.getValue().getTelefono() + " - " + selectedRow.getValue().getIdReclamo());	    	           
	    	           //cargar
	    	        }
    	         }
    	     });
    }
    
    class Cliente extends RecursiveTreeObject<Cliente>{
    	StringProperty razonSocial;
    	StringProperty cuit;
    	StringProperty telefono;
    	StringProperty idReclamo;
    	
    	public Cliente(String razonSocial, String cuit, String telefono, String fechaRegistro){
    		this.razonSocial = new SimpleStringProperty(razonSocial);
    		this.cuit = new SimpleStringProperty(cuit);
    		this.telefono = new SimpleStringProperty(telefono);
    		this.idReclamo = new SimpleStringProperty(fechaRegistro);
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
    	
    	public String getIdReclamo(){
    		return idReclamo.get();
    	}
    }
    
}
