
package Operations;

import java.util.Calendar;
import javax.swing.JComboBox;

/**
 *
 * @authors Igor Josiel and Vinícius Trindade
 */
public class ConfiguracaoComboBox
{
    private JComboBox comboAno;
    private JComboBox comboGenero;
    private JComboBox comboNota;
    
    public JComboBox popularComboAno(JComboBox ano)
    {
        this.comboAno = ano;

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        
        for (int anoLoop = currentYear; anoLoop >= 1980; anoLoop --)
        {
            this.comboAno.addItem(anoLoop);
        }
        
        return this.comboAno;
    }

    public JComboBox popularComboGenero(JComboBox genero)
    {
        this.comboGenero = genero;
        
        String[] generos = new String[]{"Terror", "Ação", "Aventura", "Comédia", "Drama", "Ficção", "Luta"};
        
        for (String generoLoop : generos)
        {
            this.comboGenero.addItem(generoLoop);
        }
        
        return comboGenero;
    }
    
    public JComboBox popularComboNota(JComboBox nota)
    {
        this.comboNota = nota;
        
        int[] notas = new int[10];
        
        for (int i = 0; i < notas.length; i++)
        {
            notas[i] = i + 1;
        }
        
        for (int notaLoop : notas)
        {
            this.comboNota.addItem(notaLoop);
        }
        
        return comboNota;
    }
}
