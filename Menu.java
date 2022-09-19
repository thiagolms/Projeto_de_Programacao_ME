import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        Scanner dados = new Scanner(System.in);
        int opc;
        String cro, nome, cpf, endereco, flag_consulta;
        Date data_nascimento, data_cadastro, data_consulta, hora_consulta;

        Dentista novoDentista = new Dentista();
        Paciente novoPaciente = new Paciente();
        Cadastro novoCadastro = new Cadastro();
        Consulta novaConsulta = new Consulta();
        
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
                    data_nascimento = formatoData.parse(dados.next());
                    System.out.println("\nDigite a Data do Cadastro: ");
                    data_cadastro = formatoData.parse(dados.next());
                    novoDentista = new Dentista(cro, nome, data_nascimento, data_cadastro);
                    novoCadastro.insereDentista(novoDentista); //Um novo dentista é criado e armazenado
                    break;
                case 2:         //CADASTRANDO PACIENTE
                    System.out.println("\nDigite o CPF do Paciente: ");
                    cpf = dados.nextLine();
                    System.out.println("\nDigite o Nome do Paciente: ");
                    nome = dados.nextLine();
                    System.out.println("\nDigite a Data de Nascimento do Paciente: ");
                    data_nascimento = formatoData.parse(dados.nextLine());
                    System.out.println("\nDigite a Data do Cadastro do Paciente: ");
                    data_cadastro = formatoData.parse(dados.nextLine());
                    System.out.println("\nDigite o Endereço do Paciente: ");
                    endereco = dados.nextLine();
                    novoPaciente = new Paciente(cpf, nome, data_nascimento, data_cadastro, endereco);
                    novoCadastro.inserePaciente(novoPaciente); //Um novo paciente é criado e armazenado
                    break;
                case 3:
                    novoCadastro.listarDentista(); //Lista os dentistas cadastrados
                    Dentista dentistaNomeObj = null;
                    Paciente pacienteNomeObj = null;
                    System.out.println("\nDigite o nome do Dentista Cadastrado: ");
                    String dentistaNome = dados.nextLine();
                    System.out.println("\nDigite o Nome do Paciente: ");
                    String pacienteNome = dados.nextLine();
                    System.out.println("\nDigite a Data da Consulta do Paciente dd/MM/yyyy: ");
                    data_consulta = formatoData.parse(dados.nextLine());
                    System.out.println("\nDigite a Hora da Consulta: ");
                    hora_consulta = formatoHora.parse(dados.nextLine());
                    System.out.println("\nÉ a sua primeira consulta? sim ou não: ");
                    flag_consulta = dados.nextLine();

                    for (Dentista dentista  : novoCadastro.listaDentista) { //Cadastro de Consultas
                        if(dentista.getNome().equals(dentistaNome)){
                            dentistaNomeObj = dentista;
                        }
                    }
                    for (Paciente paciente : novoCadastro.listaPaciente) {  //passa o dado recebido para ser cadastrado em consulta.
                        if(paciente.getNome().equals(pacienteNome)){        //Não pode cadastrar se Paciente e Dentista estiver vazio
                            pacienteNomeObj = paciente;
                        }
                    }
                    if (dentistaNomeObj != null && dentistaNomeObj != null){ //verifica se o obj está vazio, caso não seja ele cadastra a consulta
                        novaConsulta = new Consulta(dentistaNomeObj, pacienteNomeObj, data_consulta, hora_consulta, flag_consulta);
                        novoCadastro.insereConsulta(novaConsulta);
                        novaConsulta.setStatus_consulta("Agendada");
                    }
                    break;
                case 4:
                    novoCadastro.listarConsulta(); //Entra com os dados para realizar o filtro e cancelamento de consulta
                    System.out.println("Para cancelar digite: \nInsira CPF\nData da consulta\nCRO do Dentista");
                    novoCadastro.cancelar(dados.nextLine(), formatoData.parse(dados.nextLine()), dados.nextLine());
                    break;
                case 5:
                    System.out.println("Relatório de Consultas Agendadas");
                    System.out.println("Digite a Data e o CRO da Consulta: ");
                    novoCadastro.relatorioConsultas(formatoData.parse(dados.nextLine()), dados.nextLine()); //Relatorio de Consultas agendadas por data
                    break;
                case 6:
                    System.out.println("Relatório Financeiro");
                    System.out.println("Digite a Data para acessar as consultas e valores: ");
                    novoCadastro.relatorioFinanceiro(formatoData.parse(dados.nextLine())); //Relatorio Financeiro filtrado por data
                    break;
                case 0:
                    System.out.println("\nSaindo..."); //finaliza o programa
                    break;
            }
        } while (opc != 0);
    dados.close();
    }
}
