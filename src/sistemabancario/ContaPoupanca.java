package sistemabancario;

public class ContaPoupanca extends Conta {

    @Override
    public void sacar(float v, String saqEspecial) {
        if(v <= this.getSaldo()){
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void bonusAbertura() {
        this.setSaldo(getSaldo() + 100);
    }
}
