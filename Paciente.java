import java.util.Date;

public class Paciente {
    private String cpf;
    private String nome;
    private Date data_nascimento;
    private Date data_cadastro;
    private String endereco;

    public Paciente() {

    }
    public Paciente(String cpf, String nome, Date data_nascimento, Date data_cadastro, String endereço) {
        setCpf(cpf);
        setNome(nome);
        setDate_nascimento(data_nascimento);
        setDate_cadastro(data_cadastro);
        setEndereço(endereço);

    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Date getDate_nascimento() {
        return data_nascimento;
    }
    public void setDate_nascimento(Date Date_nascimento) {
        this.data_nascimento = Date_nascimento;
    }
    public Date getDate_cadastro() {
        return data_cadastro;
    }
    public void setDate_cadastro(Date Date_cadastro) {
        this.data_cadastro = Date_cadastro;
    }
    public String getEndereço() {
        return endereco;
    }
    public void setEndereço(String endereço) {
        this.endereco = endereço;
    }
    void listar(){ //Lista cada Paciente cadastrado
        System.out.println("\nCPF: " + this.cpf);
        System.out.println("\nNome: " + this.nome);
    }
}
