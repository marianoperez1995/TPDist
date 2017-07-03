package application;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import application.ClientesPendientesController.ClienteTabla;
import businessDelegate.BusinessDelegate;
import dto.InsumoDTO;
import dto.PrendaDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class PrendaAltaController implements Initializable {
	
	@FXML
    private JFXButton btnEnviar;

    @FXML
    private JFXTreeTableView<PrendaTabla> vistaTabla;

    @FXML
    private JFXButton btnLimpiar;

    @FXML
    private JFXSlider sliderGanancia;

    @FXML
    private JFXComboBox<Label> comboTalle;

    @FXML
    private JFXComboBox<Label> comboInsumo1;
    
    @FXML
    private JFXComboBox<Label> comboInsumo2;
    
    @FXML
    private JFXComboBox<Label> comboInsumo3;
    
    @FXML
    private JFXComboBox<Label> comboEstado;

    @FXML
    private StackPane stackPane;

    @FXML
    private JFXTextField txtPrecio;

    @FXML
    private JFXTextField txtNombre;

    @FXML
    private Label lblFechaRegistro;

    @FXML
    private JFXTextField txtCostoProdActual;

    @FXML
    private JFXTextField txtCantidad;

    @FXML
    private JFXTextField txtCosto;

    @FXML
    private JFXTextField txtColor;

    @FXML
    private JFXTextField txtStockMin;

    JFXTreeTableColumn<PrendaTabla, String> descripcionCol;
    JFXTreeTableColumn<PrendaTabla, String> colorCol;
    JFXTreeTableColumn<PrendaTabla, String> talleCol;
    
    @SuppressWarnings("unchecked")
	@Override
    public void initialize (URL url, ResourceBundle rb){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    	lblFechaRegistro.setText("Fecha: " + df.format(Calendar.getInstance().getTime()));
    	
    	ArrayList<String> listaInsumos = null;
		try {
			listaInsumos = buscarInsumos();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
    	for(String insumo : listaInsumos){
        	comboInsumo1.getItems().add(new Label(insumo));
        	comboInsumo2.getItems().add(new Label(insumo));
        	comboInsumo3.getItems().add(new Label(insumo));
    	}

    	comboInsumo1.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });
    	
    	comboInsumo2.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });
    	
    	comboInsumo3.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });
    	
    	comboTalle.getItems().add(new Label("S"));
    	comboTalle.getItems().add(new Label("M"));
    	comboTalle.getItems().add(new Label("L"));
    	comboTalle.getItems().add(new Label("XL"));
    	comboTalle.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });
    	
    	comboEstado.getItems().add(new Label("Discontinuo"));
    	comboEstado.getItems().add(new Label("En producción"));
    	comboEstado.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }

            @Override
            public Label fromString(String string) {
                return new Label(string);
            }
        });	
    	
    	txtCosto.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                	txtCosto.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
    	txtCostoProdActual.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                	txtCostoProdActual.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        
    	txtCantidad.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                	txtCantidad.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    	
    	txtStockMin.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                	txtStockMin.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    	
    	
    	descripcionCol = new JFXTreeTableColumn<>("Descripcion");
    	descripcionCol.setPrefWidth(130);
    	descripcionCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PrendaTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PrendaTabla, String> param) {
				return param.getValue().getValue().descripcion;
			}
		});
    	
    	colorCol = new JFXTreeTableColumn<>("Color");
    	colorCol.setPrefWidth(130);
    	colorCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PrendaTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PrendaTabla, String> param) {
				return param.getValue().getValue().color;
			}
		});
    	
    	talleCol = new JFXTreeTableColumn<>("Talle");
    	talleCol.setPrefWidth(130);
    	talleCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<PrendaTabla,String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<PrendaTabla, String> param) {
				return param.getValue().getValue().talle;
			}
		});
    	
    	colorCol.setResizable(false);
    	talleCol.setResizable(false);
    	descripcionCol.setResizable(false);
    	
    	colorCol.impl_setReorderable(false);
    	talleCol.impl_setReorderable(false);
    	descripcionCol.impl_setReorderable(false);
    	
    	vistaTabla.setPlaceholder(new Label("No hay prendas con esa descripcion"));
    	
    	ObservableList<PrendaTabla> clientes = FXCollections.observableArrayList();
    	
    	final TreeItem<PrendaTabla> root = new RecursiveTreeItem<PrendaTabla>(clientes, RecursiveTreeObject::getChildren);
    	vistaTabla.getColumns().setAll(descripcionCol, colorCol, talleCol);
    	vistaTabla.setRoot(root);
    	vistaTabla.setShowRoot(false);
    	
        sliderGanancia.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
            	if(!txtCostoProdActual.getText().equalsIgnoreCase("")){
            	float costo = Float.parseFloat(txtCostoProdActual.getText());
            	float ganancia = Float.parseFloat("1."+Integer.toString(new_val.intValue()));
            	float precio = costo*ganancia;
            	
                txtPrecio.setText(Float.toString(precio));
            	}
            }
        });
        
        txtNombre.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue,
					String newValue) {
				if(txtNombre.getText().length()>=4){
			    	ObservableList<PrendaTabla> prendas = FXCollections.observableArrayList();
					PrendaDTO prenda = new PrendaDTO();
					prenda.setDescripcion(txtNombre.getText());
					try {
						for(PrendaDTO p : BusinessDelegate.getInstancia().buscarPrendaPorNombre(prenda)){
							prendas.add(new PrendaTabla(p.getDescripcion(), p.getColor(), p.getTalle()));
						}
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			    	final TreeItem<PrendaTabla> root = new RecursiveTreeItem<PrendaTabla>(prendas, RecursiveTreeObject::getChildren);
			    	vistaTabla.getColumns().setAll(descripcionCol, colorCol, talleCol);
			    	vistaTabla.setRoot(root);
			    	vistaTabla.setShowRoot(false);
				}
				
			}
		});
        
    }
    
    @FXML
    void agregarPrenda(ActionEvent event) {
    	JFXDialogLayout content = new JFXDialogLayout();
    	Text titulo = new Text();
    	Text mensaje = new Text();
    	titulo.setFont(Font.font ("Verdana", 16));
    	content.setHeading(titulo);
    	JFXButton botOk = new JFXButton("OK");
    	JFXDialog dialog = new JFXDialog(stackPane, content, JFXDialog.DialogTransition.TOP);
    	botOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				dialog.close();
				btnLimpiar.setDisable(false);
	        	btnEnviar.setDisable(false);
			}
		});
    	content.setActions(botOk);
    	
    	
    	if(!todoCompletado()){
    		titulo.setText("Error");
    		mensaje.setText("Debe completar todos los campos\n" + "para agregar una nueva prenda");
        	content.setBody(mensaje);
        	content.setHeading(titulo);
        	btnLimpiar.setDisable(true);
        	btnEnviar.setDisable(true);
        	
        	dialog.show();
    	}else{
	    	PrendaDTO prenda = new PrendaDTO();
	    	InsumoDTO insumo1 = new InsumoDTO();
	    	InsumoDTO insumo2 = new InsumoDTO();
	    	InsumoDTO insumo3 = new InsumoDTO();
	    	
	    	boolean estado;
	    	if(comboEstado.getValue().getText().equalsIgnoreCase("Discontinuo")){
	    		estado = false;
	    	}else{
	    		estado = true;
	    	}
	    	prenda.setDescripcion(txtNombre.getText());
	    	prenda.setColor(txtColor.getText());
	    	prenda.setTalle(comboTalle.getValue().getText());
	    	prenda.setCostoProduccionActual(Float.parseFloat(txtCosto.getText()));
	    	prenda.setCostoProduccionReal(Float.parseFloat(txtCostoProdActual.getText()));
	    	Double d = sliderGanancia.getValue();
	    	prenda.setPorcentajeGanancia(Float.parseFloat("0."+d.intValue()));
	    	prenda.setPrecio(Float.parseFloat(txtPrecio.getText()));
	    	prenda.setEstadoProduccion(estado);
	    	prenda.setCantidadAConfeccionar(Integer.parseInt(txtCantidad.getText()));
	    	prenda.setStockMinimo(Integer.parseInt(txtStockMin.getText()));
	    	prenda.setStockActual(0);
	    	
	    	insumo1.setNombre(comboInsumo1.getValue().getText());
	    	insumo2.setNombre(comboInsumo2.getValue().getText());
	    	insumo3.setNombre(comboInsumo3.getValue().getText());
	    	
	    	try {
	    		insumo1 = BusinessDelegate.getInstancia().buscarInsumo(insumo1);
	    		insumo2 = BusinessDelegate.getInstancia().buscarInsumo(insumo2);
	    		insumo3 = BusinessDelegate.getInstancia().buscarInsumo(insumo3);
				BusinessDelegate.getInstancia().altaPrenda(prenda);
				limpiarCampos();
				titulo.setText("Exito en la operación");
	    		mensaje.setText("La prenda fue agregada correctamente");
	        	content.setHeading(titulo);
	    		content.setBody(mensaje);
	        	btnLimpiar.setDisable(true);
	        	btnEnviar.setDisable(true);
	        	dialog.show();
				} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    }
    
    private ArrayList<String> buscarInsumos() throws RemoteException {
    	ArrayList<String> resultado = new ArrayList<String>();
    	
    	
    	ArrayList<InsumoDTO> insumos = BusinessDelegate.getInstancia().buscarInsumos();
    	
    	for(InsumoDTO ins : insumos){
    		resultado.add(ins.getNombre());
    	}
    	return resultado;
    }
    
    private boolean todoCompletado() {
    	if(txtNombre.getText().isEmpty() || txtCosto.getText().isEmpty() || txtCostoProdActual.getText().isEmpty() || txtCantidad.getText().isEmpty() || txtStockMin.getText().isEmpty())
    		return false;
    	else
    		return true;
	}
    
	@FXML
    private void limpiarCampos(ActionEvent event) throws IOException {
        JFXButton btn = (JFXButton) event.getSource();
        System.out.println(btn.getText());
        

    }
	
    private void limpiarCampos() {        

    }
    
    class PrendaTabla extends RecursiveTreeObject<PrendaTabla>{
    	StringProperty descripcion;
    	StringProperty color;
    	StringProperty talle;
    
		public PrendaTabla(String descripcion, String color, String talle){
    		this.descripcion = new SimpleStringProperty(descripcion);
    		this.color = new SimpleStringProperty(color);
    		this.talle = new SimpleStringProperty(talle);
    	}

		public StringProperty getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(StringProperty descripcion) {
			this.descripcion = descripcion;
		}

		public StringProperty getColor() {
			return color;
		}

		public void setColor(StringProperty color) {
			this.color = color;
		}

		public StringProperty getTalle() {
			return talle;
		}

		public void setTalle(StringProperty talle) {
			this.talle = talle;
		}
    	
    }
}
