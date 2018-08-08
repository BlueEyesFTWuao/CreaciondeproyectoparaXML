/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creacionarchivoxml;

import Modelo.Empleado;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author jose.bueno
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label lAgregar;
    @FXML
    private Label direccion;
    @FXML
    private Label ledad;
    @FXML
    private Label lcodigo;
    @FXML
    private Label ldepartamento;
    @FXML
    private TextField txagregar;
    @FXML
    private TextField txdireccion;
    @FXML
    private TextField txedad;
    @FXML
    private TextField txcodigo;
    @FXML
    private TextField txdepartamento;
    @FXML
    private Button btagregar;
    @FXML
    private Button btguardar;

    LinkedList<Empleado> listaEmpleados;

    @FXML
    private void btagregar(ActionEvent event) {
        String nombre = txagregar.getText();
        String direcion = txdireccion.getText();
        String Edad = txedad.getText();
        String departamento = txdepartamento.getText();
        String codigo = txcodigo.getText();

        Empleado objE = new Empleado(codigo, nombre, Edad, direcion, departamento);
        listaEmpleados.add(objE);

    }

    @FXML
    private void btguardar(ActionEvent event) {
        Empleado objE= new Empleado();
        boolean guardar=objE.crearFileXML(listaEmpleados);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaEmpleados = new LinkedList<>();
    }

}
