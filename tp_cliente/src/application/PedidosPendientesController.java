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

public class PedidosPendientesController implements Initializable{

	@FXML
    private Label txtFechaPago;

    @FXML
    private JFXButton btnEnviar;

    @FXML
    private JFXButton btnLimpiar;
    
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
    private Label lblTotal;

    @FXML
    private JFXTreeTableView<ItemPedTabla> vistaTabla2;

    @FXML
    private Label txtEstado;

    @FXML
    private Label txtRazonSocial;
    
    JFXTreeTableColumn<PedidoTabla, String> idPedidoCol;
    JFXTreeTableColumn<PedidoTabla, String> razonSocialCol;
    JFXTreeTableColumn<PedidoTabla, String> estadoCol;
    JFXTreeTableColumn<PedidoTabla, String> fechaGeneracionCol;
    JFXTreeTableColumn<ItemPedTabla, String> cantidadCol;
    JFXTreeTableColumn<ItemPedTabla, String> colorCol;
    JFXTreeTableColumn<ItemPedTabla, String> talleCol;
    JFXTreeTableColumn<ItemPedTabla, String> tipoProductoCol;
    JFXTreeTableColumn<ItemPedTabla, String> nombreProductoCol;
    
    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
    	
    	idPedidoCol = new JFXTreeTableColumn<>("Pedido");
    	idPedidoCol.setPrefWidth(170);
    	idPedidoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PedidoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PedidoTabla, String> param) {
				return param.getValue().getValue().idPedido;
			}
		});
    	
    	razonSocialCol = new JFXTreeTableColumn<>("Razon Social");
    	razonSocialCol.setPrefWidth(137);
    	razonSocialCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PedidoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PedidoTabla, String> param) {
				return param.getValue().getValue().razonSocial;
			}
		});
    	
    	estadoCol = new JFXTreeTableColumn<>("Estado");
    	estadoCol.setPrefWidth(135);
    	estadoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PedidoTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PedidoTabla, String> param) {
				return param.getValue().getValue().estado;
			}
		});
    	
    	fechaGeneracionCol = new JFXTreeTableColumn<>("Fecha de pedido");
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
    	
    	nombreProductoCol = new JFXTreeTableColumn<>("Producto");
    	nombreProductoCol.setPrefWidth(190);
    	nombreProductoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedTabla, String> param) {
				return param.getValue().getValue().nombreProducto;
			}
		});
    	
    	tipoProductoCol = new JFXTreeTableColumn<>("Tipo");
    	tipoProductoCol.setPrefWidth(110);
    	tipoProductoCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<ItemPedTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<ItemPedTabla, String> param) {
				return param.getValue().getValue().tipoProducto;
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
    	for(PedidoTabla p: buscarPedidos()){
    		pedidos.add(p);
    	}
    	
    	if (pedidos.size()==1){
    		btnLimpiar.setDisable(true);
    	}
    	
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
	    		float total;
		        //Check whether item is selected and set value of selected item to Label
		        if(vistaTabla.getSelectionModel().getSelectedItem() != null) 
		        {
		        	TreeTableViewSelectionModel<PedidoTabla> selectionModel = vistaTabla.getSelectionModel();
				    ObservableList selectedCells = selectionModel.getSelectedCells();
				    TreeTablePosition tablePosition = (TreeTablePosition) selectedCells.get(0);
				    TreeItem<PedidoTabla> selectedRow = vistaTabla.getTreeItem(tablePosition.getRow());
		            total = 0;
		            itemsPedido.clear();
		            
		            seleccionado.setIdPedidoCliente(Integer.parseInt(selectedRow.getValue().getIdPedido().getValue()));
		            try {
		            	seleccionado = BusinessDelegate.getInstancia().buscarPedido(seleccionado);
		            } catch (RemoteException e) {
		            	// TODO Auto-generated catch block
		            	e.printStackTrace();
		            }
    	     	           
				    txtIdCliente.setText("ID"+Integer.toString(seleccionado.getCliente().getNumeroCliente()));
				    lblPedido.setText("PEDIDO " + Integer.toString(seleccionado.getIdPedidoCliente()));
				    txtRazonSocial.setText(seleccionado.getCliente().getNombre());
				    txtCuit.setText(seleccionado.getCliente().getCuit());
				    txtTel.setText(seleccionado.getCliente().getTelefono());
				    txtLimiteCred.setText(Float.toString(seleccionado.getCliente().getCuentaCorriente().getLimite()));
				    txtFechaPago.setText(seleccionado.getCliente().getCuentaCorriente().getFecha());
				    txtBalance.setText(Float.toString(seleccionado.getCliente().getCuentaCorriente().getBalanceActual()));
				    try {
						txtEstado.setText(BusinessDelegate.getInstancia().verificarPedido(seleccionado));
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				    if(txtEstado.getText().equalsIgnoreCase("Desaprobado")){
				    	btnEnviar.setDisable(true);
				    	btnCancelar.setDisable(false);
				    }else{
				    	btnCancelar.setDisable(true);
				    	btnEnviar.setDisable(false);
				    }
				    
				    for(ItemPedidoClienteDTO c : seleccionado.getItemsPedidoCliente()){
				    	total = total + c.getPrecio();
				    	String estado;
				    	if(c.getPrenda().isEstadoProduccion()){
				    		estado = "Producción";
				    	}else{
				    		estado = "Discontinuo";
				    	}
				    	
				    	itemsPedido.add(new ItemPedTabla(c.getPrenda().getDescripcion(), estado, c.getPrenda().getTalle(), c.getPrenda().getColor(), Integer.toString(c.getCantidad())));
				    }
				    lblTotal.setText(Float.toString(total));
				    final TreeItem<ItemPedTabla> root2 = new RecursiveTreeItem<ItemPedTabla>(itemsPedido, RecursiveTreeObject::getChildren);
				    vistaTabla2.getColumns().setAll(nombreProductoCol,tipoProductoCol,talleCol,colorCol,cantidadCol);
				    vistaTabla2.setRoot(root2);
				    vistaTabla2.setShowRoot(false);
				    
			    	if (pedidos.size()==1){
			    		btnLimpiar.setDisable(true);
			    	}else{
    	       		btnLimpiar.setDisable(false);
			    	}
    	        }
	         }
    	     });
    }
    
    @FXML
    void limpiarCampos(ActionEvent event) {
	    txtIdCliente.setText("ID");
	    txtRazonSocial.setText("");
	    txtCuit.setText("");
	    txtTel.setText("");
	    txtLimiteCred.setText("");
	    txtFechaPago.setText("");
	    txtBalance.setText("");
	    txtEstado.setText("--");
	    lblTotal.setText("--");
	    lblPedido.setText("PEDIDO");
	    
    	ObservableList<ItemPedTabla> itemsPedido = FXCollections.observableArrayList();
	    final TreeItem<ItemPedTabla> root2 = new RecursiveTreeItem<ItemPedTabla>(itemsPedido, RecursiveTreeObject::getChildren);
	    vistaTabla2.getColumns().setAll(nombreProductoCol,tipoProductoCol,talleCol,colorCol,cantidadCol);
	    vistaTabla2.setRoot(root2);
	    vistaTabla2.setShowRoot(false);
	    
   		btnCancelar.setDisable(true);
   		btnEnviar.setDisable(true);
   		btnLimpiar.setDisable(true);
    }
    
    void limpiarC(){
	    txtIdCliente.setText("ID");
	    txtRazonSocial.setText("");
	    txtCuit.setText("");
	    txtTel.setText("");
	    txtLimiteCred.setText("");
	    txtFechaPago.setText("");
	    txtBalance.setText("");
	    txtEstado.setText("--");
	    lblTotal.setText("--");
	    lblPedido.setText("PEDIDO");
	    
    	ObservableList<ItemPedTabla> itemsPedido = FXCollections.observableArrayList();
	    final TreeItem<ItemPedTabla> root2 = new RecursiveTreeItem<ItemPedTabla>(itemsPedido, RecursiveTreeObject::getChildren);
	    vistaTabla2.getColumns().setAll(nombreProductoCol,tipoProductoCol,talleCol,colorCol,cantidadCol);
	    vistaTabla2.setRoot(root2);
	    vistaTabla2.setShowRoot(false);
	    
   		btnCancelar.setDisable(true);
   		btnEnviar.setDisable(true);
   		btnLimpiar.setDisable(true);
    }
    
    @FXML
    void rechazarPedido(ActionEvent event) {
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
            	seleccionado.setEstado("Rechazado");
            	BusinessDelegate.getInstancia().modificarPedidoCliente(seleccionado);
            } catch (RemoteException e) {
            	// TODO Auto-generated catch block
            	e.printStackTrace();
            }
        }
        
    	ObservableList<PedidoTabla> pedidos = FXCollections.observableArrayList();
    	//agregar pedidos a la tabla
    	for(PedidoTabla p: buscarPedidos()){
    		pedidos.add(p);
    	}
    	
    	if (pedidos.size()==1){
    		btnLimpiar.setDisable(true);
    	}
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<PedidoTabla> root = new RecursiveTreeItem<PedidoTabla>(pedidos, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(idPedidoCol,razonSocialCol,estadoCol,fechaGeneracionCol);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
    	limpiarC();
    }

    @FXML
    void aprobarPedido(ActionEvent event) {
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
            	seleccionado.setEstado("En fabricacion");
            	BusinessDelegate.getInstancia().modificarPedidoCliente(seleccionado);
            } catch (RemoteException e) {
            	// TODO Auto-generated catch block
            	e.printStackTrace();
            }
        }
        
    	ObservableList<PedidoTabla> pedidos = FXCollections.observableArrayList();
    	//agregar pedidos a la tabla
    	for(PedidoTabla p: buscarPedidos()){
    		pedidos.add(p);
    	}
    	
    	if (pedidos.size()==1){
    		btnLimpiar.setDisable(true);
    	}
    	
    	//para manipular los datos de la tabla con el JFoenix se usa RecirsiveTreeItem. RecursiveTreeObject::getChildren Callback para obtener cada cliente de la tabla
    	final TreeItem<PedidoTabla> root = new RecursiveTreeItem<PedidoTabla>(pedidos, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(idPedidoCol,razonSocialCol,estadoCol,fechaGeneracionCol);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
    	limpiarC();
    }
    
    private ArrayList<PedidoTabla> buscarPedidos() {
    	ArrayList<PedidoTabla> resultado = new ArrayList<PedidoTabla>();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		try {
			for(PedidoClienteDTO p : BusinessDelegate.getInstancia().getPedidos()){	
				if(p.getEstado().equalsIgnoreCase("Pendiente")){
					resultado.add(new PedidoTabla(Integer.toString(p.getIdPedidoCliente()), p.getCliente().getNombre(),p.getEstado(),df.format(p.getFechaGeneracion())));
				}
			}
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
