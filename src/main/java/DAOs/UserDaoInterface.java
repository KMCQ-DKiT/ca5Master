package DAOs;


import DTOs.Player;
import Exceptions.DaoException;
import MainApp.PlayerTrophiesComparator;

import java.util.List;

public interface UserDaoInterface
{
    public List<Player> findAllPlayers() throws DaoException;
    public Player findPlayerByID(int userID) throws DaoException;
    public void  DeletePlayerByID(int userID) throws DaoException;
    public void addPlayer(int id ,String name, int age, String county,int trophy) throws DaoException;
    public List<Player> findAllPlayersGoalsFilter(int g, PlayerTrophiesComparator playerTrophiesComparator) throws DaoException;
    public String findAllPlayersJson() throws DaoException;
    public String findPlayerByIDGson(int userID) throws DaoException;

}

