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
    void insereConsulta(Consulta novaConsulta){ //Adiciona uma Consulta nova la lista
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
                consultaNaLista.setStatus_consulta("Cancelada");
                System.out.println("Consulta Cancelada!");
            }
        }
    }  
    void relatorioConsultas(Date data, String cro){ //filtra por data e cro e printa caso estejam iguais ao cadastro.
        for (Consulta consultaNaLista:listaConsulta){
            if(consultaNaLista.getData_consulta().equals(data) && (consultaNaLista.getDentista().getCro().equals(cro))){
                System.out.println("\nRelatorio de Consultas Agendadas: " + 
                "\nData da consulta: " + consultaNaLista.getData_consulta() +"\nNome do Dentista: " + consultaNaLista.getDentista().getNome() + 
                "\nCRO do Dentista: " + consultaNaLista.getDentista().getCro() + "\nNome do Paciente: " + consultaNaLista.getPaciente().getNome());
            }
        }
    }
    void relatorioFinanceiro(Date data){ //filtra por Data e caso a data e a flag seja "sim" irá setar o valor como 350 e multiplicar pelo tamanho da lista consulta
        for (Consulta consultaNaLista:listaConsulta){
            if(consultaNaLista.getData_consulta().equals(data) && (consultaNaLista.getFlag_consulta().equals("sim"))){
                consultaNaLista.setValor_consulta(350.00 * listaConsulta.size());
                System.out.println("\nLista de Consultas da data: " + consultaNaLista);
                System.out.println("\nRelatorio Financeiro da data:" + consultaNaLista.getValor_consulta());
            }
        }
    }
}
