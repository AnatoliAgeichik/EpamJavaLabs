package by.epam.evento.dao;

import by.epam.evento.entity.Members;

public class MembersController extends Controller<Members> {
    private static final String dir = "data/members.dat";

    @Override
    public String getDir() {
        return dir;
    }

}
