package juego;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Tablero tablero;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        tablero = new Tablero(5, 5, 5); // filas, columnas, minas
        root.setCenter(tablero.getGrid());

        Button reiniciar = new Button("Reiniciar");
        reiniciar.setOnAction(e -> resetGame(5,5,3));

        BorderPane.setAlignment(reiniciar, Pos.CENTER);
        root.setBottom(reiniciar);

        Scene scene = new Scene(root, 350, 380);
        primaryStage.setTitle("Mini-Buscaminas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void resetGame(int filas, int columnas, int minas) {
        tablero = new Tablero(filas, columnas, minas);
        root.setCenter(tablero.getGrid());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
