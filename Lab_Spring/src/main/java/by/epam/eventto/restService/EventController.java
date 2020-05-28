package by.epam.eventto.restService;


import by.epam.eventto.entity.Event;
import by.epam.eventto.service.EventService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    @DeleteMapping("/event/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id){
        eventService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable Long id){
        return ResponseEntity.ok(eventService.getEntity(id).get());
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents(){
        return ResponseEntity.ok(eventService.getData());
    }

    @PutMapping("/event")
    public ResponseEntity<Void> updateEvent(@RequestParam Event event){
        eventService.update(event);
        return ResponseEntity.ok().build();
    }

    @PostMapping ("/event")
    public ResponseEntity<Void> createEvent(@RequestParam Event event){
        eventService.create(event);
        return ResponseEntity.ok().build();
    }



}
