package homebanking.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
 
import homebanking.service.ClienteService;
import homebanking.model.Cliente;

@RestController
public class HomeBankingRestController {
  
    @Autowired
    ClienteService clienteService; 
  
      
    @RequestMapping(value = "/cliente/", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listAllClientes() {
        List<Cliente> clientes = clienteService.findAllClientes();
        if(clientes.isEmpty()){
            return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);
    }
  
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cliente> getCliente(@PathVariable("id") long id) {
        System.out.println("Fetching Cliente with id " + id);
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            System.out.println("Cliente with id " + id + " not found");
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
  
    @RequestMapping(value = "/cliente/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCliente(@RequestBody Cliente cliente,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Cliente " + cliente.getNome());
  
        if (clienteService.isClienteExist(cliente)) {
            System.out.println("A Cliente with nome " + cliente.getNome() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
  
        clienteService.saveCliente(cliente);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> updateCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {
        System.out.println("Updating Cliente " + id);
          
        Cliente currentCliente = clienteService.findById(id);
          
        if (currentCliente==null) {
            System.out.println("Cliente with id " + id + " not found");
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
  
        currentCliente.setNome(cliente.getNome());
        currentCliente.setCpf(cliente.getCpf());
        currentCliente.setSenha(cliente.getSenha());
          
        clienteService.updateCliente(currentCliente);
        return new ResponseEntity<Cliente>(currentCliente, HttpStatus.OK);
    }
  
    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Cliente with id " + id);
  
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            System.out.println("Unable to delete. Cliente with id " + id + " not found");
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
  
        clienteService.deleteClienteById(id);
        return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
    }
  

    @RequestMapping(value = "/cliente/", method = RequestMethod.DELETE)
    public ResponseEntity<Cliente> deleteAllClientes() {
        System.out.println("Deleting All Clientes");
  
        clienteService.deleteAllClientes();
        return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
    }
  
}