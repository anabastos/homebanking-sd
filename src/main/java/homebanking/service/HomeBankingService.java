package homebanking.service;
 
import java.util.List;
import homebanking.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
 
public interface HomeBankingService extends MongoRepository<Cliente, String>{
     
    Cliente findById(long id);
    List<Cliente> findByNome(String name);
    List<Cliente> findByCpf(String name);
    List<Cliente> findAll(); 
    void update(Cliente cliente);
    Cliente save(long id, String nome, String cpf, String senha);
    void deleteClienteById(long id);

    public boolean autenticarCliente(Cliente cliente);
    float consultarSaldo(Cliente cliente);
    void transferirValor(Cliente cliente1, Cliente cliente2, float valor);

    void abrirContaCorrente(Cliente cliente);
    void debitoContaCorrente(Cliente cliente, float valor);
    void cadastrarBanco(String nome);
}