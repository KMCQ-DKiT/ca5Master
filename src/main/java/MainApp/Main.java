package MainApp;

import DAOs.MySqlUserDao;
import DAOs.UserDaoInterface;
import DTOs.Player;
import Exceptions.DaoException;

import java.io.IOException;
import java.util.*;




public class Main {
    ArrayList<Player> playerList = new ArrayList<>();

    public static void main(String[] args) {
        Main app = new Main();
        app.start();



    }

    public void start() {
        try {
            displayMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Program ending, Goodbye");
    }

    private void displayMainMenu() throws IOException {

        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. ArrayList\n"
                + "2. HashMap\n"
                + "3. Find From HashMap\n"
                + "4. TreeMap\n"
                + "5. PriorityQueue\n"
                + "6. Display 2 Priority\n"
                + "7. Display from mySQL\n"
                + "8. Find By ID MySQl\n"
                + "9. Add data to xampp\n"
                + "10. Delete From Xampp\n"
                + "11. Filter By Age Through Xampp\n"
                + "12. GsonString Of Data\n"
                + "13. GsonStringFilter of Data\n"
                + "14. Exit\n"
                + "Enter Option [1,14]";

        final int ARRAYLIST = 1;
        final int HASHMAP = 2;
        final int FINDHASHMAP = 3;
        final int TREEMAP = 4;
        final int PRIORITYQUEUE = 5;
        final int TWOPRIORITYQUEUE = 6;
        final int MYSQL = 7;
        final int FINDBYIDSQL = 8;
        final int ADDTODATA = 9;
        final int DELETEFROMDATA = 10;
        final int FILTERBYAGE = 11;
        final int GSONSTRING = 12;
        final int GSONSTRINGFILTER = 13;
        final int EXIT = 14;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case ARRAYLIST:
                        displayArray();
                        gsonString();
                        break;
                    case HASHMAP:
                        displayHash();
                        break;
                    case FINDHASHMAP:
                        findFromHash();
                        break;
                    case TREEMAP:
                        displayTree();
                        break;
                    case PRIORITYQUEUE:
                        PriorityQueue();
                        break;
                    case TWOPRIORITYQUEUE:
                        TwoPriorityQueue();
                        break;
                    case MYSQL:
                        mySql();
                        break;
                    case FINDBYIDSQL:
                        findByIdMySQL();
                        break;
                    case ADDTODATA:
                        addPlayer();
                        break;
                    case DELETEFROMDATA:
                        deletePlayer();
                        break;
                    case FILTERBYAGE:
                        filterByTrophy();
                        break;
                    case GSONSTRING:
                        gsonString();
                        break;
                    case GSONSTRINGFILTER:
                        findByIDJson();
                        break;
                    case EXIT:
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            } catch (DaoException e) {
                e.printStackTrace();
            }
        } while (option != EXIT);

        System.out.println("\nExiting MainApp.Main Menu");

    }

    public static void displayArray() {
        ArrayList<Player> playerList = new ArrayList<>();

        playerList.add(new Player(1,"Stephen Cluxton", "Dublin", 28, 8));
        playerList.add(new Player(2,"James McCarthy", "Dublin", 30, 4));
        playerList.add(new Player(3,"Bernard Brogan", "Dublin", 26, 6));
        playerList.add(new Player(4,"Colm Basquel", "Dublin", 23, 5));
        playerList.add(new Player(5,"Cormac Costello", "Dublin", 20, 4));
        playerList.add(new Player(6,"Craig Lynch", "Louth", 27, 1));
        playerList.add(new Player(7,"Kevin Carr", "Louth", 28, 0));
        playerList.add(new Player(8,"Eoin O'Connor", "Louth", 31, 0));
        playerList.add(new Player(9,"Sam Mulroy", "Louth", 29, 1));
        playerList.add(new Player(10,"Decky Byrne", "Louth", 30, 1));

        for (Player player : playerList) {
            System.out.println(player + ",");
        }
    }

    public static void displayHash() {
        Map<String, Player> playerMap = new HashMap<>();

        playerMap.put("D1", new Player(1,"Stephen Cluxton", "Dublin", 28, 8));
        playerMap.put("D2", new Player(2,"James McCarthy", "Dublin", 30, 4));
        playerMap.put("D3", new Player(3,"Bernard Brogan", "Dublin", 26, 6));
        playerMap.put("D4", new Player(4,"Colm Basquel", "Dublin", 23, 5));
        playerMap.put("D5", new Player(5,"Cormac Costello", "Dublin", 20, 4));
        playerMap.put("L1", new Player(6,"Craig Lynch", "Louth", 27, 1));
        playerMap.put("L2", new Player(7,"Kevin Carr", "Louth", 28, 0));
        playerMap.put("L3", new Player(8,"Eoin O'Connor", "Louth", 31, 0));
        playerMap.put("L4", new Player(9,"Sam Mulroy", "Louth", 29, 1));
        playerMap.put("L5", new Player(10,"Decky Byrne", "Louth", 30, 1));

        System.out.println("Displaying from HashMap:");
        Collection<Player> players = playerMap.values();
        for (Player p : players) {
            System.out.println(p + ", ");
        }

    }

    public static void findFromHash() {
        Map<String, Player> playerHash = new HashMap<>();

        playerHash.put("D1", new Player(1,"Stephen Cluxton", "Dublin", 28, 8));
        playerHash.put("D2", new Player(2,"James McCarthy", "Dublin", 30, 4));
        playerHash.put("D3", new Player(3,"Bernard Brogan", "Dublin", 26, 6));
        playerHash.put("D4", new Player(4,"Colm Basquel", "Dublin", 23, 5));
        playerHash.put("D5", new Player(5,"Cormac Costello", "Dublin", 20, 4));
        playerHash.put("L1", new Player(6,"Craig Lynch", "Louth", 27, 1));
        playerHash.put("L2", new Player(7,"Kevin Carr", "Louth", 28, 0));
        playerHash.put("L3", new Player(8,"Eoin O'Connor", "Louth", 31, 0));
        playerHash.put("L4", new Player(9,"Sam Mulroy", "Louth", 29, 1));
        playerHash.put("L5", new Player(10,"Decky Byrne", "Louth", 30, 1));

        System.out.println("\n");
        System.out.println("Enter Initials of County and Number of DTOs.Player ( Dublin = `D` + Number = 1  = `D1`) :");
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.nextLine().toUpperCase(Locale.ROOT);
        if (playerHash.get(userInput) == null) {
            System.out.println("Object was not found,Invalid Key");
        } else {
            System.out.println(playerHash.get(userInput));
        }
    }

    public static void displayTree() {
        Map<String, Player> playerTree = new TreeMap<>();

        playerTree.put("Stephen", new Player(1,"Stephen Cluxton", "Dublin", 28, 8));
        playerTree.put("James", new Player(2,"James McCarthy", "Dublin", 30, 4));
        playerTree.put("Bernard", new Player(3,"Bernard Brogan", "Dublin", 26, 6));
        playerTree.put("Colm", new Player(4,"Colm Basquel", "Dublin", 23, 5));
        playerTree.put("Cormac", new Player(5,"Cormac Costello", "Dublin", 20, 4));
        playerTree.put("Craig", new Player(6,"Craig Lynch", "Louth", 27, 1));
        playerTree.put("Kevin", new Player(7,"Kevin Carr", "Louth", 28, 0));
        playerTree.put("Eoin", new Player(8,"Eoin O'Connor", "Louth", 31, 0));
        playerTree.put("Sam", new Player(9,"Sam Mulroy", "Louth", 29, 1));
        playerTree.put("Decky", new Player(10,"Decky Byrne", "Louth", 30, 1));
        Set<String> keySet = playerTree.keySet();
        for (String key : keySet) {
            Player player = playerTree.get(key);
            System.out.println("Key: {" + key + "} ,Name:" + player.getName() + " County:" + player.getCounty() + " Age:"
                    + player.getAge() + " Trophies:" + player.getTrophies());
        }
    }

    public static void PriorityQueue() {
        PriorityQueue<Player> priorityQueue = new PriorityQueue<>(new PlayerTrophiesComparator());

        priorityQueue.add(new Player(1,"Stephen Cluxton", "Dublin", 28, 8));
        priorityQueue.add(new Player(2,"James McCarthy", "Dublin", 30, 4));
        priorityQueue.add(new Player(3,"Bernard Brogan", "Dublin", 26, 6));
        priorityQueue.add(new Player(4,"Colm Basquel", "Dublin", 23, 5));
        priorityQueue.add(new Player(5,"Cormac Costello", "Dublin", 20, 4));
        priorityQueue.add(new Player(6,"Craig Lynch", "Louth", 27, 1));
        priorityQueue.add(new Player(7,"Kevin Carr", "Louth", 28, 0));
        priorityQueue.add(new Player(8,"Eoin O'Connor", "Louth", 31, 0));
        priorityQueue.add(new Player(9,"Sam Mulroy", "Louth", 29, 1));
        priorityQueue.add(new Player(10,"Decky Byrne", "Louth", 30, 1));

        System.out.println("Priority Queue by Age:");
        for (Player s : priorityQueue) {
            System.out.println(s);
        }
    }

    public static void TwoPriorityQueue() {
        PriorityQueue<Player> priorityQueue = new PriorityQueue<>(new PlayerNameTrophyComparator());
        priorityQueue.add(new Player(1,"Stephen Cluxton", "Dublin", 28, 8));
        priorityQueue.add(new Player(2,"James McCarthy", "Dublin", 30, 4));
        priorityQueue.add(new Player(3,"Bernard Brogan", "Dublin", 26, 6));
        priorityQueue.add(new Player(4,"Colm Basquel", "Dublin", 23, 5));
        priorityQueue.add(new Player(5,"Cormac Costello", "Dublin", 20, 4));
        priorityQueue.add(new Player(6,"Craig Lynch", "Louth", 27, 1));
        priorityQueue.add(new Player(7,"Kevin Carr", "Louth", 28, 0));
        priorityQueue.add(new Player(8,"Eoin O'Connor", "Louth", 31, 0));
        priorityQueue.add(new Player(9,"Sam Mulroy", "Louth", 29, 1));
        priorityQueue.add(new Player(10,"Decky Byrne", "Louth", 30, 1));
        System.out.println("Priority Queue With Name And Trophy:");
        for (Player s : priorityQueue) {
            System.out.println(s);
        }
    }
    public static void mySql() throws DaoException {
        UserDaoInterface IUserDao = new MySqlUserDao();
        try {
            System.out.println("\nCall findAllPlayers()");
            List<Player> players = IUserDao.findAllPlayers();

            if (players.isEmpty())
                System.out.println("There are no Players");
            else {
                for (Player p : players)
                    System.out.println("Player: " + p.toString());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    public static void findByIdMySQL()throws DaoException{
        UserDaoInterface IUserDao = new MySqlUserDao();
        Scanner k = new Scanner(System.in);
        try {
            System.out.println("\nCall: findPlayerByID()");
            System.out.println("Enter ID You Wish To Find: ");
            int userID = k.nextInt();
            Player player = IUserDao.findPlayerByID(userID);

            if (player != null)
                System.out.println("Player found: " + player);
            else
                System.out.println("Player with that ID not found");

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }
    public static void addPlayer()throws DaoException{
        UserDaoInterface IUserDao = new MySqlUserDao();
        Scanner k = new Scanner(System.in);
        int id = 0;
        System.out.println("Enter Name of Player");
        String name = k.nextLine();
        System.out.println("Enter County of Player");
        String county = k.nextLine();
        System.out.println("Enter Age of Player");
        int age = k.nextInt();
        System.out.println("Enter Trophy amount of Player");
        int trophy =k.nextInt();
        IUserDao.addPlayer(id,name,age,county,trophy);
    }
    public static void deletePlayer()throws DaoException{
        UserDaoInterface IUserDao = new MySqlUserDao();
        Scanner k = new Scanner(System.in);
        System.out.println("Select player by ID to delete: ");
        int id = k.nextInt();
        System.out.println("You Chose to Delete");
        System.out.println(IUserDao.findPlayerByID(id));
        IUserDao.DeletePlayerByID(id);
    }

    public static void filterByTrophy() throws DaoException {
        Scanner k = new Scanner(System.in);
        UserDaoInterface IUserDao = new MySqlUserDao();
        System.out.print("Enter Trophy amount: ");
        List<Player> players = IUserDao.findAllPlayers();
        int trophies = k.nextInt();
        k.nextLine();
        PlayerTrophiesComparator playerTrophiesComparator = new PlayerTrophiesComparator();
        players = IUserDao.findAllPlayersGoalsFilter(trophies,playerTrophiesComparator);
        System.out.println("Players with " + trophies + "+ trophies");
        for (Player p : players) {
            System.out.println(p.toString());
        }
    }
    public static void gsonString()throws DaoException{
        UserDaoInterface IUserDao = new MySqlUserDao();
        try {
            System.out.println("\nCall findAllPlayers()");
            String players = IUserDao.findAllPlayersJson();
            if (players.isEmpty())
                System.out.println("There are no Players");
            else {
                System.out.println(players);
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public static void findByIDJson() throws DaoException {
        UserDaoInterface IUserDao = new MySqlUserDao();
        Scanner k = new Scanner(System.in);
        try {
            System.out.println("\nCall: findPlayerByID()");
            System.out.println("Enter ID You Wish To Find: ");
            int userID = k.nextInt();
            String player = IUserDao.findPlayerByIDGson(userID);

            if (player != null)
                System.out.println("Player found: " + player);
            else
                System.out.println("Player with that ID not found");

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

}


