package homebanking;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
// import javax.persistence.*;

@Document (collection = "agencia")
public class Agencia {

    @Id
    private Long id;

    private String nome;
    private String endereco;
    private String senha;
    private Banco banco;

    // @DBRef
    // private Collection<ContaCorrente> contas;

    protected Agencia() {}

    public Agencia(String nome, String endereco, Banco banco) {
        this.nome = nome;
        this.endereco = endereco;
        // this.banco = banco;
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
    // public Collection<ContaCorrente> getContas() {
    //  return contas;
    // }

    // public void setAgencias(Collection<ContaCorrente> contas) {
    //  this.contas = contas;
    // }

    public void abrirContaCorrente(){

    }

    public void fecharContaCorrente(){

    }

    @Override
    public String toString() {
        return "Agencia " + id + ": "  + nome + "(" + endereco + ")";
    }
}

