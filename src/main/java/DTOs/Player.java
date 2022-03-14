package DTOs;

import java.util.Objects;

public class Player {
    private int playerID;
    private final String name;
    private final int age;
    private final String county;
    private final int trophies;


    public Player(int playerID, String name, String county, int age, int trophies) {
        this.playerID = playerID;
        this.name = name;
        this.age = age;
        this.county = county;
        this.trophies = trophies;
    }

    public Player( String name, String county, int age, int trophies) {
        this.playerID = 0;
        this.name = name;
        this.age = age;
        this.county = county;
        this.trophies = trophies;
    }


    public int getAge() {
        return age;
    }

    public String getCounty() {
        return county;
    }

    public String getName() {
        return name;
    }

    public int getTrophies() {
        return trophies;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerID=" + playerID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", county='" + county + '\'' +
                ", trophies=" + trophies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return playerID == player.playerID && getAge() == player.getAge() && getTrophies() == player.getTrophies() && Objects.equals(getName(), player.getName()) && Objects.equals(getCounty(), player.getCounty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerID, getName(), getAge(), getCounty(), getTrophies());
    }
}

