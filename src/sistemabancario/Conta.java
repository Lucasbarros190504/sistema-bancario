package sistemabancario;

import java.util.Random;

public class Conta {
    private int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    private int senha;



    public Conta() {
        this.status = false;
        this.saldo = 0.0f;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public boolean verificarSenha(int senha) {
        return this.senha == senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public boolean abrirConta(String tipo, String dono, int senha) {
        if (!this.status) {
            Random rand = new Random();
            this.numConta = rand.nextInt(900000) + 100000;

           this.senha = senha;
           this.dono = dono;
           this.tipo = tipo;
           this.status = true;
           System.out.println("Aqui esta o numero gerado da sua conta: " + this.numConta);
           System.out.println("Cadastro concluido com sucesso!");
           return true;
        } else {
            System.out.println("Sua conta ja esta criada!");
            return false;

        }

    }


    public void fecharConta() {
        if (this.status) {
            if (this.saldo == 0f) {
                System.out.println("Conta fechada com sucesso!");
                this.status = false;
            } else if (this.saldo < 0f) {
                System.out.println("Não é possivel fazer um fechamento da sua conta,pois existem valores a serem pagos!");
            } else if (this.saldo > 0f) {
                System.out.println("Não é possivel fazer um fechamento da sua conta,pois exite valor existente");

            }
        } else {
            System.out.println("Você não tem nenhuma conta existente!");

        }

    }

    public void depositar(float v) {
        if (this.status) {
            this.saldo += v;
            System.out.println("Deposito realizado com sucesso!");
            System.out.println("Seu saldo atual é: " + this.saldo + "R$");

        } else{
            System.out.println("ERRO!");
            System.out.println("Voce precisa Abrir uma conta primeiro");
        }
    }

    public void sacar(float v) {
        if (this.status) {
            if (this.saldo == 0f) {
                System.out.println("Sua conta nao tem nenhum valor existente");
            } else if (this.saldo > 0f) {
                if (this.saldo - v < 0f) {
                    System.out.println("Voce não tem saldo suficiente para esse saque");
                } else {
                    this.saldo -= v;
                    System.out.println("Saque realizado com sucesso!");
                    System.out.println("Saldo atual: " + this.saldo + "R$");
                }


            }
        } else {
            System.out.println("ERRO!");
            System.out.println("Voce precisa Abrir uma conta primeiro");
        }
    }

    public void pagarMensal() {
        if (this.tipo.equals("Conta corrente")) {
            this.saldo -= 2;
            System.out.println("Voce pagou " + 2 + "R$ referente ao seu tipo de conta escolhido");

        } else if (this.tipo.equals("Conta poupança")) {
            this.saldo -= 3;
            System.out.println("Voce pagou " + 3 + "pelo seu tipo de conta escolhido");

        }
    }

    public void statusConta() {
        if (this.status) {
            System.out.println("NOME: " + getDono());
            System.out.println("TIPO DE CONTA: " + getTipo());
            System.out.println("NUMERO DA CONTA: " + getNumConta());
            System.out.println("SALDO DISPONIVEL: " + getSaldo());

        } else {
            System.out.println("ERRO!");
            System.out.println("Você não tem dados ainda!");
            System.out.println("Voce precisa Abrir uma conta primeiro");
        }
    }


}
