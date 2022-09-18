import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Scanner dados = new Scanner(System.in);
        int opc;
        String cro, nome, cpf, endereco;
        Date data_nascimento, data_cadastro;

        Dentista novoDentista = new Dentista();
        Paciente novoPaciente = new Paciente();
        Cadastro novoCadastro = new Cadastro();
        
        do {    //MENU
            System.out.println("----------MENU----------");
            System.out.println("Escolha uma opção");
            System.out.println("1 - Cadastrar Dentista");
            System.out.println("2 - Cadastrar Paciente");
            System.out.println("3 - Cadastrar Consulta");
            System.out.println("4 - Cancelar Consultas");
            System.out.println("5 - Consultas Agendadas");
            System.out.println("6 - Relatório Financeiro");
            System.out.println("0 - Sair");

            opc = dados.nextInt();
            dados.nextLine();

            switch (opc) { 
                case 1:         //CADASTRANDO DENTISTA
                    System.out.println("\nDigite CRO do Dentista: ");
                    cro = dados.nextLine();
                    System.out.println("\nDigite o nome do Dentista: ");
                    nome = dados.nextLine();
                    System.out.println("\nDigite a Data de Nascimento: ");
                    data_nascimento = formato.parse(dados.next());
                    System.out.println("\nDigite a Data do Cadastro: ");
                    data_cadastro = formato.parse(dados.next()); 
                    novoDentista = new Dentista(cro, nome, data_nascimento, data_cadastro);
                    novoCadastro.insereDentista(novoDentista); //Um novo dentista é criado e armazenado
                    break;
                case 2:         //CADASTRANDO PACIENTE
                    System.out.println("\nDigite o CPF do Paciente: ");
                    cpf = dados.nextLine();
                    System.out.println("\nDigite o Nome do Paciente: ");
                    nome = dados.nextLine();
                    System.out.println("\nDigite a Data de Nascimento do Paciente: ");
                    data_nascimento = formato.parse(dados.next());
                    System.out.println("\nDigite a Data do Cadastro do Paciente: ");
                    data_cadastro = formato.parse(dados.next());
                    System.out.println("\nDigite o Endereço do Paciente: ");
                    endereco = dados.nextLine(); 
                    novoPaciente = new Paciente(cpf, nome, data_nascimento, data_cadastro, endereco);
                    novoCadastro.inserePaciente(novoPaciente); //Um novo paciente é criado e armazenado
                    break;
                case 3:
                    novoCadastro.listarDentista();
                    
                    break;
                case 4:

                    break;
                case 5:
                    novoCadastro.listarDentista();
                    break;
                case 6:
                    break;
                case 0:
                    System.out.println("\nSaindo...");
                    break;
            }
        } while (opc != 0);
    dados.close();
    }
}
