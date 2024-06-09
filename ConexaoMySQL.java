
package sigas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.*;
import java.util.ArrayList;

public class ConexaoMySQL {
   
    public String status = "Não conectou...";
    
    private Connection conexao = null;

    public Connection getConexaoMySQL() {
       
        if (conexao != null) return conexao; 

        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);

            String serverName = "localhost";    //caminho do servidor do BD
            String mydatabase = "bancoSIGAS";    //nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            String username = "root";        //nome de um usuário de seu BD      
            String password = "Cozinha@57";      //sua senha de acesso
            conexao = DriverManager.getConnection(url, username, password);

            if (conexao != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Nao foi possivel realizar conexao");
            }
            return conexao;

        } catch (ClassNotFoundException e) {  
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    public String statusConection() {
        return status;
    }
    
    
    public boolean FecharConexao() {
        try {
            conexao.close();
            conexao = null;
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public Connection ReiniciarConexao() {
        FecharConexao();
        return getConexaoMySQL();
    }
}
