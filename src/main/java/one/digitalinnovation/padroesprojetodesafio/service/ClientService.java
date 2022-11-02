package one.digitalinnovation.padroesprojetodesafio.service;

import one.digitalinnovation.padroesprojetodesafio.model.Client;

/**
 * Esta interface define o padrão <b>Strategy</b> no domínio de cliente. Com isso se necessário, podemos ter
 * múltiplas implementações da mesma interface.
 *
 * @author DanielVisicatto
 */

public interface ClientService {
    Iterable<Client> getAll();
    Client getClientById(Long id);
    void putClient(Client client);
    void update(Long id, Client client);
    void delete(Long id);
}
