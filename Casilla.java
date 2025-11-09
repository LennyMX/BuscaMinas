import javafx.scene.control.Button;
public class Casilla {
private int fila;
private int columna;
private boolean mina;
private boolean descubierta;
private int minasAdyacentes;
private Button boton;
public Casilla(int fila, int columna) {
this.fila = fila;
this.columna = columna;
boton = new Button(" ");
boton.setPrefSize(50, 50);
}
// Getters y setters
public Button getBoton() { return boton; }
public boolean isMina() { return mina; }
public void setMina(boolean mina) { this.mina = mina; }
public boolean isDescubierta() { return descubierta; }
public void setDescubierta(boolean descubierta) { this.descubierta = descubierta; }
public int getMinasAdyacentes() { return minasAdyacentes; }
public void setMinasAdyacentes(int minasAdyacentes) { this.minasAdyacentes = minasAdyacentes; }
public int getFila() { return fila; }
public int getColumna() { return columna; }
}
