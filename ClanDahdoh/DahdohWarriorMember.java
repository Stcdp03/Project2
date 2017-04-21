package ClanDahdoh;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by saradahdoh on 4/19/17.
 */
public class DahdohWarriorMember extends Clan {
    public DahdohWarriorMember(int clanID)
    {
        super("Dahdoh Warrior", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints)
    {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new DahdohWarriorDecider(10);

        int adjHitPoints = (int)(hitPoints * .90);
        while (adjHitPoints > 0)
        {
            int nextHP = 100;
            if (adjHitPoints < 100)
            {
                nextHP = adjHitPoints;
            }

            clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
