package homebanking.model;

import javax.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Id;

@Document (collection = "conta_corrente")
public class ContaCorrente {

    @Id
	private long numero;
	private float saldo;
	@Field("agencia")
	private Agencia agencia;

	protected ContaCorrente() {}

	@PersistenceConstructor
	public ContaCorrente(long numero, float saldo) {
		this.numero = numero;
		this.saldo = saldo;
	}

	public long getNumero(){
		return numero;
	}

	public void setNumero(long numero){
		this.numero = numero;
	}

	//consultar
	public float getSaldo(){
		return saldo;
	}

	public void setSaldo(float saldo){
		this.saldo = saldo;
	}

    public Agencia getAgencia() {
        return agencia;
    }

	@Override
	public String toString() {
		return "Conta " + numero + ": "  + saldo + "RS";
	}
}