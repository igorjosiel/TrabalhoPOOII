
package Operations;

import Controllers.ExibicaoController;
import static DAO.DAO.conexao;
import DAO.EpisodioDAO;
import Views.ExibicaoView;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Igor Josiel and Vinícius Trindade
 */
public class Exibicao
{
    JFrame frame;
    
    private ExibicaoView exibView;
    private ExibicaoController exibController;
    
    private EpisodioDAO ep;
    
    public Exibicao(JFrame frame, JTable tabela) throws SQLException
    {
        exibView = new ExibicaoView();
        ep = new EpisodioDAO(tabela);
    }
    
    public void renderizarExibicao() throws SQLException
    {
        exibController = new ExibicaoController(frame, exibView.tabelaEpisodios);
        
        exibView.setVisible(true);
        
        this.mostrarDados();
    }
    
    public void mostrarDados()
    {
        String titulos[] = {"ID", "Nome", "Temporada", "Genero", "Ano", "Assistido?", "Nota"};
        
        String registros[] = new String[8];
        
        String consulta = "select * from tbl_episodio";
    
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        try
        {
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while (rs.next())
            {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("nome");
                registros[2] = rs.getString("temporada");
                registros[3] = rs.getString("genero");
                registros[4] = rs.getString("ano");
                registros[5] = rs.getString("assistido");
                registros[6] = rs.getString("nota");
                
                modelo.addRow(registros);
            }
            
            exibView.tabelaEpisodios.setModel(modelo);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao exibir os dados!" + e.getMessage());
        }
    }
}

