package by.epam.eventto.restService;

import by.epam.eventto.entity.Members;
import by.epam.eventto.entity.User;
import by.epam.eventto.service.MembersService;
import by.epam.eventto.entity.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class MembersController {
    @Autowired
    MembersService membersService;

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> deleteMembers(@PathVariable Long id){
        membersService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Members> getMembers(@PathVariable Long id){
        return ResponseEntity.ok(membersService.getEntity(id).get());
    }

    @GetMapping("/members")
    public ResponseEntity<List<Members>> getAllMembers(){
        return ResponseEntity.ok(membersService.getData());
    }

    @PutMapping("/members")
    public ResponseEntity<Void> updateMembers(@RequestParam Members members){
        membersService.update(members);
        return ResponseEntity.ok().build();
    }


    @PostMapping ("/members")
    public ResponseEntity<Void> createMembers(@RequestParam Members members){
        membersService.create(members);
        return ResponseEntity.ok().build();
    }


}
