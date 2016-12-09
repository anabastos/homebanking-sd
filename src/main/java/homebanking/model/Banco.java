package homebanking.model;

import java.util.*;
import javax.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Id;

@Document (collection = "banco")
public class Banco {

    @Id private long codigo;
	private String nome;

	@Field("agencias")
	@DBRef
	private Set<Agencia> agencias = new HashSet<Agencia>();

	protected Banco() {}

	@PersistenceConstructor
	public Banco(long id, String nome) {
		this.codigo = id;
		this.nome = nome;
	}

	public long getCodigo(){
		return codigo;
	}

	public void setCodigo(long codigo){
		this.codigo = codigo;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String saldo){
		this.nome = nome;
	}

	public Set<Agencia> getAgencias() {
		return Collections.unmodifiableSet(agencias);
	}

	@Override
	public String toString() {
		return "Banco " + codigo + ": "  + nome;
	}
}