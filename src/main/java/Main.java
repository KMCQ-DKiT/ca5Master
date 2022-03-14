import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        Main app = new Main();
        app.start();
    }

    public void start()
    {
        try
        {
            displayMainMenu();        // User Interface - Menu
        } catch (IOException e)
        {
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
                + "7. Exit\n"
                + "Enter Option [1,7]";

        final int ARRAYLIST = 1;
        final int HASHMAP = 2;
        final int FINDHASHMAP = 3;
        final int TREEMAP = 4;
        final int PRIORITYQUEUE = 5;
        final int TWOPRIORITYQUEUE = 6;
        final int EXIT = 7;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do
        {
            System.out.println("\n" + MENU_ITEMS);
            try
            {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case ARRAYLIST:
                        displayArray();
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
                    case EXIT:
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu");

    }

    public static void displayArray()
    {
        ArrayList<Player> playerList = new ArrayList<>();

        playerList.add(new Player("Stephen Cluxton","Dublin",28,8));
        playerList.add(new Player("James McCarthy","Dublin",30,4));
        playerList.add(new Player("Bernard Brogan","Dublin",26,6));
        playerList.add(new Player("Colm Basquel", "Dublin",23,5));
        playerList.add(new Player("Cormac Costello","Dublin",20,4));
        playerList.add(new Player("Craig Lynch","Louth",27,1));
        playerList.add(new Player("Kevin Carr","Louth",28,0));
        playerList.add(new Player("Eoin O'Connor","Louth",31,0));
        playerList.add(new Player("Sam Mulroy","Louth",29,1));
        playerList.add(new Player("Decky Byrne","Louth",30,1));

        for(Player player : playerList)
        {
            System.out.println(player + ",");
        }
    }

    public static void displayHash()
    {
        Map<String, Player> playerMap = new HashMap<>();
        playerMap.put("D1", new Player("Stephen Cluxton","Dublin",28,8));
        playerMap.put("D2", new Player("James McCarthy","Dublin",30,4));
        playerMap.put("D3", new Player("Bernard Brogan","Dublin",26,6));
        playerMap.put("D4", new Player("Colm Basquel", "Dublin",23,5));
        playerMap.put("D5", new Player("Cormac Costello","Dublin",20,4));
        playerMap.put("L1", new Player("Craig Lynch","Louth",27,1));
        playerMap.put("L2", new Player("Kevin Carr","Louth",28,0));
        playerMap.put("L3", new Player("Eoin O'Connor","Louth",31,0));
        playerMap.put("L4", new Player("Sam Mulroy","Louth",29,1));
        playerMap.put("L5",new Player("Decky Byrne","Louth",30,1));

        System.out.println("Displaying from HashMap:");
        Collection<Player> players = playerMap.values();
        for (Player p : players)
        {
            System.out.println(p + ", ");
        }

    }

    public static void findFromHash()
    {
        Map<String, Player> playerMap = new HashMap<>();
        playerMap.put("D1", new Player("Stephen Cluxton","Dublin",28,8));
        playerMap.put("D2", new Player("James McCarthy","Dublin",30,4));
        playerMap.put("D3", new Player("Bernard Brogan","Dublin",26,6));
        playerMap.put("D4", new Player("Colm Basquel", "Dublin",23,5));
        playerMap.put("D5", new Player("Cormac Costello","Dublin",20,4));
        playerMap.put("L1", new Player("Craig Lynch","Louth",27,1));
        playerMap.put("L2", new Player("Kevin Carr","Louth",28,0));
        playerMap.put("L3", new Player("Eoin O'Connor","Louth",31,0));
        playerMap.put("L4", new Player("Sam Mulroy","Louth",29,1));
        playerMap.put("L5",new Player("Decky Byrne","Louth",30,1));

        System.out.println("\n");
        System.out.println("Enter Initials of County and Number of Player ( Dublin = `D` + Number = 1  = `D1`) :");
        Scanner keyboard = new Scanner(System.in);
        String userInput = keyboard.nextLine().toUpperCase(Locale.ROOT);
        if (playerMap.get(userInput) == null){
            System.out.println("Object was not found,Invalid Key");
        }else {
            System.out.println(playerMap.get(userInput));
        }
    }
    public static void displayTree()
    {
        Map<Long, Player> playerTree = new TreeMap<>();
        playerTree.put(1L, new Player("Stephen Cluxton","Dublin",28,8));
        playerTree.put(2L, new Player("James McCarthy","Dublin",30,4));
        playerTree.put(3L, new Player("Bernard Brogan","Dublin",26,6));
        playerTree.put(4L, new Player("Colm Basquel", "Dublin",23,5));
        playerTree.put(5L, new Player("Cormac Costello","Dublin",20,4));
        playerTree.put(6L, new Player("Craig Lynch","Louth",27,1));
        playerTree.put(7L, new Player("Kevin Carr","Louth",28,0));
        playerTree.put(8L, new Player("Eoin O'Connor","Louth",31,0));
        playerTree.put(9L, new Player("Sam Mulroy","Louth",29,1));
        playerTree.put(10L,new Player("Decky Byrne","Louth",30,1));
        Set<Long> keySet = playerTree.keySet();
        for (Long key : keySet) {
            Player player = playerTree.get(key);
            System.out.println("Key: " + key +" ,Name:"+player.getName() + " County:" + player.getCounty() + " Age:"
                    + player.getAge() + " Trophies:" + player.getTrophies());
        }
    }

    public static void PriorityQueue()
    {
        PriorityQueue<Player> priorityQueue = new PriorityQueue<>(new PlayerAgeComparator());

        priorityQueue.add(new Player("Stephen Cluxton","Dublin",28,8));
        priorityQueue.add(new Player("James McCarthy","Dublin",30,4));
        priorityQueue.add(new Player("Bernard Brogan","Dublin",26,6));
        priorityQueue.add(new Player("Colm Basquel", "Dublin",23,5));
        priorityQueue.add(new Player("Cormac Costello","Dublin",20,4));
        priorityQueue.add(new Player("Craig Lynch","Louth",27,1));
        priorityQueue.add(new Player("Kevin Carr","Louth",28,0));
        priorityQueue.add(new Player("Eoin O'Connor","Louth",31,0));
        priorityQueue.add(new Player("Sam Mulroy","Louth",29,1));
        priorityQueue.add(new Player("Decky Byrne","Louth",30,1));

        System.out.println("Priority Queue by Age:");
        for (Player s : priorityQueue){
            System.out.println(s);
        }
    }
    public static void TwoPriorityQueue(){
        PriorityQueue<Player> priorityQueue = new PriorityQueue<>(new PlayerNameTrophyComparator());
        priorityQueue.add(new Player("Stephen Cluxton","Dublin",28,8));
        priorityQueue.add(new Player("James McCarthy","Dublin",30,4));
        priorityQueue.add(new Player("Bernard Brogan","Dublin",26,6));
        priorityQueue.add(new Player("Colm Basquel", "Dublin",23,5));
        priorityQueue.add(new Player("Cormac Costello","Dublin",20,4));
        priorityQueue.add(new Player("Craig Lynch","Louth",27,1));
        priorityQueue.add(new Player("Kevin Carr","Louth",28,0));
        priorityQueue.add(new Player("Eoin O'Connor","Louth",31,0));
        priorityQueue.add(new Player("Sam Mulroy","Louth",29,1));
        priorityQueue.add(new Player("Decky Byrne","Louth",30,1));
        System.out.println("Priority Queue With Name And Trophy:");
        for (Player s : priorityQueue){
            System.out.println(s);
        }
    }
}
