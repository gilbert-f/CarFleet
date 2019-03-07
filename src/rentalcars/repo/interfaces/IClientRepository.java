package rentalcars.repo.interfaces;

import java.util.List;
import rentalcars.model.Client;

public interface IClientRepository {
   void CreateClient(Client client);
   Client GetClient(String licenseNumber);
   void UpdateClient(Client client);
   void DeleteClient(Client client);
   void DeleteClient(String licenseNumber);
   List<Client> SearchClients(Client query);
}