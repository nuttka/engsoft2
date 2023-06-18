package com.engsoft2.realstate.services;

import com.engsoft2.realstate.entities.User;
import com.engsoft2.realstate.entities.dto.PropertyDTO;
import com.engsoft2.realstate.entities.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

    @Autowired
    private UserService userService;
    @Autowired
    private PropertyService propertyService;
    public void instantiateTestDatabase() {
        UserDTO userDTO1 = new UserDTO(1, "Lucas", "lucas@lucas.com", "lucas123");
        UserDTO userDTO2 = new UserDTO(2, "Luis", "luis@luis.com", "luis123");
        User user1 = userService.create(userDTO1);
        User user2 = userService.create(userDTO2);

        PropertyDTO property1 = new PropertyDTO(0, "Ap 60m2 2 quartos 1 banheiro", "ap bem localizado perto de tudo mt bom mesmo", "https://www.limaonagua.com.br/wp-content/uploads/2015/12/1-sala-branca-cinza-escandinava.jpg",
                "Apartamento", "Venda", "Rua x bairro y SP/SP", 60.05, "11996752344", 1900.0, 1,
                2, 1, true, false, user1.getId());
        PropertyDTO property2 = new PropertyDTO(0, "Casa pra um bom comercio", "pensa numa casa comercial boa", "https://www.limaonagua.com.br/wp-content/uploads/2015/12/1-sala-branca-cinza-escandinava.jpg",
                "Casa", "Aluguel", "Rua xzzz bairro zzzz BH/MG", 190.5, "11996752344", 2900.0, 1,
                2, 1, true, true, user2.getId());

        propertyService.create(property1);
        propertyService.create(property2);
    }
}
