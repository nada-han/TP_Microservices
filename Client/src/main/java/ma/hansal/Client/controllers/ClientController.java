package ma.hansal.Client.controllers;

import ma.hansal.Client.entities.Client;
import ma.hansal.Client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @GetMapping("/client/{id}")
    public Client findById(@PathVariable Long id) throws Exception{
        return this.clientRepository.findById(id).orElseThrow(() -> new Exception("Client inexistant"));
    }

    @Bean
    CommandLineRunner initialiserBaseH2(ClientRepository clientRepository){
        return args -> {
            clientRepository.save(new Client(Long.parseLong("1"), "Nada HANSAL", Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("2"), "El Mehdi HANSAL", Float.parseFloat("14")));
            clientRepository.save(new Client(Long.parseLong("3"), "Oussama HANSAL", Float.parseFloat("29")));
        };
    }
}