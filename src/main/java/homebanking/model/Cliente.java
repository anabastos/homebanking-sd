package homebanking;

// import javax.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Id;

@Document (collection = "cliente")
public class Cliente {

    @Id
    private String id;

    private String nome;
    private String cpf;
    private String senha;
    @Field("conta_corrente")
    private ContaCorrente contaCorrente;

    protected Cliente() {}

    @PersistenceConstructor
    public Cliente(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public ContaCorrente getContaCorrente(){
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente senha){
        this.contaCorrente = contaCorrente;
    }
    
    @Override
    public String toString() {
        return "Cliente " + id + ": "  + nome + "(" + cpf + ")";
    }
}

