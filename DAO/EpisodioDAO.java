
package DAO;

import Enum.EnumEpisodio;
import java.util.List;
import Models.Episodio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EpisodioDAO extends DAO
{
    private JTable jtable;
    
    public String column[] = {"Nome", "Temporada", "Genero", "Ano", "Assistido?", "Nota"};
    
    public static String consulta = "SELECT * FROM tbl_episodio";
    public static String insercao = "INSERT INTO tbl_episodio(Nome, Temporada, Genero, Ano, Assistido, Nota) VALUES(?, ?, ?, ?, ?, ?)";
    
    public EpisodioDAO(JTable tabela) throws SQLException
    {
        super();
        
        this.jtable = tabela;
    }
    
    // Retorna todos os livros da tabela
    public List<Episodio> getTodosEpisodios() throws SQLException
    {
        List<Episodio> episodios = new ArrayList<>();
        
        Statement stat = DAO.getConection().createStatement();
        ResultSet resultSet = stat.executeQuery(consulta);
        
        while(resultSet.next())
        {
            Episodio tempEpisodio = new Episodio(
               resultSet.getString(EnumEpisodio.COLUNA_NOME),
               resultSet.getString(EnumEpisodio.COLUNA_TEMPORADA),
               resultSet.getString(EnumEpisodio.COLUNA_GENERO),
               resultSet.getInt(EnumEpisodio.COLUNA_ANO),
               resultSet.getBoolean(EnumEpisodio.COLUNA_ASSISTDO),
               resultSet.getInt(EnumEpisodio.COLUNA_NOTA)
            );
            
            episodios.add(tempEpisodio);
        }
        
        stat.close();
        
        return episodios;
    }
    
    public static void AdicionaEpisodio(JTextField nome, JTextField temporada, String generoEpisodio, int anoEpisodio, boolean assistido, int notaEpisodio) throws SQLException
    {
        try
        {
        PreparedStatement stmt = DAO.conexao.prepareStatement(EpisodioDAO.insercao);
        
        stmt.setString(1, nome.getText());
        stmt.setString(2, temporada.getText());
        stmt.setString(3, generoEpisodio);
        stmt.setInt(4, anoEpisodio);
        stmt.setBoolean(5, assistido);
        stmt.setInt(6, notaEpisodio);
        
        stmt.execute();
        stmt.close();
        
        JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        
        DAO.conexao.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!" + e.getMessage());
        }
    }
    
    public void exibirDados()
    {
        String[] titulos = {"ID", "Nome", "Temporada", "Genero", "Ano", "Assistido?", "Nota"};
        String[] registros = new String[7];
        
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        
        try
        {
            Statement st = DAO.conexao.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            
            while(rs.next())
            {
                registros[0] = rs.getString("id");
                registros[1] = rs.getString("nome");
                registros[2] = rs.getString("temporada");
                registros[3] = rs.getString("genero");
                registros[4] = rs.getString("ano");
                registros[5] = rs.getString("assistido");
                registros[6] = rs.getString("nota");
                
                model.addRow(registros);
            }
            
            this.jtable.setModel(model);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Erro ao consultar os registros!" + e.getMessage());
        }
    }
}
