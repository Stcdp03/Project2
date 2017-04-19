package clanmelee;

public class ClanStats
{
    /*
     * These are class variables that keep track of all of the stats of each ClanMembers and the total Clan Count
     */
    private final int totalClanCount;
    private int[] hitPoints;
    private int[] playerCounts;
    private int[] warriorCounts;
    private int[] healerCounts;

    /**
     * Constructor
     * This initializes all of the variables based on the number of clans
     * @param clanCount
     */
    public ClanStats(int clanCount)
    {
        this.totalClanCount = clanCount;
        this.hitPoints = new int[clanCount];
        this.playerCounts = new int[clanCount];
        this.warriorCounts = new int[clanCount];
        this.healerCounts = new int[clanCount];
    }

    /**
     * This method adds a player to either healerCounts or warriorCounts
     * @param p is the member in which are adding to either warrior or healer
     */
    public void addPlayer(ClanMember p)
    {
        int clanID = p.getClanID();
        hitPoints[clanID] += p.getHitPoints();
        playerCounts[clanID] += 1;
        if (p.getType() == ClanMember.ClanMemberType.HEALER)
            healerCounts[clanID] += 1;
        else if (p.getType() == ClanMember.ClanMemberType.WARRIOR)
            warriorCounts[clanID] += 1;
    }

    /**
     * Returns the total HitPoints of a Clan
     * @param clanID clan's hitpoints are being checked
     * @return the hitpoints
     */
    public int getHitPoints(int clanID)
    {
        return hitPoints[clanID];
    }

    /**
     * Returns the total Number of Players of a Clan
     * @param clanID clan's Player Count are being checked
     * @return the Player Count
     */
    public int getPlayerCount(int clanID)
    {
        return playerCounts[clanID];
    }

    /**
     * Returns the total Number of Warriors of a Clan
     * @param clanID clan's Warrior Count are being checked
     * @return the Warrior Count
     */
    public int getWarriorCount(int clanID)
    {
        return warriorCounts[clanID];
    }

    /**
     * Returns the total Number of Healers of a Clan
     * @param clanID clan's Healer Count are being checked
     * @return the Healer Count
     */
    public int getHealerCount(int clanID)
    {
        return healerCounts[clanID];
    }

    /**
     * Returns the total Number of Clans
     * @return the Clan Count
     */
    public int getClanCount()
    {
        int clanCount = 0;
        for (int i = 0; i < totalClanCount; i++)
        {
            if (playerCounts[i] != 0)
            {
                clanCount += 1;
            }
        }
        return clanCount;
    }

    /**
     * Returns the index of the Clan that Wins the Melee
     * @return the Clan's index in totalClanCount
     */
    public int getWinner()
    {
        int max = 0;
        int maxID = 0;

        for (int i = 0; i < totalClanCount; i++)
        {
            if (hitPoints[i] > max)
            {
                max = hitPoints[i];
                maxID = i;
            }
        }
        return maxID;
    }
}
