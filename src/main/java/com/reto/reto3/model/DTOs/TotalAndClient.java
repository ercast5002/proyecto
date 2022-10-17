package com.reto.reto3.model.DTOs;

import ch.qos.logback.core.net.server.Client;

public class TotalAndClient {
    private Long total;
    private Client client;
    
    
    public TotalAndClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }


    public TotalAndClient(Long total2, com.reto.reto3.model.Client client2) {
    }


    public Long getTotal() {
        return total;
    }


    public void setTotal(Long total) {
        this.total = total;
    }


    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {
        this.client = client;
    }
    
 

}
