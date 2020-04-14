package by.epam.evento.serviceDB;

import by.epam.evento.daodb.CommentDao;
import by.epam.evento.entity.Comment;
import by.epam.evento.exception.ServiceException;


import java.util.ArrayList;

public class CommentServiceDB extends ServiceDB<Comment> {
    private CommentDao commentDao;

    public CommentServiceDB(){
        commentDao=new CommentDao();
    }

    @Override
    public void read() {
        commentDao.read();
    }

    @Override
    public ArrayList<Comment> getData() {
        return commentDao.getData();
    }

    @Override
    public void create(Comment entity) {
        try {

            if (!(isEntityExist(entity))) {
                commentDao.create(entity);
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
                commentDao.update(entity);
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
                commentDao.delete(entity.getCommentId());
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }

    }
}
