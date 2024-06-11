package pessoas;

/*
Aqui temos a classe Pessoas, que e uma classe abstrata e tambem a nossa super classe, nela teremos os atributos nome e CPF, que terao seus metodos
principas, onde nos podemos setar o nome e o CPF, e podemos obter eles por meio dos GETs.
 */
public abstract class Usuario {
    public String nome;
    public String RG;
    public String CPF;


    /*
    Temos aqui um construtor vazio, para que nos possamos extender os metodos e atributos desta classe para as demais, evitando assim a duplicidade.
     */
    public Usuario(){
        this.nome = null;
        this.CPF = null;
        this.RG = null;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCPF(){
        return this.CPF;
    }

/*
Tanto no setNome, quanto no setCPF, temos uma valida antes de salvarmos os nomes e os CPFs nos objetos criados e utilizados no main.
De forma resumida ele esta testando se o atributo nome for nulo, ele ira salvar o nome inserido pelo usuario (o mesmo se aplica para o CPF).
 */
    public void setNome(String nome){
            this.nome = nome;
    }

    public void setCPF(String CPF){
            this.CPF = CPF;
    }

    public void setRG(String RG){
            this.RG = RG;
    }

    public String getRG(){
        return RG;
    }
}
