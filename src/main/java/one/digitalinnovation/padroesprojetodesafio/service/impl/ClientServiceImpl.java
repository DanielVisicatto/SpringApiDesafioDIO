package one.digitalinnovation.padroesprojetodesafio.service.impl;

import one.digitalinnovation.padroesprojetodesafio.model.Address;
import one.digitalinnovation.padroesprojetodesafio.model.AddressRepository;
import one.digitalinnovation.padroesprojetodesafio.model.Client;
import one.digitalinnovation.padroesprojetodesafio.model.ClientRepository;
import one.digitalinnovation.padroesprojetodesafio.service.ClientService;
import one.digitalinnovation.padroesprojetodesafio.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Implementação da <b>Strategy</b> {@link ClientService}, a qual pode ser injetada pelo Spring
 * (via {@link Autowired}). Com isso como essa classe é um {@link Service}, ela será tratada como um
 * <b>Singleton</b
 *
 * @author DanielVisicatto
 */

@Service
public class ClientServiceImpl implements ClientService {
    // Singleton: Injetar os componentes do Spring com o @Autowired.
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;
    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Client> getAll() {
        // Buscar todos os clientes.
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long id) {
        // Buscar clientes por Id.
        Optional<Client> client = clientRepository.findById(id);
        return client.orElse(null);
    }

    @Override
    public void putClient(Client client) {
        saveClientWithZipCode(client);
    }

    private void saveClientWithZipCode(Client client) {
        // Verificar se o endereço do cliente já existe (pelo cep).
        String zipCode = client.getAddress().getZipCode();
        Address address = addressRepository.findById(zipCode).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Address newAddress = viaCepService.searchZipCode(zipCode);
            addressRepository.save(newAddress);
            return newAddress;
        });
        client.setAddress(address);
        // Inserir cliente, vinculando o endereço (novo ou já existente).
        clientRepository.save(client);
    }

    @Override
    public void update(Long id, Client client) {
        // Buscar cliente por Id caso exista.
        Optional<Client> clientDb = clientRepository.findById(id);
        if(clientDb.isPresent()) {
            // Verificar se o endereço do cliente já existe (pelo CEP).
            // Caso não exista, integrar com o ViaCEP e persistir o retorno
            // Alterar cliente, vinculando o endereço (novo ou já existente).
            saveClientWithZipCode(client);
        }
    }

    @Override
    public void delete(Long id) {
        // Deletar cliente pelo Id.
        clientRepository.deleteById(id);
    }
}
