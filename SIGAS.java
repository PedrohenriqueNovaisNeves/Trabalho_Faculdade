package sigas;
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
        
        
        /*
        Aqui nos temos a criacao dos objetos para utilizacao, cada construtor correspondo a um cadastro especifico, enquanto o programa esta rodando
        Assim que o programa reinicia os objetos sao reinicializados (pelo menos essa e minha ideia kk).

        No caso dos Scanners, eu criei dois, para que um possa somente ler textos e o outro leia apenas numeros.
         */
       

        /*
        Aqui temos a variaveis que sao utilizadas no programa.
         */
        //variaveis
        int selecao;
        String confirmacao;
        char op = 'S';
        String continuacao;
        char seguir = 'C';
        //

        do {
            /*
            Aqui nos temos o "menu" onde o usuario ira selecionar se ele deseja logar com o cadastro que ele ja possui, ou deseja realizar o cadastro.
             */
            /*
            Aqui o usuario tera o campo para selecionar como ele deseja entrar em nosso sistema, Caso ele ja tenha um cadastro ele ira fazer o login
            Caso nao tenha tera que se cadastrar.
             */
            System.out.println("1 - para se cadastrar, 2 - para logar como professor, 3 - para logar como aluno");
            selecao = ler.nextInt();

            if(selecao == 1){
                /*
                Caso o usuario selecione se cadastrar, ele devera escolher o cadastro como aluno, ou o cadastro como professor.
                Ja temos os dois fluxos estabelecidos.
                 */
                    System.out.print("Digite o tipo do seu cadastro (Professor/Aluno): ");
                    String tipo = text.nextLine();

                    switch (tipo) {
                        case "professor", "Professor":
                            System.out.println("CADASTRO PARA PROFESSORES!!");

                            System.out.print("Digite o nome completo: ");
                            pro1.setNome(text.nextLine());

                            System.out.print("Digite o seu RG: ");
                            pro1.setRG(text.nextLine());

                            System.out.print("Digite o seu CPF: ");
                            pro1.setCPF(text.nextLine());

                            System.out.println("Sua matricula deve conter ate no maximo 8 caracteres");
                            System.out.print("Digite sua matricula: ");
                            pro1.setMatricula(ler.nextInt());

                            while (!pro1.validaMatricula(pro1.getMatricula())) {
                                System.out.println("A matricula digitada excedeu o limite de carecteres!");
                                System.out.print("Digite novamente: ");
                                pro1.setMatricula(ler.nextInt());
                            }

                            System.out.print("Digite a disciplina que ira lecionar: ");
                            pro1.setDisciplina(text.nextLine());

                            System.out.println("Bem vindo " + pro1.getNome() + ", cadastro realizado com sucesso!");

                            System.out.println("Deseja verificar seus dados? ");
                            confirmacao = text.nextLine();
                            switch (confirmacao) {
                                case "sim", "Sim":
                                    pro1.mostrarDados();
                                    break;
                            }

                            System.out.println("Selecione o servico que deseja utulizar, INCLUIR notas, CONSULTAR notas");
                            confirmacao = text.nextLine();

                            switch (confirmacao) {
                                case "INCLUIR", "incluir", "Incluir":
                                    System.out.println("Digite o nome do aluno: ");
                                    String nomeAluno = text.nextLine();

                                    if (nomeAluno != aluno1.getNome()) {
                                        System.out.println("O nome digitado possivelmente esta incorreto!");
                                        System.out.println("Certifique-se de que o aluno que deseja incluir as notas, esta cadastrado em nosso sistema");
                                        System.out.print("Digite novamente: ");
                                        nomeAluno = text.nextLine();

                                        if (nomeAluno != aluno1.getNome()) {
                                            System.out.println("O aluno desejado nao esta cadastrado em nosso sistema");
                                            System.out.println("Execute novamente o nosso programa, e realize o cadastro do aluno");
                                            return;
                                        }
                                    } else if (nomeAluno == aluno1.getNome()) {
                                        System.out.println("Aluno " + aluno1.getNome() + "Localizado em nosso sistema");
                                        System.out.println("Insira as notas do aluno");

                                        System.out.print("Digite a nota da A1: ");
                                        notas.setA1(ler.nextInt());

                                        while (!notas.validaNotas(notas.getA1())) {
                                            System.out.println("Nota invalida, lembre-se que a nota pode ser somente de 0 a 10");
                                            System.out.print("Digite novamente: ");
                                            notas.setA1(ler.nextInt());
                                        }
                                        aluno1.setA1(notas.getA1());

                                        System.out.print("Digite a nota da A2: ");
                                        notas.setA2(ler.nextInt());

                                        while (!notas.validaNotas(notas.getA2())) {
                                            System.out.println("Nota invalida, lembre-se que a nota pode ser somente de 0 a 10");
                                            System.out.print("Digite novamente: ");
                                            notas.setA2(ler.nextInt());
                                        }
                                        aluno1.setA2(notas.getA2());

                                        System.out.print("Digite a nota da A3: ");
                                        notas.setA3(ler.nextInt());

                                        while (!notas.validaNotas(notas.getA3())) {
                                            System.out.println("Nota invalida, lembre-se que a nota pode ser somente de 0 a 10");
                                            System.out.print("Digite novamente: ");
                                            notas.setA3(ler.nextInt());
                                        }
                                        aluno1.setA3(notas.getA3());
                                    }
                                    break;

                                case "CONSULTAR", "Consultar", "consultar":
                                    System.out.println("Digite o nome do aluno, no qual deseja consultar as notas");
                                    System.out.print("Digite: ");
                                    nomeAluno = text.nextLine();

                                    if (nomeAluno != aluno1.getNome()) {
                                        System.out.println("O nome digitado possivelmente esta incorreto!");
                                        System.out.println("Certifique-se de que o aluno que deseja incluir as notas, esta cadastrado em nosso sistema");
                                        System.out.print("Digite novamente: ");
                                        nomeAluno = text.nextLine();

                                        if (nomeAluno != aluno1.getNome()) {
                                            System.out.println("O aluno desejado nao esta cadastrado em nosso sistema");
                                            System.out.println("Execute novamente o nosso programa, e realize o cadastro do aluno");
                                            return;
                                        }

                                    } else if (nomeAluno == aluno1.getNome()) {
                                        System.out.println("Aluno " + aluno1.getNome() + " Localizado em nosso sistema");

                                        System.out.println("O aluno possui as seguintes notas");
                                        aluno1.consultarNotas();
                                    }
                                    break;

                                case "aluno", "Aluno":
                                    System.out.println("CADASTRO PARA ALUNOS!!");
                                    System.out.print("Digite o nome completo: ");
                                    aluno1.setNome(text.nextLine());

                                    System.out.print("Digite seu RG: ");
                                    aluno1.setRG(text.nextLine());

                                    System.out.print("Digite seu CPF: ");
                                    aluno1.setCPF(text.nextLine());

                                    System.out.println("Seu RA deve conter ate no maximo 8 caracteres");
                                    System.out.print("Digite seu RA: ");
                                    aluno1.setRA(ler.nextInt());

                                    while (!aluno1.validaRA(aluno1.getRA())) {
                                        System.out.println("O RA digitado excedeu o limite de caracteres!");
                                        System.out.print("Digite novamente:");
                                        aluno1.setRA(ler.nextInt());
                                    }

                                    System.out.println("Bem vindo " + aluno1.getNome() + ", cadastro realizado com sucesso!");

                                    System.out.println("Deseja verificar seus dados?");
                                    confirmacao = text.nextLine();

                                    switch (confirmacao) {
                                        case "sim", "Sim":
                                            aluno1.mostrarDados();
                                            break;
                                    }
                                    System.out.println("Selecione CONSULTE, para consultar suas notas, e obter o resultado final");
                                    confirmacao = text.nextLine();

                                    switch(confirmacao){
                                        case "CONSULTE", "Consulte", "consulte", "Consultar", "consultar", "CONSULTAR":
                                            System.out.println("Aqui estao seus resultados");
                                            aluno1.consultarNotas();
                                            notas.calculo(aluno1.getA1(), aluno1.getA2(), aluno1.getA3());
                                            aluno1.setNF(notas.getNF());
                                            notas.resultado(aluno1.getNF());
                                    }
                                    break;
                            }
                    }
            }else if (selecao == 2) {
                /*
                Caso o usuario selecione somente logar, ele sera direcionado para este fluxo, que e o login de professores
                 */
                System.out.println("Voce esta no campo para login de professores");
                System.out.print("Digite seu nome: ");
                pro1.setNome(text.nextLine());

                System.out.print("Digite sua matricula (8 caracteres): ");
                int matricula = ler.nextInt();

                while(!pro1.testaCadastro()){
                    System.out.println("Voce nao possui cadastro em nosso sistema!");
                    System.out.println("Execute novamente o nosso programa, e realize o seu cadastro :)");
                    return;
                }

                while(matricula != pro1.getMatricula()){
                    System.out.println("A matricula digitada esta incorreta!!");
                    System.out.print("Dgite novamente: ");
                    matricula = ler.nextInt();
                }

                System.out.println("Selecione o servico que deseja utulizar, INCLUIR notas, CONSULTAR notas");
                confirmacao = text.nextLine();

                switch(confirmacao){
                    case "INCLUIR", "incluir", "Incluir":
                        System.out.println("Digite o nome do aluno: ");
                        String nomeAluno = text.nextLine();

                        if(nomeAluno != aluno1.getNome()){
                            System.out.println("O nome digitado possivelmente esta incorreto!");
                            System.out.println("Certifique-se de que o aluno que deseja incluir as notas, esta cadastrado em nosso sistema");
                            System.out.print("Digite novamente: ");
                            nomeAluno = text.nextLine();

                            if(nomeAluno != aluno1.getNome()){
                                System.out.println("O aluno desejado nao esta cadastrado em nosso sistema");
                                System.out.println("Execute novamente o nosso programa, e realize o cadastro do aluno");
                                return;
                            }
                        }else if(nomeAluno == aluno1.getNome()){
                            System.out.println("Aluno " + aluno1.getNome() + "Localizado em nosso sistema");
                            System.out.println("Insira as notas do aluno");

                            System.out.print("Digite a nota da A1: ");
                            notas.setA1(ler.nextInt());

                            while(!notas.validaNotas(notas.getA1())){
                                System.out.println("Nota invalida, lembre-se que a nota pode ser somente de 0 a 10");
                                System.out.print("Digite novamente: ");
                                notas.setA1(ler.nextInt());
                            }
                            aluno1.setA1(notas.getA1());

                            System.out.print("Digite a nota da A2: ");
                            notas.setA2(ler.nextInt());

                            while(!notas.validaNotas(notas.getA2())){
                                System.out.println("Nota invalida, lembre-se que a nota pode ser somente de 0 a 10");
                                System.out.print("Digite novamente: ");
                                notas.setA2(ler.nextInt());
                            }
                            aluno1.setA2(notas.getA2());

                            System.out.print("Digite a nota da A3: ");
                            notas.setA3(ler.nextInt());

                            while(!notas.validaNotas(notas.getA3())){
                                System.out.println("Nota invalida, lembre-se que a nota pode ser somente de 0 a 10");
                                System.out.print("Digite novamente: ");
                                notas.setA3(ler.nextInt());
                            }
                            aluno1.setA3(notas.getA3());
                        }
                        break;

                    case "CONSULTAR", "Consultar", "consultar":
                        System.out.println("Digite o nome do aluno, no qual deseja consultar as notas");
                        System.out.print("Digite: ");
                        nomeAluno = text.nextLine();

                        if(nomeAluno != aluno1.getNome()){
                            System.out.println("O nome digitado possivelmente esta incorreto!");
                            System.out.println("Certifique-se de que o aluno que deseja incluir as notas, esta cadastrado em nosso sistema");
                            System.out.print("Digite novamente: ");
                            nomeAluno = text.nextLine();

                            if(nomeAluno != aluno1.getNome()){
                                System.out.println("O aluno desejado nao esta cadastrado em nosso sistema");
                                System.out.println("Execute novamente o nosso programa, e realize o cadastro do aluno");
                                return;
                            }

                        }else if(nomeAluno == aluno1.getNome()){
                            System.out.println("Aluno " + aluno1.getNome() + " Localizado em nosso sistema");

                            System.out.println("O aluno possui as seguintes notas");
                            aluno1.consultarNotas();
                        }
                        break;
                }
            }else if (selecao == 3) {
                /*
                Caso ele selecione logar como aluno, ele sera direcionado para este fluxo
                 */
                System.out.println("Voce esta no campo para login de alunos");
                System.out.print("Digite o seu nome: ");
                aluno1.setNome(text.nextLine());

                System.out.print("Digite o seu RA (9 caracteres): ");
                int ra = ler.nextInt();

                while(!aluno1.testaCadastro()){
                    System.out.println("Voce nao possui cadastro em nosso sistema!");
                    return;
                }

                while(ra != aluno1.getRA()){
                    System.out.println("O RA digitado esta incorreto!!");
                    System.out.print("Digite novamente: ");
                    ra = ler.nextInt();
                }

                System.out.print("Digite seu RA para localizarmos o seu cadastro: ");
                ra = text.nextInt();

                if(ra != aluno1.getRA()){
                    System.out.println("O RA digitado, possivelmente esta incorreto");
                    System.out.println("Certifique-se que esta cadastrado em nosso sistema");
                    System.out.print("Digite novamente: ");
                    ra = text.nextInt();

                    if(ra != aluno1.getRA()){
                        System.out.println("Voce nao possui cadastro em nosso sistema");
                        return;
                    }
                }else if(ra == aluno1.getRA()){
                    System.out.println("Selecione CONSULTE, para consultar suas notas, e obter o resultado final");
                    confirmacao = text.nextLine();

                    switch(confirmacao){
                        case "CONSULTE", "Consulte", "consulte", "Consultar", "consultar", "CONSULTAR":
                            System.out.println("Aqui estao seus resultados");
                            aluno1.consultarNotas();
                            notas.calculo(aluno1.getA1(), aluno1.getA2(), aluno1.getA3());
                            aluno1.setNF(notas.getNF());
                            notas.resultado(aluno1.getNF());
                    }
                }
            }

            /*
            Aqui esta a funcao para atualizacao de cadastro, onde o usuario conseguira acessar se caso precisar mudar seus dados cadastrais.
             */
            System.out.println("Se precisar atualizar seus dados cadastrais");
            System.out.println("Digite (1) para professores");
            System.out.println("Digite (2) para alunos");
            System.out.println("------------------------");
            System.out.println("Caso contrario, digite um numero qualquer");
            selecao = ler.nextInt();

            if(selecao == 1){
                System.out.println("Atualizacao cadastral para professores!");
                System.out.print("Digite sua matricula para localizarmos seu cadastro: ");
                int matricula = ler.nextInt();

                while(matricula != pro1.getMatricula()){
                    System.out.println("Matricula invalida!!");
                    System.out.print("Digite novamente: ");
                    matricula = ler.nextInt();
                }

                if(matricula == pro1.getMatricula()){
                    System.out.println("Digite os novos dados para atualizacao do cadastro");
                    pro1.atualizaDados(text.nextLine(), text.nextLine(), ler.nextInt());
                }

                System.out.println("Seu cadastro atual e: ");
                pro1.mostrarDados();

            }else if(selecao == 2){
                System.out.println("Atualizacao cadastral para alunos!");
                System.out.println("Digite seu RA para localizarmos o seu cadastro");
                int RA = ler.nextInt();

                while(RA != aluno1.getRA()){
                    System.out.println("RA invalido!!");
                    System.out.print("Digite novamente: ");
                    RA = ler.nextInt();
                }

                if(RA == aluno1.getRA()){
                    System.out.println("Digite os novos dados para atualizacao do cadastro");
                    aluno1.atualizaDados(text.nextLine(), text.nextLine(), ler.nextInt());
                }

                System.out.println("Seu cadastro atual e: ");
                aluno1.mostrarDados();
            }

            /*
            Aqui nos temos a saida do programa, onde para que o programa seja encerrado o usuario tenha que digitar a letra S.
            caso contrario o programa ira repitir novamente todo o seu fluxo.
             */
            System.out.println("Para encerrar a execucao do programa, digite (S)");
            System.out.println("Para continuar digite qualquer palavra");
            op = text.next().toUpperCase().charAt(0);
            continuacao = text.nextLine();
        }while(op != 'S');
        System.out.println("Saida do programa!");
    }
}
