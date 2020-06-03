package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.InitController;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTable;

public class InitView extends JFrame
{
    private JPanel contentPane;

    private JTable tabela = new JTable();
    
    private JFrame jframe = this;
    
    private JButton btnCadastrar;
    private JButton btnListar;
    private JButton btnEncerrar;
    private JButton btnRemover;

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
    public InitView() throws SQLException
    {        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblMeusLivros = new JLabel("Menu Séries");
        lblMeusLivros.setHorizontalAlignment(SwingConstants.CENTER);
        lblMeusLivros.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblMeusLivros.setBounds(6, 60, 438, 16);
        contentPane.add(lblMeusLivros);

        btnListar = new JButton("Listar");
        btnListar.setBounds(25, 154, 117, 29);
        btnListar.setForeground(Color.WHITE);
        btnListar.setBackground(Color.BLUE);
        contentPane.add(btnListar);
        
        btnEncerrar = new JButton("Cadastrar");
        btnEncerrar.setBounds(165, 154, 117, 29);
        btnEncerrar.setForeground(Color.WHITE);
        btnEncerrar.setBackground(Color.BLUE);
        contentPane.add(btnEncerrar);

        btnCadastrar = new JButton("Encerrar");
        btnCadastrar.setBounds(310, 154, 117, 29);
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setBackground(Color.BLUE);
        contentPane.add(btnCadastrar);
        
        this.setButtonListeners();
        
        this.getContentPane().setBackground(Color.BLACK);

        lblMeusLivros.setForeground(Color.WHITE);
    }
    
    private void setButtonListeners()
    {
        InitController handler = new InitController(tabela, jframe);
        
        btnCadastrar.addActionListener(handler);
        btnListar.addActionListener(handler);
        btnEncerrar.addActionListener(handler);
    }
}