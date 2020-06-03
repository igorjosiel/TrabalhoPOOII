
package Controllers;

import Models.Episodio;
import Operations.Cadastro;
import Operations.ConfiguracaoComboBox;
import Operations.Encerramento;
import Operations.Restauracao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @authors Igor Josiel and Vinícius Trindade
 */
public class CadastroController implements ActionListener
{
    private JFrame frame;
    
    private ConfiguracaoComboBox config = new ConfiguracaoComboBox();
    
    private JTextField textNome;
    private JTextField textTemporada;
    
    private JComboBox comboAno;
    private JComboBox comboGenero;
    private JComboBox comboNota;
    
    private JCheckBox checkAssistido;
    
    private List<Episodio> episodios;
    
    public CadastroController(JTextField nome, JTextField temporada, JComboBox ano, JComboBox genero, JComboBox nota, JCheckBox assistido, JFrame jframe)
    {
        this.textNome = nome;
        this.textTemporada = temporada;
        this.checkAssistido = assistido;
        
        this.comboGenero = config.popularComboGenero(genero);
        this.comboAno = config.popularComboAno(ano);
        this.comboNota = config.popularComboNota(nota);
        
        this.frame = jframe;
        
        episodios = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent evento)
    {
        switch (evento.getActionCommand())
        {
            case "Cadastrar": Cadastro cad;
            try
            {
                cad = new Cadastro();
                cad.cadastrar(this.textNome, this.comboGenero, this.textTemporada, this.comboAno, this.checkAssistido, this.comboNota, this.episodios);
            }
            catch (SQLException ex)
            {
                Logger.getLogger(InitController.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            
            case "Limpar": Restauracao rest = new Restauracao();
            rest.limpar(this.textNome, this.comboGenero, this.textTemporada, this.comboAno, this.checkAssistido, this.comboNota);
            break;
            
            case "Voltar": Encerramento enc = new Encerramento(this.frame);
            enc.encerrar();
            break;
        }
    }
}
