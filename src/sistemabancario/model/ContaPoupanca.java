package sistemabancario.model;

import sistemabancario.enums.ResultadoSaque;

public class ContaPoupanca extends Conta {

    @Override
    public ResultadoSaque sacar(float v, String saqEspecial) {
        if(v <= this.getSaldo()){
            this.setSaldo(this.getSaldo() - v);
            return ResultadoSaque.SUCESSO;
        }

        return ResultadoSaque.SALDO_INSUFICIENTE;

    }

    @Override
    public void bonusAbertura() {
        this.setSaldo(getSaldo() + 100);
    }
}
