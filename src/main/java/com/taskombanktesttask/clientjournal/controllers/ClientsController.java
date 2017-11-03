package com.taskombanktesttask.clientjournal.controllers;

import com.taskombanktesttask.clientjournal.domain.dto.ClientDTO;
import com.taskombanktesttask.clientjournal.domain.dto.DeleteClientDTO;
import com.taskombanktesttask.clientjournal.domain.models.ClientModel;
import com.taskombanktesttask.clientjournal.domain.models.DeleteClientModel;
import com.taskombanktesttask.clientjournal.exceptions.ClientApiErrorException;
import com.taskombanktesttask.clientjournal.services.ClientApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientsController {

    private final ClientApiService clientApiService;

    @Autowired
    public ClientsController(ClientApiService clientApiService) {
        this.clientApiService = clientApiService;
    }


    @RequestMapping("/")
    public String clientsTable(
            @RequestParam(name = "limit", defaultValue = "10") int limit,
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            Model model){
        try {
            model.addAttribute("limit", limit);
            model.addAttribute("offset", offset);
            model.addAttribute("clients", clientApiService.getClientsList(limit, offset));
        } catch (ClientApiErrorException e) {
            return "error";
        }
        return "index";
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST
    )
    public String createClient(@ModelAttribute ClientModel client){
        try {
            clientApiService.createClient(new ClientDTO(client));
            return "redirect:/";
        } catch (ClientApiErrorException e) {
            return "error";
        }
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    public String updateClient(@ModelAttribute ClientModel client){
        try {
            clientApiService.updateClient(new ClientDTO(client));
            return "redirect:/";
        } catch (ClientApiErrorException e) {
            return "error";
        }
    }

    @RequestMapping(
            value = "/delete",
            method = RequestMethod.POST
    )
    public String deleteClient(@ModelAttribute DeleteClientModel deleteClientModel){
        try {
            clientApiService.deleteClient(new DeleteClientDTO(deleteClientModel));
            return "redirect:/";
        } catch (ClientApiErrorException e) {
            return "error";
        }
    }

}
