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

import application.PedidosCompletosController.PedidoTabla;
import businessDelegate.BusinessDelegate;
import dto.OrdenProduccionDTO;
import dto.PedidoClienteDTO;
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

public class OrdenProduccionFabricarController implements Initializable{

	 @FXML
	    private JFXButton btnEnviar;

	    @FXML
	    private JFXTreeTableView<OrdenesTabla> vistaTabla;

	    @FXML
	    private JFXTextField filtroTipoOrden;

	    @FXML
	    private Label txtIdPedido;

	    @FXML
	    private JFXTextField filtroIDOrden;

	    @FXML
	    private JFXTextField filtroFechaRegistro;

	    @FXML
	    private Label txtIdCliente;

	    @FXML
	    private Label txtTipoOrden;

	    @FXML
	    private JFXTreeTableView<ItemPedTabla> vistaTabla2;

	    @FXML
	    private Label txtEstado;

	    @FXML
	    private Label lblPedido;

	    @FXML
	    private Label txtRazonSocial;

	JFXTreeTableColumn<OrdenesTabla, String> idPedidoCol;
    JFXTreeTableColumn<OrdenesTabla, String> tipoCol;
    JFXTreeTableColumn<OrdenesTabla, String> estadoCol;
    JFXTreeTableColumn<OrdenesTabla, String> fechaGeneracionCol;


	JFXTreeTableColumn<ItemPedTabla, String> nombreProductoCol;
	JFXTreeTableColumn<ItemPedTabla, String> talleCol;
	JFXTreeTableColumn<ItemPedTabla, String> colorCol;
	JFXTreeTableColumn<ItemPedTabla, String> cantidadCol;
	
    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
    	
    	idPedidoCol = new JFXTreeTableColumn<>("Nº");
    	idPedidoCol.setPrefWidth(90);
    	idPedidoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<OrdenesTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<OrdenesTabla, String> param) {
				return param.getValue().getValue().idOrden;
			}
		});
    	
    	tipoCol = new JFXTreeTableColumn<>("Tipo");
    	tipoCol.setPrefWidth(250);
    	tipoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<OrdenesTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<OrdenesTabla, String> param) {
				return param.getValue().getValue().tipo;
			}
		});
    	
    	estadoCol = new JFXTreeTableColumn<>("Estado");
    	estadoCol.setPrefWidth(140);
    	estadoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<OrdenesTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<OrdenesTabla, String> param) {
				return param.getValue().getValue().estado;
			}
		});
    	
    	fechaGeneracionCol = new JFXTreeTableColumn<>("Fecha de orden");
    	fechaGeneracionCol.setPrefWidth(280);
    	fechaGeneracionCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<OrdenesTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<OrdenesTabla, String> param) {
				return param.getValue().getValue().fechaGeneracion;
			}
		});
    	
    	vistaTabla.setPlaceholder(new Label("No hay ordenes de producción hechas"));
    	vistaTabla2.setPlaceholder(new Label("Seleccione una orden para ver su detalle"));

    	idPedidoCol.setResizable(false);
    	tipoCol.setResizable(false);
    	fechaGeneracionCol.setResizable(false);
    	estadoCol.setResizable(false);
    	
    	estadoCol.impl_setReorderable(false);
    	idPedidoCol.impl_setReorderable(false);
    	tipoCol.impl_setReorderable(false);
    	fechaGeneracionCol.impl_setReorderable(false);
    	
    	nombreProductoCol = new JFXTreeTableColumn<>("Producto");
    	nombreProductoCol.setPrefWidth(190);
    	nombreProductoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedTabla, String> param) {
				return param.getValue().getValue().nombreProducto;
			}
		});
    	
    	talleCol = new JFXTreeTableColumn<>("Talle");
    	talleCol.setPrefWidth(60);
    	talleCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedTabla, String> param) {
				return param.getValue().getValue().talle;
			}
		});
    	
    	colorCol = new JFXTreeTableColumn<>("Color");
    	colorCol.setPrefWidth(170);
    	colorCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedTabla, String> param) {
				return param.getValue().getValue().color;
			}
		});
    	
    	cantidadCol = new JFXTreeTableColumn<>("Cantidad");
    	cantidadCol.setPrefWidth(120);
    	cantidadCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedTabla, String> param) {
				return param.getValue().getValue().cantidad;
			}
		});
    	
    	nombreProductoCol.setResizable(false);
    	talleCol.setResizable(false);
    	colorCol.setResizable(false);
    	cantidadCol.setResizable(false);
    	
    	nombreProductoCol.impl_setReorderable(false);
    	talleCol.impl_setReorderable(false);
    	colorCol.impl_setReorderable(false);
    	cantidadCol.impl_setReorderable(false);
    	
    	ObservableList<OrdenesTabla> ordenes = FXCollections.observableArrayList();
    	ObservableList<ItemPedTabla> itemsOrdenes = FXCollections.observableArrayList();
       	
    	
    	//agregar pedidos a la tabla
    	for(OrdenesTabla p: buscarOrdenes()){
    		ordenes.add(p);
    	}
    	
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<OrdenesTabla> root = new RecursiveTreeItem<OrdenesTabla>(ordenes, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(idPedidoCol,tipoCol,estadoCol, fechaGeneracionCol);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<ItemPedTabla> root2 = new RecursiveTreeItem<ItemPedTabla>(itemsOrdenes, RecursiveTreeObject::getChildren);
    	vistaTabla2.getColumns().setAll(nombreProductoCol, talleCol,colorCol,cantidadCol);
    	vistaTabla2.setRoot(root2);
    	vistaTabla2.setShowRoot(false);
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroTipoOrden.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<OrdenesTabla>>() {					
					@Override
					public boolean test(TreeItem<OrdenesTabla> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().tipo	.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroIDOrden.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<OrdenesTabla>>() {					
					@Override
					public boolean test(TreeItem<OrdenesTabla> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().idOrden.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	filtroFechaRegistro.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<OrdenesTabla>>() {					
					@Override
					public boolean test(TreeItem<OrdenesTabla> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().fechaGeneracion.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	vistaTabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
    	    @Override
    	    public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
	    		OrdenProduccionDTO seleccionado = new OrdenProduccionDTO();
		        //Check whether item is selected and set value of selected item to Label
		        if(vistaTabla.getSelectionModel().getSelectedItem() != null) 
		        {
		        	itemsOrdenes.clear();
		        	TreeTableViewSelectionModel<OrdenesTabla> selectionModel = vistaTabla.getSelectionModel();
				    ObservableList selectedCells = selectionModel.getSelectedCells();
				    TreeTablePosition tablePosition = (TreeTablePosition) selectedCells.get(0);
				    TreeItem<OrdenesTabla> selectedRow = vistaTabla.getTreeItem(tablePosition.getRow());
		           
		            seleccionado.setCodigo(Integer.parseInt(selectedRow.getValue().getIdOrden().getValue()));
		            try {
		            	seleccionado = BusinessDelegate.getInstancia().buscarOrden(seleccionado);
		            } catch (RemoteException e) {
		            	// TODO Auto-generated catch block
		            	e.printStackTrace();
		            }
    	     	           
				    txtIdCliente.setText("ID"+Integer.toString(seleccionado.getIdOrden()));
				    txtRazonSocial.setText(seleccionado.getPedidoCliente().getCliente().getNombre());
				    txtIdPedido.setText(Integer.toString(seleccionado.getPedidoCliente().getIdPedidoCliente()));
				    txtTipoOrden.setText(seleccionado.getTipo());
				    txtEstado.setText("Listo para fabricar");
				    
				    itemsOrdenes.add(new ItemPedTabla(seleccionado.getPrenda().getDescripcion(), seleccionado.getPrenda().getTalle(), seleccionado.getPrenda().getColor(), Integer.toString(seleccionado.getCantidad())));

				    final TreeItem<ItemPedTabla> root2 = new RecursiveTreeItem<ItemPedTabla>(itemsOrdenes, RecursiveTreeObject::getChildren);
				    vistaTabla2.getColumns().setAll(nombreProductoCol, talleCol,colorCol,cantidadCol);
				    vistaTabla2.setRoot(root2);
				    vistaTabla2.setShowRoot(false);
				    
				    if(seleccionado.getEstado().equalsIgnoreCase("Pendiente confirmacion"))
    	       		btnEnviar.setDisable(true);
				    else
				    btnEnviar.setDisable(false);
    	        }
	         }
    	     });
    }
    
    @FXML
    void fabricarOrden(ActionEvent event) {
    	OrdenProduccionDTO seleccionado = new OrdenProduccionDTO();
        //Check whether item is selected and set value of selected item to Label
        if(vistaTabla.getSelectionModel().getSelectedItem() != null) 
        {
        	TreeTableViewSelectionModel<OrdenesTabla> selectionModel = vistaTabla.getSelectionModel();
		    ObservableList selectedCells = selectionModel.getSelectedCells();
		    TreeTablePosition tablePosition = (TreeTablePosition) selectedCells.get(0);
		    TreeItem<OrdenesTabla> selectedRow = vistaTabla.getTreeItem(tablePosition.getRow());
           
            seleccionado.setCodigo(Integer.parseInt(selectedRow.getValue().getIdOrden().getValue()));
            
            try {
            	seleccionado = BusinessDelegate.getInstancia().buscarOrden(seleccionado);
            	BusinessDelegate.getInstancia().fabricarOrden(seleccionado);
            	
            	ObservableList<OrdenesTabla> ordenes = FXCollections.observableArrayList();
            	ObservableList<ItemPedTabla> itemsOrdenes = FXCollections.observableArrayList();
            	
            	//agregar pedidos a la tabla
            	for(OrdenesTabla p: buscarOrdenes()){
            		ordenes.add(p);
            	}
            	
            	final TreeItem<OrdenesTabla> root = new RecursiveTreeItem<OrdenesTabla>(ordenes, RecursiveTreeObject::getChildren);
            	vistaTabla.getColumns().setAll(idPedidoCol,tipoCol, estadoCol, fechaGeneracionCol);
            	vistaTabla.setRoot(root);
            	vistaTabla.setShowRoot(false);
            	
			    final TreeItem<ItemPedTabla> root2 = new RecursiveTreeItem<ItemPedTabla>(itemsOrdenes, RecursiveTreeObject::getChildren);
			    vistaTabla2.getColumns().setAll(nombreProductoCol, talleCol,colorCol,cantidadCol);
			    vistaTabla2.setRoot(root2);
			    vistaTabla2.setShowRoot(false);
			    
			    btnEnviar.setDisable(true);
            } catch (RemoteException e) {
            	// TODO Auto-generated catch block
            	e.printStackTrace();
            }
            
            
            
        }
    }
    
    void limpiarC(){
	    txtIdCliente.setText("ID");
	    txtRazonSocial.setText("");
	    txtEstado.setText("--");
	    lblPedido.setText("DETALLE DE PEDIDO ");
	    
    	ObservableList<ItemPedTabla> itemsPedido = FXCollections.observableArrayList();
	    final TreeItem<ItemPedTabla> root2 = new RecursiveTreeItem<ItemPedTabla>(itemsPedido, RecursiveTreeObject::getChildren);
	    vistaTabla2.getColumns().setAll(nombreProductoCol, talleCol,colorCol,cantidadCol);
	    vistaTabla2.setRoot(root2);
	    vistaTabla2.setShowRoot(false);

   		btnEnviar.setDisable(true);
    }
    
    private ArrayList<OrdenesTabla> buscarOrdenes() {
    	ArrayList<OrdenesTabla> resultado = new ArrayList<OrdenesTabla>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		try {
			for(OrdenProduccionDTO p : BusinessDelegate.getInstancia().getOrdenes()){	
				resultado.add(new OrdenesTabla(Integer.toString(p.getIdOrden()), p.getTipo(), p.getEstado(), df.format(p.getFecha())));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	class OrdenesTabla extends RecursiveTreeObject<OrdenesTabla>{
    	StringProperty idOrden;
    	StringProperty tipo;
    	StringProperty estado;
    	StringProperty fechaGeneracion;
    	
    	public OrdenesTabla(String idPedido, String telefono, String estado, String fechaGeneracion){
    		this.idOrden = new SimpleStringProperty(idPedido);
    		this.tipo = new SimpleStringProperty(telefono);
    		this.estado = new SimpleStringProperty(estado);
    		this.fechaGeneracion = new SimpleStringProperty(fechaGeneracion);
    	}
    	
    	public StringProperty getEstado() {
			return estado;
		}

		public void setEstado(StringProperty estado) {
			this.estado = estado;
		}

		public StringProperty getIdOrden(){
    		return idOrden;
    	}
    	
    	public String getTelefono(){
    		return tipo.get();
    	}
    	
    	public String getFechaGeneracion(){
    		return fechaGeneracion.get();
    	}
    }
    
    class ItemPedTabla extends RecursiveTreeObject<ItemPedTabla>{
    	StringProperty nombreProducto;
    	StringProperty talle;
    	StringProperty color;
    	StringProperty cantidad;
    	
    	public ItemPedTabla(String nombreProducto, String talle, String color, String cantidad){
    		//Producto, Tipo Producto, Talle, Color, Cantidad
    		this.nombreProducto = new SimpleStringProperty(nombreProducto);
    		this.talle = new SimpleStringProperty(talle);
    		this.color = new SimpleStringProperty(color);
    		this.cantidad = new SimpleStringProperty(cantidad);
    	}
    	
    	public String getNombreProducto(){
    		return nombreProducto.get();
    	}

    	
    	public String getTalle(){
    		return talle.get();
    	}
    	
    	public String getColor(){
    		return color.get();
    	}
    	
    	public String getCantidad(){
    		return cantidad.get();
    	}
    }
    
}
