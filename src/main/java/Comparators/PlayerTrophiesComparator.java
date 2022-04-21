package Comparators;

import DTOs.Player;

import java.util.Comparator;
public class PlayerTrophiesComparator implements Comparator<Player>
{


    @Override
    public int compare(Player p1, Player p2)
    {
        return  (p1.getTrophies() - p2.getTrophies());
    }
}
