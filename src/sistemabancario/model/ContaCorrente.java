package sistemabancario.model;

import sistemabancario.enums.ResultadoSaque;

public class ContaCorrente extends Conta {

    @Override
    public ResultadoSaque sacar(float v, String saqEspecial) {
        if(v <= this.getSaldo()){
            this.setSaldo(this.getSaldo() - v);
            return ResultadoSaque.SUCESSO;

        } else if (v <= this.getSaldo() + 100){
            if(saqEspecial.equalsIgnoreCase("SIM")){
                this.setSaldo(this.getSaldo() + 100);
                this.setSaldo(this.getSaldo() - v);
                    return ResultadoSaque.SUCESSO;
            } else {
                return ResultadoSaque.SALDO_INSUFICIENTE_SEM_ESPECIAL;
            }
        } else {
            return ResultadoSaque.SALDO_INSUFICIENTE;
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
