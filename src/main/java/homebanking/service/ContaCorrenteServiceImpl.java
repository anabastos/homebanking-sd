package homebanking.service;
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import homebanking.model.ContaCorrente;

import org.springframework.stereotype.Service;
 
@Service("contaCorrenteService")
public abstract class ContaCorrenteServiceImpl implements ContaCorrenteService {
	
	public void depositar(ContaCorrente conta, float valor) {
		conta.setSaldo(conta.getSaldo() + valor);
	}

	public  void retirar(ContaCorrente conta, float valor) {
		conta.setSaldo(conta.getSaldo() - valor);
	}
}


