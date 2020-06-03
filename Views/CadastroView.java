package Views;

import Controllers.CadastroController;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.Episodio;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CadastroView extends JFrame
{
    private JPanel contentPane;

    private JTable tabela = new JTable();
    
    private JFrame jframe = this;
    
    private JButton btnCadastrar;
    private JButton btnVoltar;
    private JButton btnLimpar;
    
    public JTextField textNome;
    private JTextField textTemporada;
    
    private JComboBox comboAno;
    private JComboBox comboGenero;
    private JComboBox comboNota;
    
    private JCheckBox checkAssistido;
    
    private List<Episodio> episodes;

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
    public CadastroView() throws SQLException
    {        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitulo = new JLabel("Cadastro");
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblTitulo.setBounds(6, 30, 438, 16);
        lblTitulo.setForeground(Color.WHITE);
        contentPane.add(lblTitulo);

        JLabel lblnome = new JLabel("Nome");
        lblnome.setBounds(16, 79, 61, 16);
        lblnome.setForeground(Color.WHITE);
        contentPane.add(lblnome);

        textNome = new JTextField();
        textNome.setBounds(65, 74, 130, 26);
        contentPane.add(textNome);
        textNome.setColumns(10);

        JLabel lblGenero = new JLabel("Ano");
        lblGenero.setBounds(216, 79, 90, 16);
        lblGenero.setForeground(Color.WHITE);
        contentPane.add(lblGenero);

        JLabel lblTemporada = new JLabel("Temporada");
        lblTemporada.setBounds(16, 132, 80, 16);
        lblTemporada.setForeground(Color.WHITE);
        contentPane.add(lblTemporada);

        textTemporada = new JTextField();
        textTemporada.setBounds(125, 127, 70, 26);
        contentPane.add(textTemporada);
        textTemporada.setColumns(10);

        JLabel lblAno = new JLabel("Genero");
        lblAno.setBounds(216, 132, 90, 16);
        lblAno.setForeground(Color.WHITE);
        contentPane.add(lblAno);
        
        JLabel lblNota = new JLabel("Nota");
        lblNota.setBounds(216, 175, 90, 16);
        lblNota.setForeground(Color.WHITE);
        contentPane.add(lblNota);

        comboGenero = new JComboBox();
        comboGenero.setBounds(275, 75, 115, 27);
        contentPane.add(comboGenero);

        comboAno = new JComboBox();
        comboAno.setBounds(275, 128, 115, 27);
        contentPane.add(comboAno);
        
        comboNota = new JComboBox();
        comboNota.setBounds(275, 170, 115, 27);
        contentPane.add(comboNota);

        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(300, 209, 117, 29);
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setBackground(Color.BLUE);
        contentPane.add(btnCadastrar);
        
        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(165, 209, 117, 29);
        btnLimpar.setForeground(Color.WHITE);
        btnLimpar.setBackground(Color.BLUE);
        contentPane.add(btnLimpar);
        
        btnVoltar = new JButton("Voltar");
        btnVoltar.setBounds(30, 209, 117, 29);
        btnVoltar.setForeground(Color.WHITE);
        btnVoltar.setBackground(Color.BLUE);
        contentPane.add(btnVoltar);

        checkAssistido = new JCheckBox("Assistido");
        checkAssistido.setBounds(16, 178, 128, 23);
        checkAssistido.setForeground(Color.WHITE);
        checkAssistido .setBackground(Color.BLACK);
        contentPane.add(checkAssistido);
        
        this.setButtonListeners();
        
        this.getContentPane().setBackground(Color.BLACK);
    }
    
    private void setButtonListeners()
    {
        CadastroController handler = new CadastroController(textNome, textTemporada, comboGenero, comboAno, comboNota, checkAssistido, jframe);
        
        btnCadastrar.addActionListener(handler);
        btnLimpar.addActionListener(handler);
        btnVoltar.addActionListener(handler);
    }
}
