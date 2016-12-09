package homebanking;

// import javax.persistence.*;

import java.util.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Id;

@Document (collection = "banco")
public class Banco {

    @Id private Long codigo;
	private String nome;

	@Field("agencias")
	@DBRef
	private Set<Agencia> agencias = new HashSet<Agencia>();

	protected Banco() {}

	@PersistenceConstructor
	public Banco(String nome) {
		this.nome = nome;
	}

	public Long getCodigo(){
		return codigo;
	}

	public void setCodigo(Long codigo){
		this.codigo = codigo;
	}

	public String getNome(){
		return nome;
	}

	public void setNome(String saldo){
		this.nome = nome;
	}

	// @OneToMany(mappedBy = "banco", cascade = CascadeType.ALL)
	public Set<Agencia> getAgencias() {
		return Collections.unmodifiableSet(agencias);
	}

	@Override
	public String toString() {
		return "Banco " + codigo + ": "  + nome;
	}
}