package homebanking;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Id;
import java.util.*;

@Document (collection = "agencia")
public class Agencia {

    @Id
    private Long id;

    private String nome;
    private String endereco;
    private String senha;

    @Field("banco")
    private Banco banco;

    //nao precisa de one to many pq ele ja ve q eh 1-x
    @Field("contas")
    @DBRef
    private Set<ContaCorrente> contas = new HashSet<ContaCorrente>();

    protected Agencia() {}

    @PersistenceConstructor
    public Agencia(String nome, String endereco, Banco banco) {
        this.nome = nome;
        this.endereco = endereco;
        this.banco = banco;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    // public void setAgencia(Agencia agencia) {
    //     this.agencia = agencia;
    // }
    // @ManyToOne
    // @JoinColumn(name = "codigo")
    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    // @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL)
    public Set<ContaCorrente> getContas() {
     return Collections.unmodifiableSet(contas);
    }

    public void abrirContaCorrente(){

    }

    public void fecharContaCorrente(){

    }

    @Override
    public String toString() {
        return "Agencia " + id + ": "  + nome + "(" + endereco + ")";
    }
}

