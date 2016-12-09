package homebanking.service;

import java.util.List;
import homebanking.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HomeBanking extends MongoRepository<Cliente, String> {

	//transerir valor
	//consultar saldo
	//autenticar cliente
	//abrir conta corrente
	//cadastrar banco
	public List<Cliente> findByCpf(String cpf);
    public List<Cliente> findByNome(String nome);
}
