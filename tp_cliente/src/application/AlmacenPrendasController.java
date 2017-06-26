package application;

import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

import application.ClienteBuscarController.ClienteTabla;
import application.OrdenProduccionFabricarController.ItemPedTabla;
import businessDelegate.BusinessDelegate;
import dto.BultoDTO;
import dto.ClienteDTO;
import dto.ItemPedidoClienteDTO;
import dto.PedidoClienteDTO;
import dto.PrendaDTO;
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

public class AlmacenPrendasController implements Initializable{

	@FXML
    private Label lblEstado;

	@FXML
    private JFXButton btnLimpiar;
	
    @FXML
    private JFXTreeTableView<PrendaTabla> vistaTabla;

    @FXML
    private JFXTextField filtroIdPrenda;

    @FXML
    private Label labelStock;

    @FXML
    private Label txtStock;

    @FXML
    private JFXTextField filtroDescripcion;

    @FXML
    private Label txtPrecio;

    @FXML
    private Label lblPedido;

    @FXML
    private JFXTextField filtroEstado;

    @FXML
    private Label txtColor;

    @FXML
    private Label txtTalle;

    @FXML
    private Label txtDescripcion;

    @FXML
    private Label txtEstado;

    @FXML
    private Label txtIdPrenda;

    @FXML
    private JFXTreeTableView<BultoTabla> vistaTabla2;

    @FXML
    private Label txtStockMin;

    
    JFXTreeTableColumn<PrendaTabla, String> idPrendasCol;
    JFXTreeTableColumn<PrendaTabla, String> descripcionCol;
    JFXTreeTableColumn<PrendaTabla, String> estadoCol;
    JFXTreeTableColumn<PrendaTabla, String> talleCol;
    JFXTreeTableColumn<PrendaTabla, String> colorCol;
    JFXTreeTableColumn<BultoTabla, String> idBultoCol;
    JFXTreeTableColumn<BultoTabla, String> fechaBultoCol;
    JFXTreeTableColumn<BultoTabla, String> cantCol;
    JFXTreeTableColumn<BultoTabla, String> ubicacionCol;
    
    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
    	
    	idPrendasCol = new JFXTreeTableColumn<>("ID");
    	idPrendasCol.setPrefWidth(40);
    	idPrendasCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PrendaTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PrendaTabla, String> param) {
				return param.getValue().getValue().idPrenda;
			}
		});
    	
    	descripcionCol = new JFXTreeTableColumn<>("Descripcion");
    	descripcionCol.setPrefWidth(165);
    	descripcionCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PrendaTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PrendaTabla, String> param) {
				return param.getValue().getValue().descripcion;
			}
		});
    	
    	estadoCol = new JFXTreeTableColumn<>("Estado");
    	estadoCol.setPrefWidth(125);
    	estadoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PrendaTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PrendaTabla, String> param) {
				return param.getValue().getValue().estado;
			}
		});
    	
    	talleCol = new JFXTreeTableColumn<>("Talle");
    	talleCol.setPrefWidth(95);
    	talleCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PrendaTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<PrendaTabla, String> param) {
				return param.getValue().getValue().talle;
			}
		});
    	
    	colorCol = new JFXTreeTableColumn<>("Color");
    	colorCol.setPrefWidth(170);
    	colorCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PrendaTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<PrendaTabla, String> param) {
				return param.getValue().getValue().color;
			}
		});
    	
    	vistaTabla.setPlaceholder(new Label("No hay pedidos pendientes"));
    	vistaTabla2.setPlaceholder(new Label("Seleccione un pedido para ver el contenido"));
    	
    	idPrendasCol.setResizable(false);
    	descripcionCol.setResizable(false);
    	estadoCol.setResizable(false);
    	talleCol.setResizable(false);
    	colorCol.setResizable(false);
    	
    	idPrendasCol.impl_setReorderable(false);
    	descripcionCol.impl_setReorderable(false);
    	estadoCol.impl_setReorderable(false);
    	talleCol.impl_setReorderable(false);
    	colorCol.impl_setReorderable(false);
    	
    	idBultoCol = new JFXTreeTableColumn<>("ID");
    	idBultoCol.setPrefWidth(40);
    	idBultoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BultoTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<BultoTabla, String> param) {
				return param.getValue().getValue().ubicacion;
			}
		});
    	
    	fechaBultoCol = new JFXTreeTableColumn<>("Fecha de generación");
    	fechaBultoCol.setPrefWidth(230);
    	fechaBultoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BultoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<BultoTabla, String> param) {
				return param.getValue().getValue().fechaGen;
			}
		});
    	
    	cantCol = new JFXTreeTableColumn<>("Cantidad");
    	cantCol.setPrefWidth(110);
    	cantCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BultoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<BultoTabla, String> param) {
				return param.getValue().getValue().cant;
			}
		});
    	
    	ubicacionCol = new JFXTreeTableColumn<>("Ubicación");
    	ubicacionCol.setPrefWidth(180);
    	ubicacionCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<BultoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<BultoTabla, String> param) {
				return param.getValue().getValue().ubicacion;
			}
		});
    	
    	cantCol.setResizable(false);
    	ubicacionCol.setResizable(false);
    	fechaBultoCol.setResizable(false);
    	idBultoCol.setResizable(false);
    	
    	cantCol.impl_setReorderable(false);
    	ubicacionCol.impl_setReorderable(false);
    	fechaBultoCol.impl_setReorderable(false);
    	idBultoCol.impl_setReorderable(false);
    	
    	ObservableList<PrendaTabla> pedidos = FXCollections.observableArrayList();
    	ObservableList<BultoTabla> itemsPedido = FXCollections.observableArrayList();

    	//agregar pedidos a la tabla
    	for(PrendaTabla p: buscarPrendas()){
    		pedidos.add(p);
    	}
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<PrendaTabla> root = new RecursiveTreeItem<PrendaTabla>(pedidos, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(idPrendasCol,descripcionCol,estadoCol,talleCol, colorCol);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<BultoTabla> root2 = new RecursiveTreeItem<BultoTabla>(itemsPedido, RecursiveTreeObject::getChildren);
    	vistaTabla2.getColumns().setAll(idBultoCol, fechaBultoCol, cantCol, ubicacionCol);
    	vistaTabla2.setRoot(root2);
    	vistaTabla2.setShowRoot(false);
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroIdPrenda.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<PrendaTabla>>() {					
					@Override
					public boolean test(TreeItem<PrendaTabla> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().idPrenda.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroDescripcion.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<PrendaTabla>>() {					
					@Override
					public boolean test(TreeItem<PrendaTabla> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().descripcion.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	filtroEstado.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<PrendaTabla>>() {					
					@Override
					public boolean test(TreeItem<PrendaTabla> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().estado.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	vistaTabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    	    @Override
    	    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
	    		PrendaDTO seleccionado = new PrendaDTO();
		        //Check whether item is selected and set value of selected item to Label
		        if(vistaTabla.getSelectionModel().getSelectedItem() != null) 
		        {
		        	TreeTableViewSelectionModel<PrendaTabla> selectionModel = vistaTabla.getSelectionModel();
				    ObservableList selectedCells = selectionModel.getSelectedCells();
				    TreeTablePosition tablePosition = (TreeTablePosition) selectedCells.get(0);
				    TreeItem<PrendaTabla> selectedRow = vistaTabla.getTreeItem(tablePosition.getRow());
		            itemsPedido.clear();
		            
		            seleccionado.setIdPrenda(Integer.parseInt(selectedRow.getValue().getIdPrenda()));
		            try {
		            	seleccionado = BusinessDelegate.getInstancia().getPrenda(seleccionado.getIdPrenda());
		            } catch (RemoteException e) {
		            	// TODO Auto-generated catch block
		            	e.printStackTrace();
		            }
    	     	           
		            txtIdPrenda.setText(Integer.toString(seleccionado.getIdPrenda()));
		            txtDescripcion.setText(seleccionado.getDescripcion());
		            txtColor.setText(seleccionado.getColor());
		            txtTalle.setText(seleccionado.getTalle());
		            txtPrecio.setText(Float.toString(seleccionado.getPrecio()));
		            String estado;
		            if(seleccionado.isEstadoProduccion()){estado="Producción";}else{estado="Discontinuo";}
		            txtEstado.setText(estado);
		            txtStockMin.setText(Integer.toString(seleccionado.getStockMinimo()));
		            txtStock.setText(Integer.toString(seleccionado.getStockActual()));
		            
				    /*try {
						ArrayList<BultoDTO> bultos = BusinessDelegate.getInstancia().buscarBultos(seleccionado));
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
					DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				    for(BultoDTO b : bultos){
				    	itemsPedido.add(new BultoTabla(Integer.toString(b.getCodigoBulto()),df.format(b.getFechagen()),Integer.toString(b.getCantidad()),b.getUbicacion()));
				    }*/
				    
				    final TreeItem<BultoTabla> root2 = new RecursiveTreeItem<BultoTabla>(itemsPedido, RecursiveTreeObject::getChildren);
			    	vistaTabla2.getColumns().setAll(idBultoCol, fechaBultoCol, cantCol, ubicacionCol);
				    vistaTabla2.setRoot(root2);
				    vistaTabla2.setShowRoot(false);
    	        }
	         }
    	     });
    }
    
    @FXML
    void limpiarCampos(ActionEvent event) {
        txtIdPrenda.setText("ID");
        txtDescripcion.setText("");
        txtColor.setText("");
        txtTalle.setText("");
        txtPrecio.setText("");
        txtEstado.setText("");
        txtStockMin.setText("");
        txtStock.setText("--");
	    
    	ObservableList<BultoTabla> itemsPedido = FXCollections.observableArrayList();
	    final TreeItem<BultoTabla> root2 = new RecursiveTreeItem<BultoTabla>(itemsPedido, RecursiveTreeObject::getChildren);
    	vistaTabla2.getColumns().setAll(idBultoCol, fechaBultoCol, cantCol, ubicacionCol);
	    vistaTabla2.setRoot(root2);
	    vistaTabla2.setShowRoot(false);
	    
	    btnLimpiar.setDisable(true);
    }
    
    private ArrayList<PrendaTabla> buscarPrendas() {
    	ArrayList<PrendaTabla> resultado = new ArrayList<PrendaTabla>();
    	String estado;
		try {
			for(PrendaDTO p : BusinessDelegate.getInstancia().getPrendas()){	
					if(p.isEstadoProduccion()){
						estado = "Produccion";
					}else{
						estado = "Discontinuo";
					}
					resultado.add(new PrendaTabla(p.getDescripcion(),Integer.toString(p.getIdPrenda()),estado,p.getTalle(),p.getColor()));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	class PrendaTabla extends RecursiveTreeObject<PrendaTabla>{
    	StringProperty idPrenda;
    	StringProperty descripcion;
    	StringProperty estado;
    	StringProperty talle;
    	StringProperty color;
    	
    	public PrendaTabla(String descripcion, String idPrenda, String estado, String talle, String color){
    		this.idPrenda = new SimpleStringProperty(idPrenda);
    		this.descripcion = new SimpleStringProperty(descripcion);
    		this.estado = new SimpleStringProperty(estado);
    		this.talle = new SimpleStringProperty(talle);
    		this.color = new SimpleStringProperty(color);
    	}
    	
    	public String getIdPrenda(){
    		return idPrenda.get();
    	}
    	
    	public StringProperty getDescripcion(){
    		return descripcion;
    	}
    	
    	public String getEstado(){
    		return estado.get();
    	}
    	
    	public String getTalle(){
    		return talle.get();
    	}
    	
    	public String getColor(){
    		return color.get();
    	}
    }
    
    class BultoTabla extends RecursiveTreeObject<BultoTabla>{
    	StringProperty idBulto;
    	StringProperty fechaGen;
    	StringProperty cant;
    	StringProperty ubicacion;
    	
    	public BultoTabla(String idBulto, String fechaGen, String cant, String ubicacion){
    		this.idBulto = new SimpleStringProperty(idBulto);
    		this.fechaGen = new SimpleStringProperty(fechaGen);	//discontinuo o en produccion
    		this.cant = new SimpleStringProperty(cant);
    		this.ubicacion = new SimpleStringProperty(ubicacion);
    	}
    	
    	public String getIdBulto(){
    		return idBulto.get();
    	}
    	
    	public String getFechaGen(){
    		return fechaGen.get();
    	}
    	
    	public String getCant(){
    		return cant.get();
    	}
    	
    	public String getUbicacion(){
    		return ubicacion.get();
    	}
    }
    
}
