package by.epam.evento.service;

import by.epam.evento.dao.EventController;
import by.epam.evento.entity.Event;
import by.epam.evento.exception.ServiceException;

import java.util.ArrayList;

public class EventService extends by.epam.evento.service.Service<Event> {

    private EventController eventController;

    public EventService(){
        eventController = new EventController();
    }

    @Override
    public void read() {
        eventController.read();
    }

    @Override
    public void save() {
        eventController.save();
    }

    public ArrayList<Event> getData(){
        return eventController.getData();
    }
    public void create(Event event){
        try {

            if (!(isEntityExist(event))) {
                eventController.create(event);
            } else {
                throw  new ServiceException("such user already exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }

    }

    @Override
    public void update(Event event) {
        try {

            if (!(isEntityExist(event))) {
                eventController.create(event);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }


    }

    @Override
    public void delete(Event event) {
        try {

            if (!(isEntityExist(event))) {
                eventController.create(event);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }

        }

}

