package sigas;
import conexoes.ConexaoMySQL;
import java.util.Scanner;
import pessoas.*;
import notas.*;
import tela.*;

import java.sql.SQLException;
import java.util.ArrayList;

/*
Aqui no main a implementacao das classes esta bem autoexplicativa, bem facil de entender.
*/

public class SIGAS {

public static void main(String[] args) throws SQLException {
        Scanner ler = new Scanner(System.in);
        Scanner text = new Scanner(System.in);
        Professor pro1 = new Professor();
        Aluno aluno1 = new Aluno();
        Notas notas = new Notas();
        
        ConexaoMySQL teste = new ConexaoMySQL();
        teste.getConexaoMySQL();
        System.out.println(teste.status);
        
        
        Tela tl = new Tela();
        tl.setVisible(true);
        
    }
}
        
        
        