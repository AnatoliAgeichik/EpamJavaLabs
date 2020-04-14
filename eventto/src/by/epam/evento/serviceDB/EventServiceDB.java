package by.epam.evento.serviceDB;


import by.epam.evento.daodb.EventDao;
import by.epam.evento.entity.Event;
import by.epam.evento.exception.ServiceException;

import java.util.ArrayList;

public class EventServiceDB extends ServiceDB<Event> {

    private EventDao eventDao;

    public EventServiceDB(){
        eventDao = new EventDao();
    }

    @Override
    public void read() {
        eventDao.read();
    }


    public ArrayList<Event> getData(){
        return eventDao.getData();
    }
    public void create(Event event){
        try {

            if (!(isEntityExist(event))) {
                eventDao.create(event);
            } else {
                throw  new ServiceException("such event already exist");

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
                eventDao.update(event);
            } else {
                throw  new ServiceException("such event does not exist");

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
                eventDao.delete(event.getEventID());
            } else {
                throw  new ServiceException("such event does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }

        }

}

