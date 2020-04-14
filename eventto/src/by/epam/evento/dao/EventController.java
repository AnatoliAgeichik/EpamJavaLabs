package by.epam.evento.dao;

import by.epam.evento.entity.Event;

public class EventController extends Controller<Event> {
    private static final String dir = "data/event.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
