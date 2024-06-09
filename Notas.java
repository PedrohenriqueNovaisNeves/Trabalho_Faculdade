package notas;
import pessoas.*;

/*
Essa classe e responsavel pelas notas e todas as funcoes delas.
 */
public class Notas{

    private int A1;
    private int A2;
    private int A3;
    private int NF;

    /*
    Assim como nas outras classes ja instanciadas, temos um construtor vazio, para podermos criar o objeto sem termos que passar parametro algum.
     */
    public Notas(){
        this.A1 = 0;
        this.A2 = 0;
        this.A3 = 0;
        this.NF = 0;
    }

    /*
    Temos aqui os metodos para setar e armazenar as notas dos alunos caso os atributos do objeto esteja nulo.
     */
    public boolean setA1(int A1){
        if(this.A1 == 0){
            this.A1 = A1;
            return true;
        }else {
            return false;
        }
    }

    /*
    Estes metodos estao validando e certificando que os alunos irao inserir uma nota que sera maior ou igual a zero e menor ou igual a 10.
     */
    public boolean validaNotas(int nota){
        if ((nota > 10) && (nota < 0)){
            return false;
        }else {
            this.A1 = nota;
            this.A2 = nota;
            this.A3 = nota;
            return true;
        }
    }

    public boolean setA2(int A2){
        if(this.A2 == 0){
            this.A2 = A2;
            return true;
        }else {
            return false;
        }
    }

    public boolean setA3(int A3){
        if(this.A3 == 0){
            this.A1 = A3;
            return true;
        }else {
            return false;
        }
    }

    /*
    Neste metodo esta sendo feito o calculo das notas dos alunos, e o resultado desse calculo esta sendo armazenado no atributo da nota final.
     */
    public void calculo(int A1, int A2, int A3){
        int notafinal = (A1 + A2 + A3)/3;
        this.NF = notafinal;
    }

    public int getNF(){
        return this.NF;
    }

    public int getA1(){
        return this.A1;
    }

    public int getA2(){
        return this.A2;
    }

    public int getA3(){
        return this.A3;
    }

    /*
    Aqui temos um metodo onde o programa retornara a situacao do aluno, se ele esta aprovado, se ele tera direito a uma prova sub
    ou se ele esta retido direto.
    Neste contexto, se a nota final dele for maior ou igual a 7 ele esta aprovado,se a nota dele for maior que 5 ou menor 7,
    ele tera direito a uma prova sub, caso contrario ele estara retido direto.
     */
    public void resultado(int nf){
        if(this.NF >= 7){
            System.out.println("Parabens voce esta aprovado!");
        }else if((this.NF > 5) && (this.NF < 7)){
            System.out.println("Voce tem direito a uma prova Substitutiva");
        }else {
            System.out.println("Voce esta retido!!");
        }
    }
}