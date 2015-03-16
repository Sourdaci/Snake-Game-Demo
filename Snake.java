import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.awt.Color;
/**
 * Write a description of class Snake here.
 * 
 * @author Sourdaci
 * @version (a version number or a date)
 */
public class Snake
{
    // instance variables - replace the example below with your own
    private Canvas pantalla;
    private Pen serpiente;
    private Random aleatorio;
    private ArrayList<SnakePosition> posiciones;
    private static int INICIO_X = 200, INICIO_Y = 200;
    private static final int TRAZO = 20;
    private static final int[] GIRO = {-90, 0, 90, 180};

    /**
     * Constructor for objects of class SnakeGameDemo
     */
    public Snake(int alto, int ancho, Canvas gameCanvas)
    {
        aleatorio = new Random();
        INICIO_X = alto / 2;
        INICIO_Y = ancho / 2;
        pantalla = gameCanvas;
        serpiente = new Pen(INICIO_X, INICIO_Y, pantalla);
        posiciones = new ArrayList<SnakePosition>();
        posiciones.add(new SnakePosition(INICIO_X, INICIO_Y));
        serpiente.turn(GIRO[aleatorio.nextInt(GIRO.length)]);
    }
    
    /**
     * Dibuja la serpiente inicial de 3 segmentos
     * Es inicio de partida, reinicia la pantalla y la serpiente
     */
    public void drawSnake(){
        int contador = 0;
        do{
            int rotar = aleatorio.nextInt(GIRO.length - 1);
            serpiente.turn(GIRO[rotar]);
            serpiente.move(TRAZO);
            posiciones.add(new SnakePosition(serpiente.getPositionX(), serpiente.getPositionY()));
            contador++;
        }while (contador < 3);
    }
    
    /**
     * Dibuja otro segmento de la serpiente
     */
    public void makeSnakeBigger(){
        if(posiciones.size() > 1){
            ArrayList<Integer> giroTemp = new ArrayList<Integer>();
            boolean dibujado = false;
            SnakePosition ultima = posiciones.get(posiciones.size() - 1);
            for (int i = 0; i< GIRO.length - 1; i++){
                giroTemp.add(GIRO[i]);
            }
            do{
                int nuevoGiro = aleatorio.nextInt(giroTemp.size());
                serpiente.penUp();
                serpiente.turn(giroTemp.get(nuevoGiro));
                serpiente.move(TRAZO);
                int posX = serpiente.getPositionX();
                int posY = serpiente.getPositionY();
                boolean colision = false;
                for (int ind = 0; ind < posiciones.size() && !colision; ind++){
                    SnakePosition temporal = posiciones.get(ind);
                    if(temporal.getPosX() == posX && temporal.getPosY() == posY 
                    || posX <= 0 || posY <= 0 || posX >= (INICIO_X * 2) || posY >= (INICIO_Y * 2)){
                        colision = true;
                    }
                }
                serpiente.moveTo(ultima.getPosX(), ultima.getPosY());
                serpiente.penDown();
                if(!colision){
                    serpiente.move(TRAZO);
                    int x = serpiente.getPositionX();
                    int y = serpiente.getPositionY();
                    posiciones.add(new SnakePosition(x, y));
                    dibujado = true;
                }else{
                    int corregir = giroTemp.get(nuevoGiro);
                    serpiente.turn( -corregir);
                    giroTemp.remove(nuevoGiro);
                }
            }while(giroTemp.size() > 0 && !dibujado);
            if(!dibujado){
                System.out.println("No quedan movimientos, juego acabado.");
            }
        }
    }
    
    /**
     * Dibuja varios fragmentos de Serpiente
     * El numero debe ser mayor de 0, o no hara nada
     * 
     * @param cantidad El numero de trazos de serpiente a dibujar
     */
    public void makeSnakeBigger(int cantidad){
        if(cantidad > 0){
            for(int i=0; i < cantidad; i++){
                makeSnakeBigger();
            }
        }
    }
    
    /**
     * Mueve la serpiente por la pantalla
     * Si no pudiera moverse, informa de ello en el juego
     */
    public void animateSnake(){
        if(posiciones.size() > 1){
            ArrayList<Integer> giroTemp = new ArrayList<Integer>();
            boolean dibujado = false;
            SnakePosition ultima = posiciones.get(posiciones.size() - 1);
            for (int i = 0; i< GIRO.length - 1; i++){
                giroTemp.add(GIRO[i]);
            }
            do{
                int nuevoGiro = aleatorio.nextInt(giroTemp.size());
                serpiente.penUp();
                serpiente.turn(giroTemp.get(nuevoGiro));
                serpiente.move(TRAZO);
                int posX = serpiente.getPositionX();
                int posY = serpiente.getPositionY();
                boolean colision = false;
                for (int ind = 0; ind < posiciones.size() && !colision; ind++){
                    SnakePosition temporal = posiciones.get(ind);
                    if(temporal.getPosX() == posX && temporal.getPosY() == posY 
                    || posX <= 0 || posY <= 0 || posX >= (INICIO_X * 2) || posY >= (INICIO_Y * 2)){
                        colision = true;
                    }
                }
                serpiente.moveTo(ultima.getPosX(), ultima.getPosY());
                serpiente.penDown();
                if(!colision){
                    serpiente.move(TRAZO);
                    int x = serpiente.getPositionX();
                    int y = serpiente.getPositionY();
                    posiciones.add(new SnakePosition(x, y));
                    Iterator<SnakePosition> iterador = posiciones.iterator();
                    SnakePosition posTemporal = iterador.next();
                    iterador.remove();
                    serpiente.penUp();
                    serpiente.moveTo(posTemporal.getPosX(), posTemporal.getPosY());
                    serpiente.penDown();
                    posTemporal = iterador.next();
                    serpiente.makeColorAsCanvasBackgroundColor();
                    serpiente.moveTo(posTemporal.getPosX(), posTemporal.getPosY());
                    serpiente.setColor(Color.BLACK);
                    while (iterador.hasNext()){
                        posTemporal = iterador.next();
                        serpiente.moveTo(posTemporal.getPosX(), posTemporal.getPosY());
                    }
                    dibujado = true;
                }else{
                    int corregir = giroTemp.get(nuevoGiro);
                    serpiente.turn( -corregir);
                    giroTemp.remove(nuevoGiro);
                }
            }while(giroTemp.size() > 0 && !dibujado);
            if(!dibujado){
                pantalla.setForegroundColor(Color.YELLOW);
                pantalla.fillRectangle((INICIO_X / 2), (INICIO_Y / 2), INICIO_X, INICIO_Y);
                pantalla.setForegroundColor(Color.BLACK);
                pantalla.drawString("Game Over, dude!!!", (int) (INICIO_X * 0.75), INICIO_Y);
            }
        }
    }
}
