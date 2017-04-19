package PolichClan;

/**
 * Created by johnpolich on 4/19/17.
 */
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

public class PolichClan extends Clan {
    public PolichClan(int clanID) {
        super("PolichClan", clanID);
    }
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();


        PolichWarrior pwarrior = new PolichWarrior(getClanID());
        PolichHealer phealer = new PolichHealer(getClanID());

        fullClanMembers.addAll(pwarrior.getClanMembers(hitPoints));


        return fullClanMembers;
    }
}
