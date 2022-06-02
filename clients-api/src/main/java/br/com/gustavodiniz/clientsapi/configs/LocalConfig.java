package br.com.gustavodiniz.clientsapi.configs;

import br.com.gustavodiniz.clientsapi.models.ClientModel;
import br.com.gustavodiniz.clientsapi.models.ServiceProvidedModel;
import br.com.gustavodiniz.clientsapi.models.UserModel;
import br.com.gustavodiniz.clientsapi.repositories.ClientRepository;
import br.com.gustavodiniz.clientsapi.repositories.ServiceProvidedRepository;
import br.com.gustavodiniz.clientsapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ServiceProvidedRepository serviceProvidedRepository;

    @Bean
    public void startDB() {
        UserModel userModel1 = new UserModel(null, "gustavodinniz", "123456");
        UserModel userModel2 = new UserModel(null, "albertochaves", "123456");
        UserModel userModel3 = new UserModel(null, "marisagomes", "123456");
        UserModel userModel4 = new UserModel(null, "ericadiniz", "123456");
        UserModel userModel5 = new UserModel(null, "marisadiniz", "123456");

        userRepository.saveAll(List.of(userModel1, userModel2, userModel3, userModel4, userModel5));

        ClientModel clientModel1 = new ClientModel(null, "Pedro", "12312322446", LocalDate.now());
        ClientModel clientModel2 = new ClientModel(null, "Jose", "12312322446", LocalDate.now());
        ClientModel clientModel3 = new ClientModel(null, "Marcos", "12312322446", LocalDate.now());
        ClientModel clientModel4 = new ClientModel(null, "Leo", "12312322446", LocalDate.now());
        ClientModel clientModel5 = new ClientModel(null, "Joao", "12312322446", LocalDate.now());

        clientRepository.saveAll(List.of(clientModel1, clientModel2, clientModel3, clientModel4, clientModel5));

        ServiceProvidedModel serviceProvidedModel1 = new ServiceProvidedModel(null, "Formatar notebook", clientModel1, BigDecimal.valueOf(100), LocalDate.now());
        ServiceProvidedModel serviceProvidedModel2 = new ServiceProvidedModel(null, "Upgrade Memoria RAM", clientModel2, BigDecimal.valueOf(500), LocalDate.now());
        ServiceProvidedModel serviceProvidedModel3 = new ServiceProvidedModel(null, "Upgrade SSD", clientModel3, BigDecimal.valueOf(500), LocalDate.now());
        ServiceProvidedModel serviceProvidedModel4 = new ServiceProvidedModel(null, "Trocar tela", clientModel4, BigDecimal.valueOf(1000), LocalDate.now());
        ServiceProvidedModel serviceProvidedModel5 = new ServiceProvidedModel(null, "Teclado com Defeito", clientModel5, BigDecimal.valueOf(250), LocalDate.now());

        serviceProvidedRepository.saveAll(List.of(serviceProvidedModel1, serviceProvidedModel2, serviceProvidedModel3, serviceProvidedModel4, serviceProvidedModel5));
    }
}
