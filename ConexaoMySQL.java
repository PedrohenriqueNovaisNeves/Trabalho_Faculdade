
package conexoes;
import tela.*;
import pessoas.*;
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
            String password = "root";      //sua senha de acesso
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
    
    public void inserirNotas(String A1, String A2, String A3) {
        try{
            String sqlNotas = "insert into Notas (A1, A2, A3) values (?, ?, ?);";
            PreparedStatement insertNotas = getConexaoMySQL().prepareStatement(sqlNotas);
            insertNotas.setString(1, A1);
            insertNotas.setString(2, A3);
            insertNotas.setString(3, A3);
            int linhasAfetadas = insertNotas.executeUpdate();

            System.out.println(linhasAfetadas + " linha(s) inserida(s)");

            insertNotas.close();
            conexao.close();
            conexao = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
    public void inserirUsuario(String nome, String CPF, String RG) throws SQLException{
 
        try{
            String sql = "insert into Usuario (nome, RG, CPF) values (?, ?, ?);";
            PreparedStatement insertUsuario = getConexaoMySQL().prepareStatement(sql);
            insertUsuario.setString(1, nome);
            insertUsuario.setString(2, RG);
            insertUsuario.setString(3, CPF);
            int linhasAfetadas = insertUsuario.executeUpdate();

            System.out.println(linhasAfetadas + " linha(s) inserida(s)");

            insertUsuario.close();
            conexao.close();
            conexao = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserirAluno(String RA) {
        try{
            String sqlRA = "insert into Aluno (RA) values (?);";
            PreparedStatement insertAluno = getConexaoMySQL().prepareStatement(sqlRA);
            insertAluno.setString(1, RA);
            int linhasAfetadas = insertAluno.executeUpdate();

            System.out.println(linhasAfetadas + " linha(s) inserida(s)");

            insertAluno.close();
            conexao.close();
            conexao = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void inserirProfessor(String matricula) {
        try{
            String sqlMatricula = "insert into Professor (matricula) values (?);";
            PreparedStatement insertProfessor = getConexaoMySQL().prepareStatement(sqlMatricula);
            insertProfessor.setString(1, matricula);
            int linhasAfetadas = insertProfessor.executeUpdate();

            System.out.println(linhasAfetadas + " linha(s) inserida(s)");

            insertProfessor.close();
            conexao.close();
            conexao = null;
        } catch (SQLException e) {
            e.printStackTrace();
    }

        
       /* public ArrayList<Aluno> buscaProfessor(String nomeBuscar) throws SQLException{
        ArrayList<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluno where nomeAluno = ?";
        
        try (PreparedStatement preparedStatement = getConexaoMySQL().prepareStatement(sql)) {
            preparedStatement.setString(1, nomeBuscar);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("idAluno");
                String nome = resultSet.getString("nomeAluno");
                String RA = resultSet.getString("raAluno");
                lista.add(new Aluno(id, nome, RA));
        
        
        
        
        
         try {
            String sqlBuscarAluno = "SELECT *\n" +
                                     "FROM Usuario\n" +
                                        "JOIN Aluno ON Usuario.idUsuario = Aluno.idAluno;";
            PreparedStatement buscarAluno = getConexaoMySQL().prepareStatement(sqlBuscarAluno); 
            
            ResultSet resultSet = buscarAluno.executeQuery();
            while (resultSet.next()) {
                  String RA = resultSet.getString("RA");
                  System.out.println(sqlBuscarAluno);
                  
                  
            }
        
        conexao.close();
        conexao = null;
        } catch (SQLException e) {
            e.printStackTrace();
        } */
    }  
    
    
    /*
public void buscaNotas(String A1, String A2, String A3){
        
        try {
            String sqlBuscarNotas = "SELECT * FROM notas";
            PreparedStatement buscarNotas = getConexaoMySQL().prepareStatement(sqlBuscarNotas); 
            
            ResultSet resultSet = buscarNotas.executeQuery();
            while (resultSet.next()) {
                 A1 = resultSet.getString("A1");
                 A2 = resultSet.getString("A2");
                 A3 = resultSet.getString("A3");
            }
        
        conexao.close();
        conexao = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }  
    */
    public void buscaUsuario(String CPF){
        
        try {
            String sqlBuscarUsuario = "SELECT * FROM Usuario";
            PreparedStatement buscarUsuario = getConexaoMySQL().prepareStatement(sqlBuscarUsuario); 
            
            ResultSet resultSet = buscarUsuario.executeQuery();
            while (resultSet.next()) {
                 CPF = resultSet.getString("CPF");
            }
        
        conexao.close();
        conexao = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
  
        
    


