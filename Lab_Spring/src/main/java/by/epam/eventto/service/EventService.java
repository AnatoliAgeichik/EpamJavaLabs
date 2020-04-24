package by.epam.eventto.service;


import by.epam.eventto.dao.EventDao;
import by.epam.eventto.entity.Event;
import by.epam.eventto.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EventService extends Service<Event, Long> {

    @Autowired
    private EventDao eventDao;

//    public EventService(){
//        eventDao = new EventDao();
//    }


    public List<Event> getData(){
        return eventDao.getAll();
    }

    @Override
    public Event getEntity(Long key) {
        return eventDao.get(key);
    }

    public void create(Event event){
        try {

            if (!(isEntityExist(event))) {
                eventDao.create(event);
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
                eventDao.create(event);
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
                eventDao.delete(event.getEventID());
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }

        }

}

