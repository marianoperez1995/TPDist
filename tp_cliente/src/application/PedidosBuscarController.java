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

import application.PedidosPendientesController.ListaPedido;
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

public class PedidosBuscarController implements Initializable{

	@FXML
    private Label txtFechaPago;

    @FXML
    private JFXTreeTableView<ListaPedido> vistaTabla;

    @FXML
    private JFXComboBox<String> comboEstado;

    @FXML
    private Label txtTel;

    @FXML
    private Label txtBalance;

    @FXML
    private JFXTextField filtroRazonSocial;

    @FXML
    private Label lblPedido;

    @FXML
    private Label txtCuit;

    @FXML
    private JFXTextField filtroFechaRegistro;

    @FXML
    private Label txtIdCliente;

    @FXML
    private Label txtLimiteCred;

    @FXML
    private JFXTreeTableView<ItemPedido> vistaTabla2;

    @FXML
    private Label txtRazonSocial;
    
    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
    
    	comboEstado.getItems().addAll("Todos","Pendiente","Aceptado", "Completado", "Remitido", "Enviado");
    	comboEstado.setPromptText("Seleccionar estado");
    	
    	JFXTreeTableColumn<ListaPedido, String> idPedidoCol = new JFXTreeTableColumn<>("Pedido");
    	idPedidoCol.setPrefWidth(170);
    	idPedidoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ListaPedido,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ListaPedido, String> param) {
				return param.getValue().getValue().idPedido;
			}
		});
    	
    	JFXTreeTableColumn<ListaPedido, String> razonSocialCol = new JFXTreeTableColumn<>("Razon Social");
    	razonSocialCol.setPrefWidth(137);
    	razonSocialCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ListaPedido,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ListaPedido, String> param) {
				return param.getValue().getValue().razonSocial;
			}
		});
    	
    	JFXTreeTableColumn<ListaPedido, String> estado = new JFXTreeTableColumn<>("Telefono");
    	estado.setPrefWidth(135);
    	estado.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ListaPedido,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ListaPedido, String> param) {
				return param.getValue().getValue().estado;
			}
		});
    	
    	JFXTreeTableColumn<ListaPedido, String> fechaGeneracionCol = new JFXTreeTableColumn<>("Fecha de pedido");
    	fechaGeneracionCol.setPrefWidth(185);
    	fechaGeneracionCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ListaPedido,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<ListaPedido, String> param) {
				return param.getValue().getValue().fechaGeneracion;
			}
		});
    	
    	
    	idPedidoCol.setResizable(false);
    	razonSocialCol.setResizable(false);
    	estado.setResizable(false);
    	fechaGeneracionCol.setResizable(false);
    	
    	idPedidoCol.impl_setReorderable(false);
    	razonSocialCol.impl_setReorderable(false);
    	estado.impl_setReorderable(false);
    	fechaGeneracionCol.impl_setReorderable(false);
    	
    	JFXTreeTableColumn<ItemPedido, String> nombreProductoCol = new JFXTreeTableColumn<>("Producto");
    	nombreProductoCol.setPrefWidth(190);
    	nombreProductoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedido,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedido, String> param) {
				return param.getValue().getValue().nombreProducto;
			}
		});
    	
    	JFXTreeTableColumn<ItemPedido, String> tipoProductoCol = new JFXTreeTableColumn<>("Tipo");
    	tipoProductoCol.setPrefWidth(110);
    	tipoProductoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedido,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedido, String> param) {
				return param.getValue().getValue().tipoProducto;
			}
		});
    	
    	JFXTreeTableColumn<ItemPedido, String> talleCol = new JFXTreeTableColumn<>("Talle");
    	talleCol.setPrefWidth(60);
    	talleCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedido,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedido, String> param) {
				return param.getValue().getValue().talle;
			}
		});
    	
    	JFXTreeTableColumn<ItemPedido, String> colorCol = new JFXTreeTableColumn<>("Color");
    	colorCol.setPrefWidth(170);
    	colorCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedido,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedido, String> param) {
				return param.getValue().getValue().color;
			}
		});
    	
    	JFXTreeTableColumn<ItemPedido, String> cantidadCol = new JFXTreeTableColumn<>("Cantidad");
    	cantidadCol.setPrefWidth(120);
    	cantidadCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedido,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedido, String> param) {
				return param.getValue().getValue().cantidad;
			}
		});
    	
    	tipoProductoCol.setResizable(false);
    	nombreProductoCol.setResizable(false);
    	talleCol.setResizable(false);
    	colorCol.setResizable(false);
    	cantidadCol.setResizable(false);
    	
    	tipoProductoCol.impl_setReorderable(false);
    	nombreProductoCol.impl_setReorderable(false);
    	talleCol.impl_setReorderable(false);
    	colorCol.impl_setReorderable(false);
    	cantidadCol.impl_setReorderable(false);
    	
    	ObservableList<ListaPedido> pedidos = FXCollections.observableArrayList();
    	ObservableList<ItemPedido> itemsPedido = FXCollections.observableArrayList();
    	
    	//agregar pedidos a la tabla
    	pedidos.add(new ListaPedido("123","Natanael SRL", "Pendiente", "10/10/2016"));
    	pedidos.add(new ListaPedido("123","Nicolas SA", "Pendiente", "05/10/2013"));
    	pedidos.add(new ListaPedido("123","Luciano SRL", "Pendiente", "07/11/2014"));
    	pedidos.add(new ListaPedido("123","Franco SH", "Completado", "18/05/2016"));
    	pedidos.add(new ListaPedido("123","Francisco SRL", "Completado", "25/04/2016"));
    	pedidos.add(new ListaPedido("123","Ramiro SA", "Pendiente", "23/09/2014"));
    	pedidos.add(new ListaPedido("123","Maturano SRL", "Aceptado", "30/10/2013"));
    	pedidos.add(new ListaPedido("123","Matias Leonel SA", "Pendiente", "01/08/2014"));
    	
    	
    	itemsPedido.add(new ItemPedido("Remera FAL", "Discontinuo", "L", "Blanco", "36"));
    	itemsPedido.add(new ItemPedido("Pantalon NET", "Produccion", "M", "Negro", "36"));
    	itemsPedido.add(new ItemPedido("Medias LX", "Produccion", "M", "Rojo", "42"));
    	itemsPedido.add(new ItemPedido("Remera FEEL", "Discontinuo", "S", "Negro", "50"));
    	
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<ListaPedido> root = new RecursiveTreeItem<ListaPedido>(pedidos, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(idPedidoCol,razonSocialCol,estado,fechaGeneracionCol);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<ItemPedido> root2 = new RecursiveTreeItem<ItemPedido>(itemsPedido, RecursiveTreeObject::getChildren);
    	vistaTabla2.getColumns().setAll(nombreProductoCol,tipoProductoCol,talleCol,colorCol,cantidadCol);
    	vistaTabla2.setRoot(root2);
    	vistaTabla2.setShowRoot(false);
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroRazonSocial.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<ListaPedido>>() {					
					@Override
					public boolean test(TreeItem<ListaPedido> pedido) {
						// TODO Auto-generated method stub
						Boolean flag = pedido.getValue().razonSocial.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	comboEstado.valueProperty().addListener(new ChangeListener<String>() {
            @Override public void changed(ObservableValue<? extends String> ov, String t, String t1) {
            	vistaTabla.setPredicate(new Predicate<TreeItem<ListaPedido>>() {					
					@Override
					public boolean test(TreeItem<ListaPedido> pedido) {
						// TODO Auto-generated method stub
						if(t1!="Todos"){
						Boolean flag = pedido.getValue().estado.getValue().equalsIgnoreCase(t1);
						return flag;
						}else{
							Boolean flag = pedido.getValue().estado.getValue().equalsIgnoreCase("Pendiente") || pedido.getValue().estado.getValue().equalsIgnoreCase("Completado") || pedido.getValue().estado.getValue().equalsIgnoreCase("Aceptado");
							return flag;
						}
						
					}
				});
            }    
        });
    	
    	filtroFechaRegistro.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<ListaPedido>>() {					
					@Override
					public boolean test(TreeItem<ListaPedido> pedido) {
						// TODO Auto-generated method stub
						Boolean flag = pedido.getValue().fechaGeneracion.getValue().contains(newValue);
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
	    	           TreeTableViewSelectionModel<ListaPedido> selectionModel = vistaTabla.getSelectionModel();
	    	           ObservableList selectedCells = selectionModel.getSelectedCells();
	    	           TreeTablePosition tablePosition = (TreeTablePosition) selectedCells.get(0);
	    	           TreeItem<ListaPedido> selectedRow = vistaTabla.getTreeItem(tablePosition.getRow());
	    	           txtRazonSocial.setText(selectedRow.getValue().getRazonSocial());
	    	           lblPedido.setText("PEDIDO " +selectedRow.getValue().getIdPedido());
	    	           System.out.println(selectedRow.getValue().getRazonSocial() + " - " + selectedRow.getValue().getIdPedido() + " - " + selectedRow.getValue().getTelefono() + " - " + selectedRow.getValue().getFechaGeneracion());	    	           
	    	           //cargar
	    	        }
    	         }
    	     });
    }
    
    class ListaPedido extends RecursiveTreeObject<ListaPedido>{
    	StringProperty razonSocial;
    	StringProperty idPedido;
    	StringProperty estado;
    	StringProperty fechaGeneracion;
    	
    	public ListaPedido(String idPedido, String razonSocial, String telefono, String fechaGeneracion){
    		this.razonSocial = new SimpleStringProperty(razonSocial);
    		this.idPedido = new SimpleStringProperty(idPedido);
    		this.estado = new SimpleStringProperty(telefono);
    		this.fechaGeneracion = new SimpleStringProperty(fechaGeneracion);
    	}
    	
    	public String getRazonSocial(){
    		return razonSocial.get();
    	}
    	
    	public String getIdPedido(){
    		return idPedido.get();
    	}
    	
    	public String getTelefono(){
    		return estado.get();
    	}
    	
    	public String getFechaGeneracion(){
    		return fechaGeneracion.get();
    	}
    }
    
    class ItemPedido extends RecursiveTreeObject<ItemPedido>{
    	StringProperty nombreProducto;
    	StringProperty tipoProducto;
    	StringProperty talle;
    	StringProperty color;
    	StringProperty cantidad;
    	
    	public ItemPedido(String nombreProducto, String tipoProducto, String talle, String color, String cantidad){
    		//Producto, Tipo Producto, Talle, Color, Cantidad
    		this.nombreProducto = new SimpleStringProperty(nombreProducto);
    		this.tipoProducto = new SimpleStringProperty(tipoProducto);	//discontinuo o en produccion
    		this.talle = new SimpleStringProperty(talle);
    		this.color = new SimpleStringProperty(color);
    		this.cantidad = new SimpleStringProperty(cantidad);
    	}
    	
    	public String getNombreProducto(){
    		return nombreProducto.get();
    	}
    	
    	public String getTipoProducto(){
    		return tipoProducto.get();
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
