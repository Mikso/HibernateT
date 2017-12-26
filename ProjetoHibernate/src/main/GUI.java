/**
 * 
 */
package main;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Bruno
 *
 */
public class GUI extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * (non-Javadoc)
	 * PARA FAZER ESTES TESTES USE:
	 * https://www.youtube.com/watch?v=QyTs25ECIiY
	 * 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root, 300, 300);

		Label lblNome = new Label("Nome");
		lblNome.setLayoutX(20);
		lblNome.setLayoutY(20);

		Label lblTipo = new Label("Tipo");
		lblTipo.setLayoutX(20);
		lblTipo.setLayoutY(100);

		TextField txtNome = new TextField();
		txtNome.setLayoutX(20);
		txtNome.setLayoutY(50);
		txtNome.setPrefWidth(100);

		TextField txtTipo = new TextField();
		txtTipo.setLayoutX(20);
		txtTipo.setLayoutY(130);
		txtTipo.setPrefWidth(100);

		Button btnEnviar = new Button("Enviar");
		btnEnviar.setLayoutX(200);
		btnEnviar.setLayoutY(200);
		btnEnviar.setPrefWidth(100);

		// Events
		btnEnviar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Cliente cliente = new Cliente();
				cliente.setNome(txtNome.getText());
				cliente.setTipo(txtTipo.getText());
				ClienteJpaDAO.getInstance().merge(cliente);
				txtNome.setText("");
				txtTipo.setText("");
				JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
			}
		});

		root.getChildren().addAll(lblNome, lblTipo, txtNome, txtTipo, btnEnviar);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Validar");
		primaryStage.show();
	}
}
