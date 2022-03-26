package DAOs;


import DTOs.Player;
import Exceptions.DaoException;
import java.util.List;

public interface UserDaoInterface
{
    public List<Player> findAllPlayers() throws DaoException;

    public Player findPlayerByID(int userID) throws DaoException;

    public void addPlayer(int id ,String name, int age, String county,int trophy) throws DaoException;


}

