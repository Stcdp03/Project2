package PolichClan;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by johnpolich on 4/19/17.
 */
public class PolichWarrior extends Clan{

    public PolichWarrior(int clanID) {
        super("Warrior", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

       ActionPointDecider decider = new PolichWarriorDecider(10);

        int adjHitPoints = (int)(hitPoints * .80);
        while (adjHitPoints > 0) {
            int nextHP = 1000;
            if (adjHitPoints < 1000)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
