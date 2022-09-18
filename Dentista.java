import java.util.Date;

public class Dentista {
    private String cro;
    private String nome;
    private Date data_nascimento;
    private Date data_cadastro;

    public Dentista(){

    }

    public Dentista(String cro, String nome, Date data_nascimento, Date data_cadastro) {
        setCro(cro);
        setNome(nome);
        setData_nascimento(data_nascimento);
        setData_cadastro(data_cadastro);

    }
    public String getCro() {
        return cro;
    }
    public void setCro(String cro) {
        this.cro = cro;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getData_nascimento() {
        return data_nascimento;
    }
    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
    public Date getData_cadastro() {
        return data_cadastro;
    }
    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    void listar(){ //Lista cada Dentista cadastrado
        System.out.println("\nCRO: " + this.cro);
        System.out.println("\nNome: " + this.nome);
    }
    
}
