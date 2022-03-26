package DAOs;

import DTOs.Player;
import Exceptions.DaoException;
import MainApp.PlayerTrophiesComparator;
import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySqlUserDao extends MySqlDao implements UserDaoInterface
{




    @Override
    public List<Player> findAllPlayers() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Player> playerList = new ArrayList<>();

        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PLAYER";
            ps = connection.prepareStatement(query);

            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int userId = resultSet.getInt("USER_ID");
                String name = resultSet.getString("NAME");
                String County = resultSet.getString("County");
                int Age = resultSet.getInt("Age");
                int trophies = resultSet.getInt("Trophies");
                Player u = new Player(userId,name, County, Age, trophies);
                playerList.add(u);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllPlayerResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllPlayers() " + e.getMessage());
            }
        }
        return playerList;
    }

    public String findAllPlayersJson() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Player> playerList = new ArrayList<>();

        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PLAYER";
            ps = connection.prepareStatement(query);

            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int userId = resultSet.getInt("USER_ID");
                String name = resultSet.getString("NAME");
                String County = resultSet.getString("County");
                int Age = resultSet.getInt("Age");
                int trophies = resultSet.getInt("Trophies");
                Player u = new Player(userId,name, County, Age, trophies);
                playerList.add(u);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllPlayerResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllPlayers() " + e.getMessage());
            }
        }
        Gson gsonParser = new Gson();
        String playerJson=gsonParser.toJson(playerList);
        return playerJson;
    }



    @Override
    public Player findPlayerByID(int userID) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Player player = null;
        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PLAYER WHERE USER_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);


            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                int userId = resultSet.getInt("USER_ID");
                String name = resultSet.getString("NAME");
                String County = resultSet.getString("County");
                int age = resultSet.getInt("Age");
                int trophies = resultSet.getInt("Trophies");

                player = new Player( userId, name, County, age,trophies);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findUserByID() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findUserByID() " + e.getMessage());
            }
        }
        return player;

    }
    public String findPlayerByIDGson(int userID) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Player player = null;
        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PLAYER WHERE USER_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);


            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                int userId = resultSet.getInt("USER_ID");
                String name = resultSet.getString("NAME");
                String County = resultSet.getString("County");
                int age = resultSet.getInt("Age");
                int trophies = resultSet.getInt("Trophies");

                player = new Player( userId, name, County, age,trophies);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findUserByIDGson() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findUserByID() " + e.getMessage());
            }
        }
        Gson gsonParser = new Gson();
        String playerJson=gsonParser.toJson(player);
        return playerJson;

    }


    public  void  DeletePlayerByID(int userID) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Player player = null;
        try
        {
            connection = this.getConnection();

            String query = "DELETE FROM PLAYER WHERE USER_ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userID);
            preparedStatement.executeUpdate();


        }
        catch (SQLException e)
        {
            throw new DaoException("DeleteUsers() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("DeleteUsers() " + e.getMessage());
            }
        }

    }


    public void addPlayer(int id ,String name, int age, String county,int trophy) throws DaoException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Player player = null;
        try {
            connection = this.getConnection();

            String query = "INSERT INTO PLAYER VALUES (null,?, ?, ?,?)";

            // Try-with-Resources style

            preparedStatement = connection.prepareStatement(query);


            System.out.println("Connected to the database");
            System.out.println("Building a PreparedStatement to insert a new row in database.");

//          preparedStatement = conn.prepareStatement("INSERT INTO test.Customers VALUES (null, ?, ?, ?)";
//          Parameters are indexed starting with 1, and correspond to order of the question marks above.
//          1 corresponds to first question mark, 2 to the second one, and so on...
//          As the first field is an Auto-Increment field in the database, we specify a null value for it.

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, county);
            preparedStatement.setInt(4, trophy);

            preparedStatement.executeUpdate();

            {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        freeConnection(connection);
                    }
                } catch (SQLException e) {
                    throw new DaoException("addPlayer() " + e.getMessage());
                }
            }} catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Player> findAllPlayersGoalsFilter(int g, PlayerTrophiesComparator playerTrophiesComparator) throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Player> playersList = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM player WHERE TROPHIES > ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, g);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int userId = resultSet.getInt("USER_ID");
                String name = resultSet.getString("NAME");
                String County = resultSet.getString("County");
                int age = resultSet.getInt("Age");
                int trophies = resultSet.getInt("Trophies");
                Player p = new Player(userId,name,County,age,trophies);
                playersList.add(p);
            }
            playersList.sort(playerTrophiesComparator);
        } catch (SQLException e)
        {
            throw new DaoException("findAllPlayersGoalsFilterResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllPlayersGoalsFilter() " + e.getMessage());
            }
        }
        return playersList;     // may be empty
    }


}


