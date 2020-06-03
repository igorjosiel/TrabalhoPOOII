
package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @authors Igor Josiel and Vinícius Trindade
 */
public class ExibicaoController implements ActionListener
{    
    private JFrame frame = new JFrame();
    
    private JTable tabela = new JTable();
    
    public ExibicaoController(JFrame frame, JTable tabela)
    {
        this.frame = frame;
        this.tabela = tabela;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        
    }
}
