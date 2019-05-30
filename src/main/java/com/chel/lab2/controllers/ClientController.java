package com.chel.lab2.controllers;

import com.chel.lab2.entities.Bet;
import com.chel.lab2.entities.Client;
import com.chel.lab2.models.BetService;
import com.chel.lab2.models.ClientService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "/checkAuthorisation", method = RequestMethod.POST)
    public Client checkUser(@RequestBody String body) {
        Client client = new Gson().fromJson(body, Client.class);
        return clientService.checkAuthorisation(client.getLogin(), client.getPass());
    }


}