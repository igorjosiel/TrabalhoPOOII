
package Controllers;

import Operations.Cadastro;
import Operations.Encerramento;
import Operations.Exibicao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @authors Igor Josiel and Vinícius Trindade
 */
public class InitController implements ActionListener
{
    JTable table = new JTable();
    
    JFrame frame = new JFrame();

    public InitController(JTable table, JFrame frame)
    {
        this.table = table;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        switch (event.getActionCommand())
        {
            case "Cadastrar": Cadastro cad;
            try
            {
                cad = new Cadastro();
                cad.renderizarCadastro();
            }
            catch (SQLException ex)
            {
                Logger.getLogger(InitController.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            
            case "Listar": Exibicao exib;
            try
            {
                exib = new Exibicao(this.frame, this.table);
                exib.renderizarExibicao();
            }
            catch (SQLException ex)
            {
                Logger.getLogger(InitController.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            
            case "Encerrar": Encerramento enc = new Encerramento(frame);
            enc.encerrar();
            break;
        }
    }
}
