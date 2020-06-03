
package Operations;

import DAO.DAO;
import DAO.EpisodioDAO;
import Models.Episodio;
import Views.CadastroView;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @authors Igor Josiel and Vinícius Trindade
 */
public class Cadastro extends DAO
{
    private CadastroView cadView;
    private EpisodioDAO ep;
    
    private List<Episodio> episodios = new ArrayList<>();
    
    public Cadastro() throws SQLException
    {
        cadView = new CadastroView();
    }
    
    public void renderizarCadastro()
    {
        cadView.setVisible(true);
    }
    
    public void cadastrar(JTextField nome, JComboBox genero, JTextField temporada, JComboBox ano, JCheckBox assistido, JComboBox nota, List<Episodio> episodios) throws SQLException
    {
        this.episodios = episodios;
        
        int anoEpisodio = (int) ano.getSelectedItem();
        int notaEpisodio = (int) nota.getSelectedItem();
        
        String generoEpisodio = (String) genero.getSelectedItem();

        Episodio episodio = new Episodio(nome.getText(), generoEpisodio, temporada.getText(), anoEpisodio, assistido.isSelected(), notaEpisodio);
        
        episodios.add(episodio);
        
        EpisodioDAO.AdicionaEpisodio(nome, temporada, generoEpisodio, anoEpisodio, assistido.isSelected(), notaEpisodio);
    }
    
    public List getMovies()
    {
        return this.episodios;
    }
}
