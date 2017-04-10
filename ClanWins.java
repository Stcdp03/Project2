package clanmelee;

public class ClanWins implements Comparable<ClanWins>
{
    private String name;
    private Integer wins;

    /**
     * Takes in a name of a Clan and then gives the class variables the correct name and resets wins
     * @param name
     */
    public ClanWins(String name)
    {
        this.name = name;
        this.wins = 0;
    }

    /**
     * Increments the number of wins for a Clan
     */
    public void addWin()
    {
        wins += 1;
    }

    /**
     * Returns the name of the Clan the instance is accessing
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Returns the wins of a Clan that the instance is accessing
     * @return
     */
    public int getWins()
    {
        return wins;
    }

    /**
     * Compares the difference of number of wins for 2 clans
     * @param other
     * @return
     */
    @Override
    public int compareTo(ClanWins other)
    {
        return wins.compareTo(other.getWins()) * -1;
    }
}
