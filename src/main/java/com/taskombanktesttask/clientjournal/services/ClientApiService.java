package com.taskombanktesttask.clientjournal.services;

import com.taskombanktesttask.clientjournal.domain.dto.ClientDTO;
import com.taskombanktesttask.clientjournal.domain.dto.DeleteClientDTO;
import com.taskombanktesttask.clientjournal.exceptions.ClientApiErrorException;

import java.util.List;

/**
 * Service to interact with client api
 */
public interface ClientApiService {

    /**
     * Retrieves list of clients.
     * First registered clients is coming first.
     *
     * @param limit max amount of clients to return
     * @param offset offset from beginning of clients list
     * @return list of clients
     * @throws ClientApiErrorException on client api errors
     */
    List<ClientDTO> getClientsList(int limit, int offset) throws ClientApiErrorException;

    /**
     * Creates new client
     *
     * @param client new client data
     * @throws ClientApiErrorException on client api errors
     */
    void createClient(ClientDTO client) throws ClientApiErrorException;

    /**
     * Updates client data
     * Client id must be set in client DTO
     *
     * @param client new client data to update
     * @throws ClientApiErrorException on api internal errors or if client with given id not found
     */
    void updateClient(ClientDTO client) throws ClientApiErrorException;

    /**
     * Deletes client by id that must be present in DTO
     *
     * @param deleteClientDTO DTO with client to delete id
     * @throws ClientApiErrorException on api internal errors or if client with given id not found
     */
    void deleteClient(DeleteClientDTO deleteClientDTO) throws ClientApiErrorException;

}
