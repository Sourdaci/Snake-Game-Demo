import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;
/**
 * Write a description of class SnakeGameDemo here.
 * 
 * @author Sourdaci
 * @version (a version number or a date)
 */
public class SnakeGameDemo
{
    private Snake gameDemo;

    /**
     * Crea un juego Snake para pruebas
     */
    public SnakeGameDemo()
    {
        gameDemo = new Snake();
    }
    
    /**
     * Inicia la partida de prueba
     */
    public void drawSnake(){
        gameDemo.drawSnake();
    }
    
    /**
     * Hace crecer 1 segmento la serpiente de prueba
     */
    public void makeSnakeBigger(){
        gameDemo.makeSnakeBigger();
    }
    
    /**
     * Hace crecer varios segmentos la serpiente de prueba
     * 
     * @param veces La cantidad de segmentos que debe crecer la serpiente de prueba
     */
    public void makeSnakeBigger(int veces){
        gameDemo.makeSnakeBigger(veces);
    }
    
    /**
     * Hace moverse 1 vez a la serpiente de prueba
     */
    public void animateSnake(){
        gameDemo.animateSnake();
    }
}
