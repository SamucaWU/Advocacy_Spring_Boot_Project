package github.io.advocacy.controller;

import github.io.advocacy.DTOs.client.ClientCreateDTO;
import github.io.advocacy.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;
}
