package by.epam.evento.dao;

import by.epam.evento.entity.User;

public class UserController extends Controller<User> {
    private static final String dir = "data/user.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
