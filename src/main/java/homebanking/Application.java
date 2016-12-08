package homebanking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private HomeBanking repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		repository.save(new Cliente("Jack", "Bauer", "23"));
		repository.save(new Cliente("Chloe", "O'Brian", "23"));
		repository.save(new Cliente("Kim", "Bauer", "23"));
		repository.save(new Cliente("David", "Palmer", "23"));
		repository.save(new Cliente("Michelle", "Dessler", "23"));

			// fetch all clientes
		System.out.println("Clientes found with findAll():");
		System.out.println("-------------------------------");
		for (Cliente cliente : repository.findAll()) {
			System.out.println(cliente);
		}
		System.out.println("");

			// fetch clientes by last name
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