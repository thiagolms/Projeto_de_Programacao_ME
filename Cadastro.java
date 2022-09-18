import java.util.ArrayList;

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
      
}
