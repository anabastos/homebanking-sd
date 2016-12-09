package homebanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.concurrent.atomic.AtomicLong;
import homebanking.model.Cliente;
import homebanking.service.HomeBanking;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private static final AtomicLong counter = new AtomicLong();

	@Autowired
	private HomeBanking repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		repository.save(new Cliente(counter.incrementAndGet(),"Jack", "Bauer", "23"));
		repository.save(new Cliente(counter.incrementAndGet(),"Chloe", "O'Brian", "23"));
		repository.save(new Cliente(counter.incrementAndGet(),"Kim", "Bauer", "23"));
		repository.save(new Cliente(counter.incrementAndGet(),"David", "Palmer", "23"));
		repository.save(new Cliente(counter.incrementAndGet(),"Michelle", "Dessler", "23"));

		System.out.println("Clientes found with findAll():");
		System.out.println("-------------------------------");
		for (Cliente cliente : repository.findAll()) {
			System.out.println(cliente);
		}
		System.out.println("");

		System.out.println("Cliente found with findByCpf('Bauer'):");
		System.out.println("--------------------------------------------");
		for (Cliente customer : repository.findByCpf("Bauer")) {
			System.out.println(customer);
		}

			// System.out.println("Cliente found with findByName 'Jack'):");
			// System.out.println("--------------------------------------------");
			// for (Cliente jack : repository.findByNome("Jack")) {
			// 	System.out.println(jack.toString());
			// }
	}
}