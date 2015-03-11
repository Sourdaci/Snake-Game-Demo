
/**
 * Almacena las posiciones en las que se dibuja la serpiente
 * 
 * @author Sourdaci 
 * @version (a version number or a date)
 */
public class SnakePosition
{
    // instance variables - replace the example below with your own
    private int posX;
    private int posY;
    private int angulo; // posicion del array que contiene el giro realizado por la serpiente

    /**
     * Constructor for objects of class SnakePosition
     */
    public SnakePosition(int nuevaX, int nuevaY, int giro)
    {
        posX = nuevaX;
        posY = nuevaY;
        angulo = giro;
    }

    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
    
    public int getAngulo(){
        return angulo;
    }
}
