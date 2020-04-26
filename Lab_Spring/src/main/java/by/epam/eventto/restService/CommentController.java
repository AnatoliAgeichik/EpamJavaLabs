package by.epam.eventto.restService;

import by.epam.eventto.entity.Comment;
import by.epam.eventto.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CommentController {

    @Autowired
    CommentService commentService;

    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id){
        commentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/comment{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Long id){
        return ResponseEntity.ok(commentService.getEntity(id));
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getAllComments(){
        return ResponseEntity.ok(commentService.getData());
    }

    @PutMapping("/comment")
    public ResponseEntity<Void> updateComment(@RequestParam Comment comment){
        commentService.update(comment);
        return ResponseEntity.ok().build();
    }

    @PostMapping ("/comment")
    public ResponseEntity<Void> createComment(@RequestParam Comment comment){
        commentService.create(comment);
        return ResponseEntity.ok().build();
    }

}
