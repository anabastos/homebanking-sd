package homebanking.service;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import homebanking.model.*;

import org.springframework.stereotype.Service;
 
@Service("homebanking")
public abstract class HomeBankingServiceImpl implements HomeBankingService{
     
    private static List<Cliente> clientes;
    private static List<Banco> bancos;
    private static List<ContaCorrente> contas;

    private static final AtomicLong counter = new AtomicLong();
 
    public void update(Cliente cliente) {
        int index = clientes.indexOf(cliente);
        clientes.set(index, cliente);
    }
 
    public void deleteClienteById(long id) {
         
        for (Iterator<Cliente> iterator = clientes.iterator(); iterator.hasNext();) {
            Cliente cliente = iterator.next();
            if (cliente.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean autenticarCliente(Cliente cliente) {
        return findByNome(cliente.getNome()) != null;
    }
     
    // public void deleteAllClientes(){
    //     clientes.clear();
    // }

    public void transferirValor(Cliente cliente1, Cliente cliente2, float valor){
        ContaCorrente conta1 = cliente1.getContaCorrente();
        ContaCorrente conta2 = cliente2.getContaCorrente();
        conta1.setSaldo(conta1.getSaldo() - valor);
        conta2.setSaldo(conta2.getSaldo() + valor);
    }

    public float consultarSaldo(Cliente cliente){
        ContaCorrente conta = cliente.getContaCorrente();
        return conta.getSaldo();
    }

    public void debitoContaCorrente(Cliente cliente, float valor) {
        ContaCorrente conta = cliente.getContaCorrente();
        conta.setSaldo(conta.getSaldo() - valor);
    }

    public void cadastrarBanco(String nome){
        long id = counter.incrementAndGet();
        Banco banco = new Banco(id, nome);
        bancos.add(banco);
    };

    public void abrirConta(Cliente cliente) {
        long id = counter.incrementAndGet();
        ContaCorrente conta = new ContaCorrente(id, (float)0);
        contas.add(conta);
        cliente.setContaCorrente(conta);
    }

    public void abrirContaCorrente(Cliente cliente){
        long id = counter.incrementAndGet();
        ContaCorrente conta = new ContaCorrente(id, (float)0);
        contas.add(conta);
        cliente.setContaCorrente(conta);
    };
}