
package Models;

/**
 *
 * @author Igor Josiel and Vinícius Trindade
 */
public class Episodio
{
    public String nome;
    private String genero;
    private String temporada;
    private int ano;
    private boolean assistido;
    private int nota;

    public Episodio(String nome, String genero, String temporada, int ano, boolean assistido, int nota)
    {
        this.nome = nome;
        this.genero = genero;
        this.temporada = temporada;
        this.ano = ano;
        this.assistido = assistido;
        this.nota = nota;
    }
    
    public String toString()
    {
        return this.nome + " - " + this.genero + " " + this.temporada + " " + this.ano + " " + this.assistido + " " + this.nota;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getGenero()
    {
        return genero;
    }

    public void setGenero(String genero)
    {
        this.genero = genero;
    }

    public String getTemporada()
    {
        return temporada;
    }

    public void setTemporada(String temporada)
    {
        this.temporada = temporada;
    }

    public int getAno()
    {
        return ano;
    }

    public void setAno(int ano)
    {
        this.ano = ano;
    }

    public boolean getIsAssistido()
    {
        return assistido;
    }

    public void setIsAssistido(boolean assistido)
    {
        this.assistido = assistido;
    }

    public int getNota()
    {
        return nota;
    }

    public void setNota(int nota)
    {
        this.nota = nota;
    }
}
