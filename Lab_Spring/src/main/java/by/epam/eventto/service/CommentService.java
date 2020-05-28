package by.epam.eventto.service;

import by.epam.eventto.dao.CommentDao;
import by.epam.eventto.entity.Comment;
import by.epam.eventto.exception.ServiceException;
import by.epam.eventto.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CommentService extends Service<Comment, Long> {

    @Autowired
    private CommentDao commentDao;

//    public CommentService(){
//        commentDao=new CommentDao();
//    }


    @Override
    public List<Comment> getData() {
        return commentDao.getAll(10);
    }

    @Override
    public Optional<Comment> getEntity(Long key) {
        return commentDao.get(key);
    }

    @Override
    public void create(Comment entity) {
        try {

            if (!(isEntityExist(entity.getCommentId()))) {
                commentDao.create(entity);
            } else {
                throw  new ServiceException("such user already exist");

            }
        }
        catch (ServiceException e){
          //  log.error(e.getMessage()); НУЖНО ДОПИСАТЬ
        }

    }

    @Override
    public void update(Comment entity) {
        try {

            if ((isEntityExist(entity.getCommentId()))) {
                commentDao.update(entity);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
         //   log.error(e.getMessage()); НУЖНО ДОПИСАТЬ
        }

    }

    @Override
    public void delete(Long key) {
        try {

            if (isEntityExist(key)) {
                commentDao.delete(key);
            } else {
                throw  new ServiceException("such user does not exist");

            }
        }
        catch (ServiceException e){
            //log.error(e.getMessage()); НУЖНО ДОПИСАТЬ
        }

    }
}
