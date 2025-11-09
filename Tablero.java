package juego;

import javafx.scene.layout.GridPane;

public class Tablero {

    private GridPane grid;
    private Juego juego;

    public Tablero(int filas, int columnas, int minas) {
        grid = new GridPane();
        juego = new Juego(filas, columnas, minas);

        Casilla[][] tab = juego.getTablero();

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                Casilla cas = tab[f][c];
                grid.add(cas.getBoton(), c, f);

                cas.getBoton().setOnAction(e -> manejarClick(cas));
            }
        }
    }

    private void manejarClick(Casilla cas) {
        boolean ok = juego.descubrirCasilla(cas.getFila(), cas.getColumna());

        if (!ok) {
            cas.getBoton().setText("*");
            cas.getBoton().setStyle("-fx-background-color: red;");
            revelarMinas();
            deshabilitarTablero();
        } else {
            int n = cas.getMinasAdyacentes();
            cas.getBoton().setText(n == 0 ? "" : String.valueOf(n));
            cas.getBoton().setDisable(true);

            if (juego.jugadorGana()) {
                revelarMinas();
                deshabilitarTablero();
            }
        }
    }

    private void revelarMinas() {
        for (Casilla[] fila : juego.getTablero()) {
            for (Casilla c : fila) {
                if (c.isMina()) c.getBoton().setText("💣");
            }
        }
    }

    private void deshabilitarTablero() {
        for (Casilla[] fila : juego.getTablero())
            for (Casilla c : fila)
                c.getBoton().setDisable(true);
    }

    public GridPane getGrid() { return grid; }
}
