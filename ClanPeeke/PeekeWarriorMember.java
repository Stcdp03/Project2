package ClanPeeke;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

public class PeekeWarriorMember extends Clan {

    public PeekeWarriorMember(int clanID)
    {
        super("Peeke Warrior", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints)
    {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new PeekeWarriorDecider(10);

        int adjHitPoints = (int)(hitPoints * .90);
        while (adjHitPoints > 0)
        {
            int nextHP = 2;
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
