
package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.ExibicaoController;
import Models.Episodio;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ExibicaoView extends JFrame
{
    private JPanel contentPane;
    
    public JTable tabelaEpisodios;
    
    private JFrame jframe = this;
    
    private JButton btnVoltar;
    private JButton btnEditar;
    private JButton btnRemover;
    
    private JTextField textTitulo;
    
    private List<Episodio> episodios;

    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    InitView frame = new InitView();

                    frame.setVisible(true);
                }
                
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ExibicaoView() throws SQLException
    {        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        
        final DefaultTableModel modelo = new DefaultTableModel();
        
        tabelaEpisodios = new JTable(modelo);
        contentPane.add(tabelaEpisodios, BorderLayout.CENTER);
        
        JScrollPane scroll = new JScrollPane(tabelaEpisodios);
        this.getContentPane().add(scroll);
        
        this.getContentPane().setBackground(Color.BLACK);
    }
    
    private void setButtonListeners() throws SQLException
    {
        ExibicaoController handler = new ExibicaoController(jframe, tabelaEpisodios);
    }
}