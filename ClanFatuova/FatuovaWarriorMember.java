package ClanFatuova;



import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by Rocco on 4/19/17.
 */
public class FatuovaWarriorMember extends Clan {
    public FatuovaWarriorMember(int clanID)
    {
        super("Fatuova Warrior", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints)
    {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new FatuovaWarriorDecider(10);

        int adjHitPoints = (int)(hitPoints * .20);
        while (adjHitPoints > 0)
        {
            int nextHP = 500;
            if (adjHitPoints < 2)
            {
                nextHP = adjHitPoints;
            }

            clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
