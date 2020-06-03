
package DAO;

import Enum.EnumConexao;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;/**
 *
 * @authors Igor Josiel and Vinícius Trindade
 */
public abstract class DAO
{
    public static Connection conexao;
    
    public DAO() throws SQLException
    {
        conexao = DriverManager.getConnection(EnumConexao.dburl, EnumConexao.user, EnumConexao.password);
    }
    
    public static Connection getConection()
    {
        return conexao;
    }
}
