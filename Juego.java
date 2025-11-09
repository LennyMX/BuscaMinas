package juego;
import java.util.Random;

public class Juego {

    private int filas, columnas, minas;
    private Casilla[][] tablero;
    private int casillasDescubiertas = 0;

    public Juego(int filas, int columnas, int minas) {
        this.filas = filas;
        this.columnas = columnas;
        this.minas = minas;

        tablero = new Casilla[filas][columnas];
        for (int f = 0; f < filas; f++)
            for (int c = 0; c < columnas; c++)
                tablero[f][c] = new Casilla(f, c);

        colocarMinas();
        calcularMinasVecinas();
    }

    private void colocarMinas() {
        Random r = new Random();
        int colocadas = 0;

        while (colocadas < minas) {
            int f = r.nextInt(filas);
            int c = r.nextInt(columnas);

            if (!tablero[f][c].isMina()) {
                tablero[f][c].setMina(true);
                colocadas++;
            }
        }
    }

    private void calcularMinasVecinas() {
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                if (!tablero[f][c].isMina()) {
                    tablero[f][c].setMinasAdyacentes(contarMinasVecinas(f, c));
                }
            }
        }
    }

    private int contarMinasVecinas(int fila, int col) {
        int contador = 0;

        int[] dx = {-1,-1,-1, 0,0, 1,1,1};
        int[] dy = {-1, 0, 1,-1,1,-1,0,1};

        for (int i = 0; i < 8; i++) {
            int nf = fila + dx[i];
            int nc = col + dy[i];

            if (nf >= 0 && nf < filas && nc >= 0 && nc < columnas) {
                if (tablero[nf][nc].isMina()) contador++;
            }
        }
        return contador;
    }

    public boolean descubrirCasilla(int f, int c) {
        Casilla cas = tablero[f][c];

        if (cas.isDescubierta()) return true;
        cas.setDescubierta(true);

        if (cas.isMina()) return false;

        casillasDescubiertas++;
        return true;
    }

    public boolean jugadorGana() {
        return casillasDescubiertas == (filas * columnas - minas);
    }

    public Casilla[][] getTablero() { return tablero; }
}
