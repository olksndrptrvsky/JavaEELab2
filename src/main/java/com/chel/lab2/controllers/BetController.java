package com.chel.lab2.controllers;

import com.chel.lab2.entities.Bet;
import com.chel.lab2.entities.BetData;
import com.chel.lab2.models.BetService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BetController {
    @Autowired
    private BetService betService;


    @RequestMapping(value = "/betsForClient/{id}", method = RequestMethod.GET)
    public Iterable<Bet> getBetsForUser(@PathVariable Long id) {
        return betService.getBetsForClient(id);
    }

    @RequestMapping(value = "/bets", method = RequestMethod.POST)
    public void getRace(@RequestBody String body) {
        Bet bet = new Gson().fromJson(body, Bet.class);
        betService.addBet(bet);
    }

    @RequestMapping(value = "/betsDataForClient/{id}", method = RequestMethod.GET)
    public Iterable<BetData> getBetsDataForClient(@PathVariable Long id) {
        return betService.getBetsDataForClient(id);
    }



}