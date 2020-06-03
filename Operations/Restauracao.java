
package Operations;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @authors Igor Josiel and Vinícius Trindade
 */
public class Restauracao
{
    public Restauracao()
    {
    }
    
    public void limpar(JTextField textNome, JComboBox comboGenero, JTextField textTemporada, JComboBox comboAno, JCheckBox checkAssistido, JComboBox comboNota)
    {
        textNome.setText("");
        textTemporada.setText("");
        comboAno.setSelectedItem(2020);
        comboGenero.setSelectedItem("Terror");
        comboNota.setSelectedItem(1);
        checkAssistido.setSelected(false);
    }
}
