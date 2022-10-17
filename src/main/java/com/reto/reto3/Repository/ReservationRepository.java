package com.reto.reto3.Repository;




import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.reto3.Repository.CrudRepository.ReservationCrudRepository;
import com.reto.reto3.model.Client;
import com.reto.reto3.model.Reservation;
import com.reto.reto3.model.DTOs.TotalAndClient;


@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    //Los metodos

    public List<Reservation> getAll() {
        return (List<Reservation>)reservationCrudRepository.findAll();

    }

    public Optional<Reservation> getIdReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);

    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    /*
     * Reto5
     */
    
    public List<Reservation> getReservationsBetweenDates(Date fechaA, Date fechaB){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA, fechaB);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<TotalAndClient> getTopClients(){
        List<TotalAndClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationCrudRepository.getTotalReservationsByClient();
        for(int i=0; i<reporte.size(); i++){
            respuesta.add(new TotalAndClient ( (Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }

}
