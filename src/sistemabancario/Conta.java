package sistemabancario;

import sistemabancario.enums.*;

import java.util.Random;

public abstract class Conta {
    private int numConta;
    private String dono;
    private float saldo;
    private boolean status;
    private int senha;



    public Conta() {
        this.status = false;
        this.saldo = 0.0f;
    }

    public abstract ResultadoSaque sacar(float v, String saqEspecial);

    public abstract void bonusAbertura();

    public boolean temSaqueEspecial(){
        return false;
    }

    public boolean autenticar(int numConta, int senha){
        return this.numConta == numConta && this.senha == senha;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }


    public void setSenha(int senha) {
        this.senha = senha;
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


    public ResultadoAbertura abrirConta(String dono, int senha) {
        if (!this.status) {
            Random rand = new Random();
            this.numConta = rand.nextInt(900000) + 100000;

           this.senha = senha;
           this.dono = dono;
           this.status = true;
           this.bonusAbertura();

           return ResultadoAbertura.SUCESSO;

        } else {
            return ResultadoAbertura.CONTA_JA_EXISTE;

        }

    }


    public ResultadoFechamento fecharConta() {
        if(!this.status) {
            return ResultadoFechamento.CONTA_INEXISTENTE;
        }
        if (this.saldo < 0f) {
            return ResultadoFechamento.DEBITO_PENDENTE;
        }
        if (this.saldo > 0f) {
           return ResultadoFechamento.SALDO_POSITIVO;
        }

        this.status = false;
        return ResultadoFechamento.SUCESSO;

    }

    public ResultadoDeposito depositar(float v) {
        if (!this.status) {
            return  ResultadoDeposito.CONTA_INEXISTENTE;

        }
        this.saldo += v;
        return ResultadoDeposito.SUCESSO;

    }

    public ResultadoStatus statusConta() {
        if (this.status) {
            return  ResultadoStatus.SUCESSO;

        }

        return ResultadoStatus.CONTA_INEXISTENTE;
    }


}
