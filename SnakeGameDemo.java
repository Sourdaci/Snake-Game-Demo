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
    private Snake gameDemoSolo, gameDemoDuo[];
    private ArrayList<Snake> gameDemoMulti;
    private Canvas gameCanvasSolo, gameCanvasDuo, gameCanvasMulti;
    public static final int alto = 400, ancho = 400;
    boolean snakeSolo, snakeDuo, snakeMulti;

    /**
     * Crea un juego Snake para pruebas
     */
    public SnakeGameDemo(){
        snakeSolo = false;
        snakeDuo = false;
        snakeMulti = false;
    }
    
    /**
     * Crea una partida de prueba de UNA snake
     * Si hay partida creada, no hara nada
     */
    public void partidaSnakeSolo(){
        if(!snakeSolo){
            gameCanvasSolo = new Canvas("Snake Demo Solo", alto + 20, ancho);
            gameDemoSolo = new Snake(alto, ancho, gameCanvasSolo);
            snakeSolo = true;
        }
    }
    
    /**
     * Inicia la partida de prueba de UNA snake
     */
    public void drawSnakeSolo(){
        if(snakeSolo){
            gameDemoSolo.drawSnake();
        }
    }
    
    /**
     * Hace crecer 1 segmento la serpiente de prueba de UNA snake
     */
    public void makeSnakeBiggerSolo(){
        if(snakeSolo){
            gameDemoSolo.makeSnakeBigger();
        }
    }
    
    /**
     * Hace crecer varios segmentos la serpiente de prueba de UNA snake
     * 
     * @param veces La cantidad de segmentos que debe crecer la serpiente de prueba
     */
    public void makeSnakeBiggerSolo(int veces){
        if(snakeSolo){
            gameDemoSolo.makeSnakeBigger(veces);
        }
    }
    
    /**
     * Hace moverse 1 vez a la serpiente de prueba de UNA snake
     */
    public void animateSnakeSolo(){
        if(snakeSolo){
            gameDemoSolo.animateSnake();
        }
    }
    
    /**
     * Crea una partida de prueba de DOS snake
     * Si hay partida creada, no hara nada
     */
    public void partidaSnakeDuo(){
        if(!snakeDuo){
            gameCanvasDuo = new Canvas("Snake Demo Duo", alto + 20, ancho);
            gameDemoDuo = new Snake[2];
            gameDemoDuo[0] = new Snake(alto, ancho, gameCanvasDuo);
            gameDemoDuo[1] = new Snake(alto, ancho, gameCanvasDuo);
            snakeDuo = true;
        }
    }
    
    /**
     * Inicia la partida de prueba de DOS snake
     */
    public void drawSnakeDuo(){
        if(snakeDuo){
            gameDemoDuo[0].drawSnake();
            gameDemoDuo[1].drawSnake();
        }
    }
    
    /**
     * Hace crecer 1 segmento la serpiente de prueba de DOS snake
     */
    public void makeSnakeBiggerDuo(){
        if(snakeDuo){
            gameDemoDuo[0].makeSnakeBigger();
            gameDemoDuo[1].makeSnakeBigger();
        }
    }
    
    /**
     * Hace crecer varios segmentos la serpiente de prueba de DOS snake
     * 
     * @param veces La cantidad de segmentos que debe crecer la serpiente de prueba
     */
    public void makeSnakeBiggerDuo(int veces){
        if(snakeDuo){
            gameDemoDuo[0].makeSnakeBigger(veces);
            gameDemoDuo[1].makeSnakeBigger(veces);
        }
    }
    
    /**
     * Hace moverse 1 vez a la serpiente de prueba de DOS snake
     */
    public void animateSnakeDuo(){
        if(snakeDuo){
            gameDemoDuo[0].animateSnake();
            gameDemoDuo[1].animateSnake();
        }
    }
    
        /**
     * Crea una partida de prueba de VARIAS snake (Por defecto 3, minimo 1)
     * Si hay partida creada, no hara nada
     * 
     * @param cantidad El numero de serpientes a meter en pantalla
     */
    public void partidaSnakeMulti(int cantidad){
        if(!snakeMulti){
            gameCanvasMulti = new Canvas("Snake Demo Multi", alto + 20, ancho);
            gameDemoMulti = new ArrayList<Snake>();
            if (cantidad < 1){
                cantidad = 3;
            }
            for (int i = 0; i < cantidad; i++){
                gameDemoMulti.add(new Snake(alto, ancho, gameCanvasMulti));
            }
            snakeMulti = true;
        }
    }
    
    /**
     * Inicia la partida de prueba de MULTIPLES snake
     */
    public void drawSnakeMulti(){
        if(snakeMulti){
            for (Snake serpiente : gameDemoMulti){
                serpiente.drawSnake();
            }
        }
    }
    
    /**
     * Hace crecer 1 segmento la serpiente de prueba de MULTIPLES snake
     */
    public void makeSnakeBiggerMulti(){
        if(snakeMulti){
            for (Snake serpiente : gameDemoMulti){
                serpiente.makeSnakeBigger();
            }
        }
    }
    
    /**
     * Hace crecer varios segmentos la serpiente de prueba de MULTIPLES snake
     * 
     * @param veces La cantidad de segmentos que debe crecer la serpiente de prueba
     */
    public void makeSnakeBiggerMulti(int veces){
        if(snakeMulti){
            for (Snake serpiente : gameDemoMulti){
                serpiente.makeSnakeBigger(veces);
            }
        }
    }
    
    /**
     * Hace moverse 1 vez a la serpiente de prueba de MULTIPLES snake
     */
    public void animateSnakeMulti(){
        if(snakeMulti){
            for (Snake serpiente : gameDemoMulti){
                serpiente.animateSnake();
            }
        }
    }
}
