import Scenes.MainScene;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Stage mainStage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mainScene2.fxml"));
        Parent root = loader.load();
        Scene mainScene = new Scene(root,350,350);
        stage.setTitle("Dice Forge");
        stage.setScene(mainScene);
        stage.sizeToScene();
        stage.show();

        MainScene.mainStage = stage;

    }

    public static void main(String[] args){
        launch(args);
    }
}
