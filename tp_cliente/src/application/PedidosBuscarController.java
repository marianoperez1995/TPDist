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
import businessDelegate.BusinessDelegate;
import dto.ClienteDTO;
import dto.ItemPedidoClienteDTO;
import dto.PedidoClienteDTO;
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
    private JFXButton btnEnviar;

    @FXML
    private JFXTreeTableView<PedidoTabla> vistaTabla;

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
    private Label txtIdCliente;
    
    @FXML
    private Label lblPedido;

    @FXML
    private JFXTextField filtroFechaRegistro;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private Label txtLimiteCred;

    @FXML
    private JFXTreeTableView<ItemPedTabla> vistaTabla2;

    @FXML
    private Label txtEstado;

    @FXML
    private Label txtRazonSocial;
    
    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
    	
    	JFXTreeTableColumn<PedidoTabla, String> idPedidoCol = new JFXTreeTableColumn<>("Pedido");
    	idPedidoCol.setPrefWidth(170);
    	idPedidoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PedidoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PedidoTabla, String> param) {
				return param.getValue().getValue().idPedido;
			}
		});
    	
    	JFXTreeTableColumn<PedidoTabla, String> razonSocialCol = new JFXTreeTableColumn<>("Razon Social");
    	razonSocialCol.setPrefWidth(137);
    	razonSocialCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PedidoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PedidoTabla, String> param) {
				return param.getValue().getValue().razonSocial;
			}
		});
    	
    	JFXTreeTableColumn<PedidoTabla, String> estadoCol = new JFXTreeTableColumn<>("Estado");
    	estadoCol.setPrefWidth(135);
    	estadoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PedidoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PedidoTabla, String> param) {
				return param.getValue().getValue().estado;
			}
		});
    	
    	JFXTreeTableColumn<PedidoTabla, String> fechaGeneracionCol = new JFXTreeTableColumn<>("Fecha de pedido");
    	fechaGeneracionCol.setPrefWidth(185);
    	fechaGeneracionCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PedidoTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<PedidoTabla, String> param) {
				return param.getValue().getValue().fechaGeneracion;
			}
		});
    	
    	vistaTabla.setPlaceholder(new Label("No hay pedidos pendientes"));
    	vistaTabla2.setPlaceholder(new Label("Seleccione un pedido para ver el contenido"));
    	
    	idPedidoCol.setResizable(false);
    	razonSocialCol.setResizable(false);
    	estadoCol.setResizable(false);
    	fechaGeneracionCol.setResizable(false);
    	
    	idPedidoCol.impl_setReorderable(false);
    	razonSocialCol.impl_setReorderable(false);
    	estadoCol.impl_setReorderable(false);
    	fechaGeneracionCol.impl_setReorderable(false);
    	
    	JFXTreeTableColumn<ItemPedTabla, String> nombreProductoCol = new JFXTreeTableColumn<>("Producto");
    	nombreProductoCol.setPrefWidth(190);
    	nombreProductoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedTabla, String> param) {
				return param.getValue().getValue().nombreProducto;
			}
		});
    	
    	JFXTreeTableColumn<ItemPedTabla, String> tipoProductoCol = new JFXTreeTableColumn<>("Tipo");
    	tipoProductoCol.setPrefWidth(110);
    	tipoProductoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedTabla, String> param) {
				return param.getValue().getValue().tipoProducto;
			}
		});
    	
    	JFXTreeTableColumn<ItemPedTabla, String> talleCol = new JFXTreeTableColumn<>("Talle");
    	talleCol.setPrefWidth(60);
    	talleCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedTabla, String> param) {
				return param.getValue().getValue().talle;
			}
		});
    	
    	JFXTreeTableColumn<ItemPedTabla, String> colorCol = new JFXTreeTableColumn<>("Color");
    	colorCol.setPrefWidth(170);
    	colorCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedTabla, String> param) {
				return param.getValue().getValue().color;
			}
		});
    	
    	JFXTreeTableColumn<ItemPedTabla, String> cantidadCol = new JFXTreeTableColumn<>("Cantidad");
    	cantidadCol.setPrefWidth(120);
    	cantidadCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedTabla,String>, ObservableValue<String>>() {
    		
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedTabla, String> param) {
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
    	
    	ObservableList<PedidoTabla> pedidos = FXCollections.observableArrayList();
    	ObservableList<ItemPedTabla> itemsPedido = FXCollections.observableArrayList();
    	
    	//agregar pedidos a la tabla
    	pedidos.add(new PedidoTabla("123","Natanael SRL", "Pendiente", "10/10/2016"));
    	pedidos.add(new PedidoTabla("123","Nicolas SA", "Pendiente", "05/10/2013"));
    	pedidos.add(new PedidoTabla("123","Luciano SRL", "Pendiente", "07/11/2014"));
    	pedidos.add(new PedidoTabla("123","Franco SH", "Pendiente", "18/05/2016"));
    	pedidos.add(new PedidoTabla("123","Francisco SRL", "Pendiente", "25/04/2016"));
    	pedidos.add(new PedidoTabla("123","Ramiro SA", "Pendiente", "23/09/2014"));
    	pedidos.add(new PedidoTabla("123","Maturano SRL", "Pendiente", "30/10/2013"));
    	pedidos.add(new PedidoTabla("123","Matias Leonel SA", "Pendiente", "01/08/2014"));
 
    	
    	
    	/*//agregar clientes a la tabla
    	for(ListaPedido p: buscarPedidos()){
    		pedidos.add(p);
    	}*/
    	
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<PedidoTabla> root = new RecursiveTreeItem<PedidoTabla>(pedidos, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(idPedidoCol,razonSocialCol,estadoCol,fechaGeneracionCol);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<ItemPedTabla> root2 = new RecursiveTreeItem<ItemPedTabla>(itemsPedido, RecursiveTreeObject::getChildren);
    	vistaTabla2.getColumns().setAll(nombreProductoCol,tipoProductoCol,talleCol,colorCol,cantidadCol);
    	vistaTabla2.setRoot(root2);
    	vistaTabla2.setShowRoot(false);
    	
    	//El filtro distingue mayuscula y minuscula
    	filtroRazonSocial.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					vistaTabla.setPredicate(new Predicate<TreeItem<PedidoTabla>>() {					
					@Override
					public boolean test(TreeItem<PedidoTabla> cliente) {
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
					vistaTabla.setPredicate(new Predicate<TreeItem<PedidoTabla>>() {					
					@Override
					public boolean test(TreeItem<PedidoTabla> cliente) {
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
					vistaTabla.setPredicate(new Predicate<TreeItem<PedidoTabla>>() {					
					@Override
					public boolean test(TreeItem<PedidoTabla> cliente) {
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
	    		PedidoClienteDTO seleccionado = new PedidoClienteDTO();
		        //Check whether item is selected and set value of selected item to Label
		        if(vistaTabla.getSelectionModel().getSelectedItem() != null) 
		        {
		        	TreeTableViewSelectionModel<PedidoTabla> selectionModel = vistaTabla.getSelectionModel();
				    ObservableList selectedCells = selectionModel.getSelectedCells();
				    TreeTablePosition tablePosition = (TreeTablePosition) selectedCells.get(0);
				    TreeItem<PedidoTabla> selectedRow = vistaTabla.getTreeItem(tablePosition.getRow());
		           
		            seleccionado.setIdPedidoCliente(Integer.parseInt(selectedRow.getValue().getIdPedido().getValue()));
		            try {
		            	seleccionado = BusinessDelegate.getInstancia().buscarPedido(seleccionado);
		            } catch (RemoteException e) {
		            	// TODO Auto-generated catch block
		            	e.printStackTrace();
		            }
    	     	           
				    txtIdCliente.setText("ID"+Integer.toString(seleccionado.getCliente().getNumeroCliente()));
				    txtRazonSocial.setText(seleccionado.getCliente().getNombre());
				    txtCuit.setText(seleccionado.getCliente().getCuit());
				    txtTel.setText(seleccionado.getCliente().getTelefono());
				    txtLimiteCred.setText(Float.toString(seleccionado.getCliente().getCuentaCorriente().getLimite()));
				    txtFechaPago.setText(seleccionado.getCliente().getCuentaCorriente().getFecha());
				    txtBalance.setText(Float.toString(seleccionado.getCliente().getCuentaCorriente().getBalanceActual()));
				    txtEstado.setText("CAMBIAR ESTO!!!!!!");
				    
				    for(ItemPedidoClienteDTO c : seleccionado.getItemsPedidoCliente()){
				    	itemsPedido.add(new ItemPedTabla("Remera FAL", "Discontinuo", "L", "Blanco", "36"));
				    	String estado;
				    	if(c.getPrenda().isEstadoProduccion()){
				    		estado = "Producción";
				    	}else{
				    		estado = "Discontinuo";
				    	}
				    	
				    	itemsPedido.add(new ItemPedTabla(c.getPrenda().getDescripcion(), estado, c.getPrenda().getTalle(), c.getPrenda().getColor(), Integer.toString(c.getCantidad())));
				    }

				    final TreeItem<ItemPedTabla> root2 = new RecursiveTreeItem<ItemPedTabla>(itemsPedido, RecursiveTreeObject::getChildren);
				    vistaTabla2.getColumns().setAll(nombreProductoCol,tipoProductoCol,talleCol,colorCol,cantidadCol);
				    vistaTabla2.setRoot(root2);
				    vistaTabla2.setShowRoot(false);
				    
    	       		btnCancelar.setDisable(false);
    	       		btnEnviar.setDisable(false);
    	        }
	         }
    	     });
    }
    
    private ArrayList<PedidoTabla> buscarPedidos() {
    	ArrayList<PedidoTabla> resultado = new ArrayList<PedidoTabla>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		try {
			for(PedidoClienteDTO p : BusinessDelegate.getInstancia().getPedidos())
			resultado.add(new PedidoTabla(Integer.toString(p.getIdPedidoCliente()), p.getCliente().getNombre(),p.getEstado(),df.format(p.getFechaGeneracion())));
			return resultado;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	class PedidoTabla extends RecursiveTreeObject<PedidoTabla>{
    	StringProperty razonSocial;
    	StringProperty idPedido;
    	StringProperty estado;
    	StringProperty fechaGeneracion;
    	
    	public PedidoTabla(String idPedido, String razonSocial, String telefono, String fechaGeneracion){
    		this.razonSocial = new SimpleStringProperty(razonSocial);
    		this.idPedido = new SimpleStringProperty(idPedido);
    		this.estado = new SimpleStringProperty(telefono);
    		this.fechaGeneracion = new SimpleStringProperty(fechaGeneracion);
    	}
    	
    	public String getRazonSocial(){
    		return razonSocial.get();
    	}
    	
    	public StringProperty getIdPedido(){
    		return idPedido;
    	}
    	
    	public String getTelefono(){
    		return estado.get();
    	}
    	
    	public String getFechaGeneracion(){
    		return fechaGeneracion.get();
    	}
    }
    
    class ItemPedTabla extends RecursiveTreeObject<ItemPedTabla>{
    	StringProperty nombreProducto;
    	StringProperty tipoProducto;
    	StringProperty talle;
    	StringProperty color;
    	StringProperty cantidad;
    	
    	public ItemPedTabla(String nombreProducto, String tipoProducto, String talle, String color, String cantidad){
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
