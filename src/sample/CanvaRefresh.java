package sample;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class CanvaRefresh implements EventHandler<MouseEvent> {


    @Override
    public void handle(MouseEvent mouseEvent) {
        Canvas c = (Canvas) mouseEvent.getSource();
        c.getGraphicsContext2D().setFill(Color.BISQUE);
        c.getGraphicsContext2D().fillRect(0,0,c.getHeight(),c.getWidth());
    }
}
