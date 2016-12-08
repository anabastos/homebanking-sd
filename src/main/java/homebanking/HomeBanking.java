package homebanking;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HomeBanking extends MongoRepository<Cliente, String> {

	public List<Cliente> findByCpf(String cpf);
    public List<Cliente> findByNome(String nome);
}
