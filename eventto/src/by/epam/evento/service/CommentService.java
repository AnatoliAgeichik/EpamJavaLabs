package by.epam.evento.service;

import by.epam.evento.dao.CommentController;
import by.epam.evento.entity.Comment;
import by.epam.evento.exception.ServiceException;

import java.util.ArrayList;

public class CommentService extends Service<Comment> {
    private CommentController commentController;

    public CommentService(){
        commentController=new CommentController();
    }

    @Override
    public void read() {
        commentController.read();
    }

    @Override
    public void save() {
        commentController.save();
    }

    @Override
    public ArrayList<Comment> getData() {
        return commentController.getData();
    }

    @Override
    public void create(Comment entity) {
        try {

            if (!(isEntityExist(entity))) {
                commentController.create(entity);
            } else {
                throw  new ServiceException("such user already exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }

    }

    @Override
    public void update(Comment entity) {
        try {

            if ((isEntityExist(entity))) {
                commentController.update(entity);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }

    }

    @Override
    public void delete(Comment entity) {
        try {

            if (isEntityExist(entity)) {
                commentController.delete(entity);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }

    }
}
