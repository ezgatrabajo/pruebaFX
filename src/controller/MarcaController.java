package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.json.JSONObject;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MarcaController {

    @FXML
    private Button btnGuardar;

    @FXML
    private Label lblErrores;

    @FXML
    private Button btnVolver;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextArea txtDescripcion;



    public void onClickGuardar(MouseEvent mouseEvent) throws IOException {
        String valores = txtId.getText() + " - " + txtNombre.getText() + " - " + txtDescripcion.getText();
        System.out.println("Click Guardar "+ valores);
        JSONObject json = new JSONObject();
        json.put("nombre", txtNombre.getText());
        json.put("descripcion", txtDescripcion.getText());
        if (validate()){

            try {
                URL url = null;
                url = new URL("http://localhost:8050/api/marcas/");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setUseCaches(false);
                conn.setDoInput(true);
                conn.setRequestProperty("Content-type","application/json");
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(json.toString());
                wr.flush();
                wr.close();
                conn.getInputStream();

                if (conn.getResponseCode()==200 ){
                    lblErrores.setVisible(true);
                    lblErrores.setText("Registrado Correctamente");
                }
                String message = conn.getResponseMessage();

                System.out.println(message);

                //BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                try(BufferedReader br = new BufferedReader(
                        new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while ((responseLine = br.readLine()) != null) {
                        response.append(responseLine.trim());
                    }
                    System.out.println(response.toString());
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


        }

    }
    private boolean validate(){

        if (txtNombre.getText().length() == 0){
            //System.out.println("Nombre obligatorio");
            lblErrores.setText("Nombre obligatorio");
            txtNombre.requestFocus();
            return false;
        }
        if (txtDescripcion.getText().length() == 0){

            lblErrores.setText("Descripcion obligatorio");
            txtDescripcion.requestFocus();
            return false;
        }
        return true;
    }

    public void onClickEliminar(MouseEvent mouseEvent) {
        System.out.println("Click Eliminar");
    }

    public void onClickVolver(MouseEvent mouseEvent) {
        //ScreenImpl.getInstance().switchScene("ABM Marcas", ScreenImpl.getInstance().VG_MARCAS);
        //((Node)(mouseEvent.getSource())).getScene().getWindow().hide();
        //ScreenImpl.getInstance().switchScene("Principal", ScreenImpl.getInstance().VG_SAMPLE);
    }
}
