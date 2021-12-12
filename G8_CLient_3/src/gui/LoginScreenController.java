package gui;

import client.ClientController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import logic.Request;
import logic.User;

public class LoginScreenController extends Application {
	public static String role;
	public static User user1;
	@FXML
	private TextField Usertxt;

	@FXML
	private TextField Passtxt;

	@FXML
	private Button Loginbtn;

	@FXML
	private Button exitbtn;

	@FXML
	private Label Forgotbtn;

	@FXML
	private Label errlabel;

	@FXML
	void Forgetpass(MouseEvent event) throws Exception {

		Stage primaryStage = new Stage();
		EmailVerificationController ev = new EmailVerificationController();
		ev.start(primaryStage);
	}

	@FXML
	void ReqLogin(ActionEvent event) throws Exception {
		boolean flag = true;
		if (Usertxt.getText().isEmpty() || Passtxt.getText().isEmpty()) {
			errlabel.setText("You must fill all fields");
		} else {
			User user = new User(Usertxt.getText(), Passtxt.getText());
			ConnectFormController.chat.accept(new Request("Login", user));
			Stage primaryStage = new Stage();
			switch (role) {
			case "CEO":
				CEOScreenController ceo = new CEOScreenController();
				ceo.user = user1;
				ceo.start(primaryStage);
				break;
			case "HR":
				HRMScreenController hrm = new HRMScreenController();
				hrm.user = user1;
				hrm.start(primaryStage);
				break;
			case "BM manager":
				BMScreenController bm = new BMScreenController();
				bm.user = user1;
				bm.start(primaryStage);
				break;
			case "Costumer":
				USERHSController cos = new USERHSController();
				cos.user = user1;
				cos.start(primaryStage);
				break;
			case "Supplier":
				SupplierHSController sup = new SupplierHSController();
				sup.user = user1;
				sup.start(primaryStage);
				break;
			default:
				errlabel.setText(role);
				flag = false;
				break;
			}

			if (flag) {
				((Node) event.getSource()).getScene().getWindow().hide();
			}
		}
	}

	@FXML
	void Exit(ActionEvent event) throws Exception {
		ConnectFormController.chat.accept(new Request("disconnect", null));
		System.out.print(true);
		System.exit(0);

	}

	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		// ((Node)event.getSource()).getScene().getWindow().hide(); //hiding primary
		// window
		// Stage primaryStage = new Stage();
		Pane root = loader.load(getClass().getResource("/gui/LoginScreen.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Log-in");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
