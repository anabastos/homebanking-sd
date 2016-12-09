package homebanking.service;

import java.util.List;
import homebanking.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;

//@Service("contaCorrente")
public interface ContaCorrenteService extends MongoRepository<ContaCorrente, String> {

	List<ContaCorrente> findByNumero(long numero);
	ContaCorrente save(long numero, float saldo);
	void depositar(ContaCorrente conta, float valor);
	void retirar(ContaCorrente conta, float valor);
}
