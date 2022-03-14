package DAOs;


import DTOs.Player;
import Exceptions.DaoException;
import java.util.List;

public interface UserDaoInterface
{
    public List<Player> findAllPlayers() throws DaoException;

    public Player findPlayerByID(int userID) throws DaoException;


}

