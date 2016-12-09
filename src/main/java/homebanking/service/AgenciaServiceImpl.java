package homebanking.service;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import homebanking.model.*;

import org.springframework.stereotype.Service;
 
@Service("agenciaService")
public abstract class AgenciaServiceImpl implements AgenciaService {
	private static List<ContaCorrente> contas;
	private static ContaCorrente conta;
	private static final AtomicLong counter = new AtomicLong();
	
    public void fecharConta(long numero) {
         
        for (Iterator<ContaCorrente> iterator = contas.iterator(); iterator.hasNext(); ) {
            ContaCorrente conta = iterator.next();
            if (conta.getNumero() == numero) {
                iterator.remove();
            }
        }
    }

	public void abrirConta(Cliente cliente) {
		long id = counter.incrementAndGet();
		ContaCorrente conta = new ContaCorrente(id, (float)0);
		contas.add(conta);
		cliente.setContaCorrente(conta);
	}
}


