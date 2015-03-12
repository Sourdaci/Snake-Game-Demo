
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

    /**
     * Constructor for objects of class SnakePosition
     */
    public SnakePosition(int inicioX, int inicioY){
        posX = inicioX;
        posY = inicioY;
    }

    public int getPosX(){
        return posX;
    }
    
    public int getPosY(){
        return posY;
    }
}
