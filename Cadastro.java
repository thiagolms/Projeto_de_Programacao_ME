import java.util.ArrayList;
import java.util.Date;

public class Cadastro {
    ArrayList<Dentista> listaDentista;
    ArrayList<Paciente> listaPaciente;
    ArrayList<Consulta> listaConsulta;
    
    public Cadastro(){ //Listas
        this.listaDentista = new ArrayList<>();
        this.listaPaciente = new ArrayList<>();
        this.listaConsulta = new ArrayList<>();
    }
    void insereDentista(Dentista novoDentista){ //Adiciona um Dentista novo na lista
        listaDentista.add(novoDentista);
    }
    void inserePaciente(Paciente novoPaciente){ //Adiciona um Paciente novo na lista
        listaPaciente.add(novoPaciente);
    }
    void insereConsulta(Consulta novaConsulta){
            listaConsulta.add(novaConsulta);
    }
    void listarDentista(){ //Lista cada Dentista cadastrado
        System.out.println("\nLista de Dentistas cadastrados:");
        if(listaDentista.isEmpty() == true){
            System.out.println("Nenhum dentista cadastrado!");
        } else { 
            for(Dentista dentistaNaLista:listaDentista){
                dentistaNaLista.listar();
                }
            }
    }
    void listarPaciente(){ //Lista cada Paciente cadastrado
        System.out.println("\nLista de Pacientes cadastrados:");

        for(Paciente pacienteNaLista:listaPaciente){
            pacienteNaLista.listar();
        }
    }
    void listarConsulta(){ //Lista de Consultas cadastradas
        System.out.println("\nLista de Consultas Marcadas:");
        if(listaConsulta.isEmpty() == true){
            System.out.println("Nenhuma Consulta Cadastrada!");
        } else {
            for (Consulta consultaNaLista:listaConsulta) {
                consultaNaLista.listar();
            }
        }
    }
    void cancelar(String cpf, Date data_consulta, String cro){ //Filtra por cpf, data da consulta e cro e muda o status da consulta para "Cancelada"
        for(Consulta consultaNaLista:listaConsulta){
            if(consultaNaLista.getPaciente().getCpf().equals(cpf) && (consultaNaLista.getData_consulta().equals(data_consulta)) &&
            (consultaNaLista.getDentista().getCro().equals(cro))){
                consultaNaLista.setFlag_consulta("Cancelada");
                System.out.println("Consulta Cancelada!");
            }
        }
    }  
    void relatorioConsultas(Date data, String cro){
        for (Consulta consultaNaLista:listaConsulta){
            if(consultaNaLista.getData_consulta().equals(data) && (consultaNaLista.getDentista().getCro().equals(cro))){
                System.out.println("\nRelatorio de Consultas Agendadas: " + 
                consultaNaLista.getData_consulta() + consultaNaLista.getDentista().getCro());
            }
        }
    }
    void relatorioFinanceiro(Date data){
        for (Consulta consultaNaLista:listaConsulta){
            if(consultaNaLista.getData_consulta().equals(data)){
                System.out.println("\nLista de Consultas da data: " + consultaNaLista.getData_consulta());
                System.out.println("\nRelatorio Financeiro da data:" + consultaNaLista.getValor_consulta());
            }
        }
    }
}
