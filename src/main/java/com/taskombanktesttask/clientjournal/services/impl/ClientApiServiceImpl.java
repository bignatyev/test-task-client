package com.taskombanktesttask.clientjournal.services.impl;

import com.sun.jersey.api.client.Client;
import com.taskombanktesttask.clientjournal.domain.dto.ClientDTO;
import com.taskombanktesttask.clientjournal.domain.dto.DeleteClientDTO;
import com.taskombanktesttask.clientjournal.domain.reply.ClientListReplyObject;
import com.taskombanktesttask.clientjournal.domain.reply.NoResultReplyObject;
import com.taskombanktesttask.clientjournal.exceptions.ClientApiErrorException;
import com.taskombanktesttask.clientjournal.services.ClientApiService;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.MediaType;
import java.util.List;

@Service
public class ClientApiServiceImpl implements ClientApiService {

    // TODO : MAKE IT CONFIGURABLE
    private static final String API_URL = "http://localhost:8080/api/clients/";

    private final Client restClient = new Client();

    @Override
    public List<ClientDTO> getClientsList(int limit, int offset) throws ClientApiErrorException {

        ClientListReplyObject reply = restClient.resource(API_URL + "list?limit=" + limit + "&offset=" + offset)
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get(ClientListReplyObject.class);

        if(!reply.isSuccess())
            throw new ClientApiErrorException(reply.getErrorMessage());

        return reply.getResponseData();

    }

    @Override
    public void createClient(ClientDTO client) throws ClientApiErrorException {

        NoResultReplyObject response = restClient.resource(API_URL + "create")
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .type(MediaType.APPLICATION_JSON)
                .post(NoResultReplyObject.class, client);

        if(!response.isSuccess())
            throw new ClientApiErrorException(response.getErrorMessage());

    }

    @Override
    public void updateClient(ClientDTO client) throws ClientApiErrorException {

        NoResultReplyObject response = restClient.resource(API_URL + "update")
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .type(MediaType.APPLICATION_JSON)
                .put(NoResultReplyObject.class, client);

        if(!response.isSuccess())
            throw new ClientApiErrorException(response.getErrorMessage());

    }

    @Override
    public void deleteClient(DeleteClientDTO deleteClientDTO) throws ClientApiErrorException {

        NoResultReplyObject response = restClient.resource(API_URL + "delete")
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .type(MediaType.APPLICATION_JSON)
                .delete(NoResultReplyObject.class, deleteClientDTO);

        if(!response.isSuccess())
            throw new ClientApiErrorException(response.getErrorMessage());

    }

}
