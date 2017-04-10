package clanmelee;

import clanmelee.Clan1.Clan1;
import clanmelee.Clan2.Clan2;

import java.util.ArrayList;
import java.util.Collection;

public class ClanFactory
{
    /**
     * This method creates an Arraylist of Clans in which it saves clans with new IDs
     * so that they can be used in a Melee
     * @return Collection of Clans that will be used in the Melee
     */
    public Collection<Clan> getClans()
    {
        ArrayList<Clan> clans = new ArrayList<>();

        int clanID = 0;

        clans.add(new Clan1(clanID++));
        clans.add(new Clan2(clanID++));


        return clans;
    }
}
