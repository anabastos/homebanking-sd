package homebanking.service;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import homebanking.model.Cliente;
 
import org.springframework.stereotype.Service;
 
@Service("clienteService")
public abstract class ClienteServiceImpl implements ClienteService{
     
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<Cliente> clientes;
     
    static{
        clientes= populateDummyClientes();
    }
 
    public List<Cliente> findAllClientes() {
        return clientes;
    }
     
    public Cliente findById(long id) {
        for(Cliente cliente : clientes){
            if(cliente.getId() == id){
                return cliente;
            }
        }
        return null;
    }
     
    public Cliente findByNome(String nome) {
        for(Cliente cliente : clientes){
            if(cliente.getNome().equalsIgnoreCase(nome)){
                return cliente;
            }
        }
        return null;
    }
     
    public void saveCliente(Cliente cliente) {
        cliente.setId(counter.incrementAndGet());
        clientes.add(cliente);
    }
 
    public void updateCliente(Cliente cliente) {
        int index = clientes.indexOf(cliente);
        clientes.set(index, cliente);
    }
 
    public void deleteClienteById(long id) {
         
        for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext(); ) {
            Cliente cliente = iterator.next();
            if (cliente.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isClienteExist(Cliente cliente) {
        return findByNome(cliente.getNome())!=null;
    }
     
    public void deleteAllClientes(){
        clientes.clear();
    }
 
    private static List<Cliente> populateDummyClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com"));
        clientes.add(new Cliente(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com"));
        clientes.add(new Cliente(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com"));
        return clientes;
    }
 
}