package MainApp;

import DTOs.Player;

import java.util.Comparator;
public class PlayerNameTrophyComparator implements Comparator<Player> {


    @Override
    public int compare(Player p1, Player p2)
    {
        boolean nameAlphabeticalEqual =
                p1.getName().equalsIgnoreCase(p2.getName());


        if(nameAlphabeticalEqual == true)
        {
            return (p1.getTrophies() - p2.getTrophies()) * -1;
        }
        else
        {
            return p1.getName().compareToIgnoreCase(p2.getName());
        }
    }
}
