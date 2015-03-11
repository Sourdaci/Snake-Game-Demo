import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * Write a description of class SnakeGameDemo here.
 * 
 * @author Sourdaci
 * @version (a version number or a date)
 */
public class SnakeGameDemo
{
    // instance variables - replace the example below with your own
    private Canvas pantalla;
    private Pen serpiente;
    private Random aleatorio;
    private ArrayList<SnakePosition> posiciones;
    private static final int INICIO_X = 200, INICIO_Y = 200;
    private static final int TRAZO = 20;
    private static final int[] GIRO = {-90, 0, 90};

    /**
     * Constructor for objects of class SnakeGameDemo
     */
    public SnakeGameDemo()
    {
        pantalla = new Canvas("Snake Demo", (INICIO_X * 2), (INICIO_Y * 2));
        serpiente = new Pen(INICIO_X, INICIO_Y, pantalla);
        posiciones = new ArrayList<SnakePosition>();
        aleatorio = new Random();
    }
    
    public void drawSnake(){
        int contador = 0;
        do{
            int rotar = aleatorio.nextInt(GIRO.length);
            int x = serpiente.getPositionX();
            int y = serpiente.getPositionY();
            serpiente.turn(GIRO[rotar]);
            serpiente.move(TRAZO);
            posiciones.add(new SnakePosition(x, y, rotar));
            contador++;
        }while (contador < 3);
    }
}
