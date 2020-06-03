
package Operations;

import javax.swing.JFrame;

/**
 *
 * @authors Igor Josiel and Vinícios Trindade
 */
public class Encerramento
{
    JFrame frame = new JFrame();
    
    public Encerramento(JFrame frame)
    {
        this.frame = frame;
    }
    
    public void encerrar()
    {
        frame.dispose();
    }
}
