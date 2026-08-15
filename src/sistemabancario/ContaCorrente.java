package sistemabancario;

public class ContaCorrente extends Conta {

    @Override
    public void sacar(float v,String saqEspecial) {
        if(v <= this.getSaldo()){
            this.setSaldo(this.getSaldo() - v);
            System.out.println("Saque realizado com sucesso!");

        } else if (v <= this.getSaldo() + 100){
            if(saqEspecial.equalsIgnoreCase("SIM")){
                this.setSaldo(this.getSaldo() + 100);
                this.setSaldo(this.getSaldo() - v);
                System.out.println("Saque realizado com sucesso!");
            }
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }

    @Override
    public void bonusAbertura() {
        this.setSaldo(getSaldo() + 50);
    }

    @Override
    public boolean temSaqueEspecial() {
        return true;
    }
}
