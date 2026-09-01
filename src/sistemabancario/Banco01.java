package sistemabancario;

import sistemabancario.enums.*;

import java.util.Scanner;

public class Banco01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String menu;
        Conta c1 = null;

        System.out.println("========Bem vindo ao Banco LB!========");

      do {
          System.out.println("   Escolha uma das opções abaixo: ");
          System.out.println("[1] ABRIR NOVA CONTA");
          System.out.println("[2] FECHAR CONTA");
          System.out.println("[3] DEPOSITAR VALOR");
          System.out.println("[4] SACAR VALOR");
          System.out.println("[5] INFORMAÇÕES DA CONTA");
          System.out.println("[6] SAIR");
          System.out.println();
          System.out.print("DIGITE A OPÇÃO DESEJADA: ");
          menu = input.nextLine();

          switch (menu) {


              case "1":
                  if (c1 == null || !c1.getStatus()) {
                      String tipo = escolherTipoConta(input);
                      System.out.println("Digite seu nome: ");
                      String dono = input.nextLine();

                      int senha = 0, senha2 = 1;

                      while (senha2 != senha) {
                          System.out.println("Digite sua senha: ");
                          senha = Integer.parseInt(input.nextLine());
                          System.out.println("Confirme sua senha: ");
                          senha2 = Integer.parseInt(input.nextLine());
                          if (senha != senha2) {
                              System.out.println("Senhas diferentes! Tente novamente");
                          }
                      }
                      System.out.println("Senha cadastrada com sucesso!");

                      if(tipo.equalsIgnoreCase("Conta corrente")){
                          c1 = new ContaCorrente();
                      } else {
                          c1 = new ContaPoupanca();
                      }

                      ResultadoAbertura resultadoAbertura = c1.abrirConta(dono, senha);
                      switch (resultadoAbertura) {
                          case SUCESSO -> {
                              System.out.println("Conta gerada com sucesso!");
                              System.out.println("Aqui esta o numero gerado da sua conta: " + c1.getNumConta());
                          }
                          case CONTA_JA_EXISTE -> System.out.println("Conta ja existente!");
                      }
                      System.out.println("Agora vamos fazer seu primeiro deposito");
                      System.out.print("Digite o valor do deposito: ");
                      float v = Float.parseFloat(input.nextLine());
                      ResultadoDeposito resultadoDeposito = c1.depositar(v);
                      switch (resultadoDeposito) {
                          case SUCESSO -> System.out.println("Deposito realizado com sucesso!");
                          case CONTA_INEXISTENTE -> System.out.println("Conta inexistente!");
                      }


                  } else {
                      System.out.println("Conta já cadastrada!");
                  }
                  break;


              case "2" :
                  if (c1 != null) {

                      if (autenticacaoUsuario(c1, input)) {
                          ResultadoFechamento resultado = c1.fecharConta();
                          switch (resultado) {
                              case SUCESSO -> System.out.println("Conta fechada com sucesso!");
                              case CONTA_INEXISTENTE -> System.out.println("Você não tem nenhuma conta existente!");
                              case DEBITO_PENDENTE -> System.out.println("Não é possível fechar: há valores a pagar!");
                              case SALDO_POSITIVO -> System.out.println("Não é possível fechar: existe saldo disponível!");
                          }
                      }
                  } else {
                      System.out.println("Conta não cadastrada.");
                  }
                  break;

              case "3" :
                  if (c1 != null) {

                      if (autenticacaoUsuario(c1, input)) {
                          System.out.print("Digite o valor a ser depositado na sua conta: ");
                          float v = Float.parseFloat(input.nextLine());
                          ResultadoDeposito resultado = c1.depositar(v);
                          switch (resultado) {
                              case SUCESSO ->{
                                  System.out.println("Deposito realizado com sucesso!");
                                  System.out.println("Seu saldo atual é: " + c1.getSaldo() + " R$");
                              }
                              case CONTA_INEXISTENTE -> System.out.println("Conta inexistente!");
                          }

                      }
                  } else {
                      System.out.println("Conta nao cadastrada.");
                  }
                  break;


              case "4" :
                  if (c1 != null && c1.getStatus()) {

                      if (autenticacaoUsuario(c1, input)) {
                          System.out.print("Qual o valor do saque: ");
                          float v = Float.parseFloat(input.nextLine());

                          String saq = "";
                          if (c1.temSaqueEspecial()){
                              System.out.println("Deseja utilizar se necessario o saque especial?");
                              saq = input.nextLine();
                          }

                          ResultadoSaque resultado = c1.sacar(v, saq);
                          switch (resultado) {
                              case SUCESSO -> System.out.println("Saque realizado com Sucesso!");
                              case SALDO_INSUFICIENTE -> System.out.println("Saldo insuficiente!");
                              case SALDO_INSUFICIENTE_SEM_ESPECIAL -> System.out.println("Saque não realizado. Saldo insuficiente sem o uso do saque especial.");

                          }
                      }
                  } else {
                      System.out.println("Conta nao cadastrada.");
                  }
                  break;

              case "5" :
                  if (c1 != null && c1.getStatus()) {
                      if (autenticacaoUsuario(c1, input)) {
                          ResultadoStatus resultado = c1.statusConta();
                          switch (resultado) {
                              case SUCESSO -> {
                                  System.out.println("Nome: " + c1.getDono());
                                  System.out.println("Tipo de conta: " + c1.getClass().getSimpleName());
                                  System.out.println("Número da conta: " + c1.getNumConta());
                                  System.out.println("Saldo: " + c1.getSaldo());

                              }
                              case CONTA_INEXISTENTE -> System.out.println("Conta inexistente!");
                          }
                      }
                  } else {
                      System.out.println("Conta nao cadastrada.");
                  }
                  break;


              case "6" :
                  System.out.println("Saindo do programa!");
                  break;

              default:
                  System.out.println("Escolha uma das opções apresentadas!");
                  System.out.println("Aperte ENTER para voltar ao menu");
                  break;
          }


      } while (!menu.equals("6"));

    }

    public static boolean autenticacaoUsuario(Conta c1, Scanner input){
        int contador = 0;
        while (contador <= 3) {
            System.out.println("Digite numero da conta: ");
            int conta = Integer.parseInt(input.nextLine());
            System.out.println("Digite sua senha ");
            int senha = Integer.parseInt(input.nextLine());

            if (c1.autenticar(conta, senha)) {
                System.out.println("Autenticação feita com sucesso!");
                return true;


            } else {
                System.out.println("Tente novamente");
                System.out.println("Tentativas restantes: " + (3 - contador));
                contador++;

            }
        }
        System.out.println("Tentativas esgotadas!");
        return false;
    }

    public static String escolherTipoConta(Scanner input){
        String tipo = "";
        while (!tipo.equals("Conta corrente") && (!tipo.equals("Conta poupança"))){
            System.out.println("Escolha sua conta: ");
            System.out.println("[1] Conta corrente ");
            System.out.println("[2] Conta poupança");
            String opcao = input.nextLine();

            if (opcao.equals("1")){
                tipo = "Conta corrente";
            } else if (opcao.equals("2")){
                tipo = "Conta poupança";
            } else {
                System.out.println("OPÇÃO INVALIDA! TENTE NOVAMENTE!");
            }
        }
        return tipo;

    }
}