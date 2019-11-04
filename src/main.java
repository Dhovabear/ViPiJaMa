import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainScene2.fxml"));
        Parent root = loader.load();
        Scene mainScene = new Scene(root,300,275);
        stage.setTitle("Dice Forge");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
