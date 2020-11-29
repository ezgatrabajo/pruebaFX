package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MarcaController {

    @FXML
    private Button btnGuardar;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextArea txtDescripcion;



    public void onClickGuardar(MouseEvent mouseEvent) {
        String valores = txtId.getText() + " - " + txtNombre.getText() + " - " + txtDescripcion.getText();
        System.out.println("Click Guardar "+ valores);
        if (validate()){

        }

    }
    private boolean validate(){
        if (txtNombre.getText().length() == 0){
            System.out.println("Nombre obligatorio");
            txtNombre.requestFocus();
        }
        if (txtDescripcion.getText().length() == 0){
            System.out.println("Descripcion obligatorio");
            txtDescripcion.requestFocus();
        }
        return true;
    }

    public void onClickEliminar(MouseEvent mouseEvent) {
        System.out.println("Click Eliminar");
    }
}
