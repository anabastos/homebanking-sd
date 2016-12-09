package homebanking.service;

import java.util.List;
import homebanking.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;

//@Service("agencia")
public interface AgenciaService extends MongoRepository<Agencia, String> {

	Agencia save(long codigo, String endereco, String nome);
	void fecharConta();
	void abrirConta(String endereco, String nome);
}
