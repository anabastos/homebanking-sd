package homebanking;

// import javax.persistence.*;

import java.util.Set;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document (collection = "banco")
public class Banco {

    @Id private Long codigo;
	private String nome;
	//private SetAgencia> agencias;

	protected Banco() {}

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
	// public Set<Agencia> getAgencias() {
	// 	return agencias;
	// }

	// public void setAgencias(Set<Agencia> agencias) {
	// 	this.agencias = agencias;
	// }

	@Override
	public String toString() {
		return "Banco " + codigo + ": "  + nome;
	}
}