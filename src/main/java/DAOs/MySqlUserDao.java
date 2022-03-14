package DAOs;

import DTOs.Player;
import Exceptions.DaoException;
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
}


