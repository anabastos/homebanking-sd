package homebanking;

// import javax.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Id;

@Document (collection = "conta_corrente")
public class ContaCorrente {

    @Id
	private Long numero;
	private float saldo;
	@Field("agencia")
	private Agencia agencia;

	protected ContaCorrente() {}

	@PersistenceConstructor
	public ContaCorrente(float saldo) {
		this.saldo = saldo;
	}

	public Long getNumero(){
		return numero;
	}

	public void setNumero(Long numero){
		this.numero = numero;
	}

	//consultar
	public Float getSaldo(){
		return saldo;
	}

	public void setSaldo(Float saldo){
		this.saldo = saldo;
	}

	public void depositar(Float valor) {
		this.saldo = saldo + valor;
	}

	public void retirar(Float valor) {
		this.saldo = saldo - valor;
	}

    public Agencia getAgencia() {
        return agencia;
    }

	@Override
	public String toString() {
		return "Conta " + numero + ": "  + saldo + "RS";
	}
}