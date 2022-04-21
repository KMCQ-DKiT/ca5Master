package MainApp;



import Comparators.PlayerTrophiesComparator;
import DAOs.MySqlUserDao;
import DAOs.UserDaoInterface;
import DTOs.Player;
import Exceptions.DaoException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
public class Server
{

    public UserDaoInterface IUserDao = new MySqlUserDao();
    PlayerTrophiesComparator playerTrophiesComparator = new PlayerTrophiesComparator();

    public static void main(String[] args)
    {
        Server server = new Server();
        server.start();

    }

    public void start()
    {
        try
        {
            ServerSocket ss = new ServerSocket(8080);  // set up ServerSocket to listen for connections on port 8080

            System.out.println("Server: Server started. Listening for connections on port 8080...");

            int clientNumber = 0;  // a number for clients that the server allocates as clients connect

            while (true)    // loop continuously to accept new client connections
            {
                Socket socket = ss.accept();    // listen (and wait) for a connection, accept the connection,
                // and open a new socket to communicate with the client
                clientNumber++;

                System.out.println("Server: Client " + clientNumber + " has connected.");

                System.out.println("Server: Port# of remote client: " + socket.getPort());
                System.out.println("Server: Port# of this server: " + socket.getLocalPort());

                Thread t = new Thread(new ClientHandler(socket, clientNumber)); // create a new ClientHandler for the client,
                t.start();                                                  // and run it in its own thread

                System.out.println("Server: ClientHandler started in thread for client " + clientNumber + ". ");
                System.out.println("Server: Listening for further connections...");
            }
        } catch (IOException e)
        {
            System.out.println("Server: IOException: " + e);
        }
        System.out.println("Server: Server exiting, Goodbye!");
    }

    public class ClientHandler implements Runnable   // each ClientHandler communicates with one Client
    {
        BufferedReader socketReader;
        PrintWriter socketWriter;
        Socket socket;
        int clientNumber;

        public ClientHandler(Socket clientSocket, int clientNumber)
        {
            try
            {
                InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
                this.socketReader = new BufferedReader(isReader);

                OutputStream os = clientSocket.getOutputStream();
                this.socketWriter = new PrintWriter(os, true); // true => auto flush socket buffer

                this.clientNumber = clientNumber;  // ID number that we are assigning to this client

                this.socket = clientSocket;  // store socket ref for closing

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

        @Override
        public void run()
        {
            String message;
            try
            {
                while ((message = socketReader.readLine()) != null)
                {
                    System.out.println("Server: (ClientHandler): Read command from client " + clientNumber + ": " + message);


                    if (message.startsWith("DisplayPlayerById"))
                    {
                        String[] tokens = message.split(" ");
                        int id = Integer.parseInt(tokens[1]);
                        Player player = IUserDao.findPlayerByID(id);
                        socketWriter.println(player);
                    }
                    else if(message.startsWith("DisplayAllPlayers"))
                    {
                        List playerList = IUserDao.findAllPlayers();
                        socketWriter.println(playerList);
                    }
                    else if(message.startsWith("Add"))
                    {
                        String[] tokens = message.split(" ");
                        int id = Integer.parseInt(tokens[1]);
                        String name = (tokens[2]);
                        String county = (tokens[3]);
                        int age = Integer.parseInt(tokens[4]);
                        int trophies = Integer.parseInt(tokens[5]);
                        IUserDao.addPlayer(id,name,age,county,trophies);
                        Player p = IUserDao.findPlayerByID(id);
                        socketWriter.println("Player added: " + p);
                    }
                    else if (message.startsWith("DeletePlayerById"))
                    {
                        String[] tokens = message.split(" ");
                        int id = Integer.parseInt(tokens[1]);
                        IUserDao.DeletePlayerByID(id);
                        Player x = IUserDao.findPlayerByID(id);
                        if(x!= null){
                            socketWriter.println("Not deleted");
                        }
                        else
                        {
                            socketWriter.println("Player deleted");
                        }

                    }
                    else if (message.startsWith("FilterByTrophies"))
                    {
                        String[] tokens = message.split(" ");
                        int trophies = Integer.parseInt(tokens[1]);
                        List pList = IUserDao.findallPlayersTrophies(trophies,playerTrophiesComparator);
                        if(pList.size() > 0){
                            socketWriter.println(pList);
                        }
                        else
                        {
                            socketWriter.println("No players have up to " + trophies + " trophies");
                        }

                    }


                }

                socket.close();

            } catch (IOException ex)
            {
                ex.printStackTrace();
            } catch (DaoException e) {
                e.printStackTrace();
            }
            System.out.println("Server: (ClientHandler): Handler for Client " + clientNumber + " is terminating .....");
        }
    }

}
