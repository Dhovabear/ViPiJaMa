import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class Plateau {

    @FXML
    private Canvas canva;


    public void updatePlateau(ActionEvent actionEvent) {
        GraphicsContext g = canva.getGraphicsContext2D();
        g.setFill(Color.WHITE);
        g.fillRect(0,0,canva.getWidth(),canva.getHeight());
        Image img = new Image(getClass().getResourceAsStream("Images/plateau2.png"));
        g.drawImage(img,20,80);
    }
}
