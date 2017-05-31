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

public class FacturaNuevaController implements Initializable{

	@FXML
    private Label txtFechaPago;

    @FXML
    private JFXButton btnEnviar;

    @FXML
    private JFXTreeTableView<ListaPedido> vistaTabla;

    @FXML
    private Label txtTel;

    @FXML
    private Label txtBalance;

    @FXML
    private JFXTextField filtroRazonSocial;

    @FXML
    private JFXTextField filtroCuit;

    @FXML
    private Label txtCuit;
    
    @FXML
    private Label lblPedido;

    @FXML
    private JFXTextField filtroFechaRegistro;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private Label txtLimiteCred;

    @FXML
    private JFXTreeTableView<ItemPedido> vistaTabla2;

    @FXML
    private Label txtEstado;

    @FXML
    private Label txtRazonSocial;
    
    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
    	
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
    	
    	JFXTreeTableColumn<ListaPedido, String> estadoCol = new JFXTreeTableColumn<>("Estado");
    	estadoCol.setPrefWidth(135);
    	estadoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ListaPedido,String>, ObservableValue<String>>() {
			
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
    	estadoCol.setResizable(false);
    	fechaGeneracionCol.setResizable(false);
    	
    	idPedidoCol.impl_setReorderable(false);
    	razonSocialCol.impl_setReorderable(false);
    	estadoCol.impl_setReorderable(false);
    	fechaGeneracionCol.impl_setReorderable(false);
    	
    	JFXTreeTableColumn<ItemPedido, String> nombreProductoCol = new JFXTreeTableColumn<>("Producto");
    	nombreProductoCol.setPrefWidth(190);
    	nombreProductoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedido,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedido, String> param) {
				return param.getValue().getValue().nombreProducto;
			}
		});
    	
    	JFXTreeTableColumn<ItemPedido, String> subtotalCol = new JFXTreeTableColumn<>("Subtotal");
    	subtotalCol.setPrefWidth(110);
    	subtotalCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedido,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedido, String> param) {
				return param.getValue().getValue().subtotal;
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
    	
    	subtotalCol.setResizable(false);
    	nombreProductoCol.setResizable(false);
    	talleCol.setResizable(false);
    	colorCol.setResizable(false);
    	cantidadCol.setResizable(false);
    	
    	subtotalCol.impl_setReorderable(false);
    	nombreProductoCol.impl_setReorderable(false);
    	talleCol.impl_setReorderable(false);
    	colorCol.impl_setReorderable(false);
    	cantidadCol.impl_setReorderable(false);
    	
    	ObservableList<ListaPedido> pedidos = FXCollections.observableArrayList();
    	ObservableList<ItemPedido> itemsPedido = FXCollections.observableArrayList();
    	
    	//agregar pedidos a la tabla
    	pedidos.add(new ListaPedido("123","Natanael SRL", "Remitido", "10/10/2016"));
    	pedidos.add(new ListaPedido("123","Nicolas SA", "Remitido", "05/10/2013"));
    	pedidos.add(new ListaPedido("123","Luciano SRL", "Remitido", "07/11/2014"));
    	pedidos.add(new ListaPedido("123","Franco SH", "Remitido", "18/05/2016"));
    	pedidos.add(new ListaPedido("123","Francisco SRL", "Remitido", "25/04/2016"));
    	pedidos.add(new ListaPedido("123","Ramiro SA", "Remitido", "23/09/2014"));
    	pedidos.add(new ListaPedido("123","Maturano SRL", "Remitido", "30/10/2013"));
    	pedidos.add(new ListaPedido("123","Matias Leonel SA", "Remitido", "01/08/2014"));
    	
    	
    	itemsPedido.add(new ItemPedido("Remera FAL", "L", "Blanco", "36", "1000"));
    	itemsPedido.add(new ItemPedido("Pantalon NET", "M", "Negro", "36", "1300"));
    	itemsPedido.add(new ItemPedido("Medias LX", "M", "Rojo", "42", "1299"));
    	itemsPedido.add(new ItemPedido("Remera FEEL", "S", "Negro", "50", "800"));
    	
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<ListaPedido> root = new RecursiveTreeItem<ListaPedido>(pedidos, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(idPedidoCol,razonSocialCol,estadoCol,fechaGeneracionCol);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<ItemPedido> root2 = new RecursiveTreeItem<ItemPedido>(itemsPedido, RecursiveTreeObject::getChildren);
    	vistaTabla2.getColumns().setAll(nombreProductoCol,talleCol,colorCol,cantidadCol,subtotalCol);
    	vistaTabla2.setRoot(root2);
    	vistaTabla2.setShowRoot(false);
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroRazonSocial.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<ListaPedido>>() {					
					@Override
					public boolean test(TreeItem<ListaPedido> cliente) {
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
					vistaTabla.setPredicate(new Predicate<TreeItem<ListaPedido>>() {					
					@Override
					public boolean test(TreeItem<ListaPedido> cliente) {
						// TODO Auto-generated method stub
						Boolean flag = cliente.getValue().idPedido.getValue().contains(newValue);
						return flag;
					}
				});
			}
		});
    	
    	filtroFechaRegistro.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<ListaPedido>>() {					
					@Override
					public boolean test(TreeItem<ListaPedido> cliente) {
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
    	StringProperty subtotal;
    	StringProperty talle;
    	StringProperty color;
    	StringProperty cantidad;
    	
    	public ItemPedido(String nombreProducto, String talle, String color, String cantidad, String subtotal){
    		//Producto, Tipo Producto, Talle, Color, Cantidad
    		this.nombreProducto = new SimpleStringProperty(nombreProducto);
    		this.subtotal = new SimpleStringProperty(subtotal);	//discontinuo o en produccion
    		this.talle = new SimpleStringProperty(talle);
    		this.color = new SimpleStringProperty(color);
    		this.cantidad = new SimpleStringProperty(cantidad);
    	}
    	
    	public String getNombreProducto(){
    		return nombreProducto.get();
    	}
    	
    	public String getSubtotal(){
    		return subtotal.get();
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
