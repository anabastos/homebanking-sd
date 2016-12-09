package homebanking.service;
 
import java.util.List;
import homebanking.model.Cliente;

 
public interface ClienteService {
     
    Cliente findById(long id);
     
    Cliente findByNome(String name);

    Cliente findByCpf(String cpf);

    void saveCliente(Cliente cliente);
     
    void updateCliente(Cliente cliente);
     
    void deleteClienteById(long id);
 
    List<Cliente> findAllClientes(); 
     
    void deleteAllClientes();
     
    public boolean isClienteExist(Cliente cliente);
     
}