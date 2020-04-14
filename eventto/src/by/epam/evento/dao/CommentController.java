package by.epam.evento.dao;

import by.epam.evento.entity.Comment;

public class CommentController extends Controller<Comment> {
    private static final String dir = "data/members.dat";

    @Override
    public String getDir() {
        return dir;
    }

}
