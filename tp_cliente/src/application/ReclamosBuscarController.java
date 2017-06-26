package application;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.CuentaCorrienteDTO;
import dto.PedidoClienteDTO;
import dto.ReclamoDTO;
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
import javafx.scene.layout.FlowPane;
import javafx.util.Callback;

public class ReclamosBuscarController implements Initializable{

    @FXML
    private JFXTreeTableView<ReclamoTabla> vistaTabla;

    @FXML
    private JFXTextField txtMailEncargado;

    @FXML
    private JFXTextField txtRazon;

    @FXML
    private JFXTextField filtroIDReclamo;

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
    private JFXTextField filtroFechaRegistro;

    @FXML
    private JFXTextField txtNombreEncargado;
    
    
    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
    	JFXTreeTableColumn<ReclamoTabla, String> idReclamo = new JFXTreeTableColumn<>("Nº");
    	idReclamo.setPrefWidth(50);
    	idReclamo.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ReclamoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ReclamoTabla, String> param) {
				return param.getValue().getValue().idReclamo;
			}
		});
    	
    	JFXTreeTableColumn<ReclamoTabla, String> idCliente = new JFXTreeTableColumn<>("Cliente");
    	idCliente.setPrefWidth(170);
    	idCliente.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ReclamoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ReclamoTabla, String> param) {
				return param.getValue().getValue().idCliente;
			}
		});
    	
    	JFXTreeTableColumn<ReclamoTabla, String> cuitColumn = new JFXTreeTableColumn<>("CUIT");
    	cuitColumn.setPrefWidth(137);
    	cuitColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ReclamoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ReclamoTabla, String> param) {
				return param.getValue().getValue().cuit;
			}
		});
    	
    	JFXTreeTableColumn<ReclamoTabla, String> fechaRegistroColumn = new JFXTreeTableColumn<>("Fecha de registro");
    	fechaRegistroColumn.setPrefWidth(140);
    	fechaRegistroColumn.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ReclamoTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<ReclamoTabla, String> param) {
				return param.getValue().getValue().fechaRegistro;
			}
		});
    	
    	idReclamo.setResizable(false);
    	idCliente.setResizable(false);
    	cuitColumn.setResizable(false);
    	fechaRegistroColumn.setResizable(false);
    	
    	idReclamo.impl_setReorderable(false);
    	idCliente.impl_setReorderable(false);
    	cuitColumn.impl_setReorderable(false);
    	fechaRegistroColumn.impl_setReorderable(false);
    	
    	ObservableList<ReclamoTabla> reclamos = FXCollections.observableArrayList();
    	
    	
    	//agregar clientes a la tabla
    	for(ReclamoTabla c: buscarReclamos()){
    		reclamos.add(c);
    	}
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<ReclamoTabla> root = new RecursiveTreeItem<ReclamoTabla>(reclamos, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(idReclamo, idCliente,cuitColumn,fechaRegistroColumn);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroIDReclamo.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<ReclamoTabla>>() {					
					@Override
					public boolean test(TreeItem<ReclamoTabla> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().idReclamo.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroCuit.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<ReclamoTabla>>() {					
					@Override
					public boolean test(TreeItem<ReclamoTabla> cliente) {
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
					vistaTabla.setPredicate(new Predicate<TreeItem<ReclamoTabla>>() {					
					@Override
					public boolean test(TreeItem<ReclamoTabla> cliente) {
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
    	    		ReclamoDTO reclamo = new ReclamoDTO();
	    	        //Check whether item is selected and set value of selected item to Label
	    	        if(vistaTabla.getSelectionModel().getSelectedItem() != null) 
	    	        {
	    	           TreeTableViewSelectionModel<ReclamoTabla> selectionModel = vistaTabla.getSelectionModel();
	    	           ObservableList selectedCells = selectionModel.getSelectedCells();
	    	           TreeTablePosition tablePosition = (TreeTablePosition) selectedCells.get(0);
	    	           TreeItem<ReclamoTabla> selectedRow = vistaTabla.getTreeItem(tablePosition.getRow());
	    	           
	    	           seleccionado.setNumeroCliente(Integer.parseInt(selectedRow.getValue().getIdReclamo().getValue()));
	    	           try {
						seleccionado = BusinessDelegate.getInstancia().buscarCliente(seleccionado);
	    	           } catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
	    	           }
	    	           
	    	           reclamo.setIdReclamo(Integer.parseInt(selectedRow.getValue().getIdReclamo().getValue()));
	    	           try {
						reclamo = BusinessDelegate.getInstancia().buscarReclamo(reclamo);
	    	           } catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
	    	           }
	    	           
	    	           txtRazon.setText(seleccionado.getNombre());
	    	           txtNombreEncargado.setText(seleccionado.getEncargado());
	    	           txtCuit.setText(seleccionado.getCuit());
	    	           txtTelefonoEncargado.setText(seleccionado.getTelEncargado());
	    	           txtTelefono.setText(seleccionado.getTelefono());
	    	           txtReclamo.setText(reclamo.getReclamo());
	    	           
	    	        }
    	         }
    	     });
    }
    
    private ArrayList<ReclamoTabla> buscarReclamos() {
		ArrayList<ReclamoTabla> resultado = new ArrayList<ReclamoTabla>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			for(ReclamoDTO c : BusinessDelegate.getInstancia().listadoReclamos())
			resultado.add(new ReclamoTabla(Integer.toString(c.getIdReclamo()), Integer.toString(c.getCliente().getNumeroCliente()),c.getCliente().getCuit(),df.format(c.getFechaReclamo())));
			return resultado;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	class ReclamoTabla extends RecursiveTreeObject<ReclamoTabla>{
    	StringProperty idReclamo;
		StringProperty idCliente;
    	StringProperty cuit;
    	StringProperty fechaRegistro;
    
		public ReclamoTabla(String idReclamo, String idCliente, String cuit, String fechaRegistro){
    		this.idReclamo = new SimpleStringProperty(idReclamo);
    		this.idCliente = new SimpleStringProperty(idCliente);
    		this.cuit = new SimpleStringProperty(cuit);
    		this.fechaRegistro = new SimpleStringProperty(fechaRegistro);
    	}
    	
    	public StringProperty getIdReclamo() {
			return idReclamo;
		}

		public void setNroCliente(StringProperty nroCliente) {
			this.idReclamo = nroCliente;
		}
		
    	public String getIdCliente(){
    		return idCliente.get();
    	}
    	
    	public String getCuit(){
    		return cuit.get();
    	}
    	    	
    	public String getFechaRegistro(){
    		return fechaRegistro.get();
    	}
    }
    
}
