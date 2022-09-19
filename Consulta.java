import java.util.Date;

public class Consulta {
    private Dentista dentista;
    private Paciente paciente;
    private Date data_consulta;
    private Date hora_consulta;
    private String flag_consulta;
    private String status_consulta;
    private Double valor_consulta;

    public Consulta(){

    }

    public Consulta(Dentista dentista, Paciente paciente, Date data_consulta, Date hora_consulta, String flag_consulta) {
        setDentista(dentista);
        setPaciente(paciente);
        setData_consulta(data_consulta);
        setHora_consulta(hora_consulta);
        setFlag_consulta(flag_consulta);
    }

    public Dentista getDentista() {
        return dentista;
    }
    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Date getData_consulta() {
        return data_consulta;
    }
    public void setData_consulta(Date data_consulta) {
        this.data_consulta = data_consulta;
    }
    public Date getHora_consulta() {
        return hora_consulta;
    }
    public void setHora_consulta(Date hora_consulta) {
        this.hora_consulta = hora_consulta;
    }
    public String getFlag_consulta() {
        return flag_consulta;
    }
    public void setFlag_consulta(String flag_consulta) {
        this.flag_consulta = flag_consulta;
    }
    public String getStatus_consulta() {
        return status_consulta;
    }
    public void setStatus_consulta(String status_consulta) {
        this.status_consulta = status_consulta;
    }
    public Double getValor_consulta() {
        return valor_consulta;
    }
    public void setValor_consulta(Double valor_consulta) {
            this.valor_consulta = valor_consulta;
    }

    void listar(){
        System.out.println("\nNome do dentista: " + this.dentista.getNome());
        System.out.println("\nNome do paciente: " + this.paciente.getNome());
        System.out.println("\nSituação da Consulta: " + this.status_consulta);
    }
}
