package ClanPeeke;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

public class PeekeHealerMember extends Clan{

    public PeekeHealerMember(int clanID)
    {
        super("Peeke Healer", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();


        ActionPointDecider decider = new PeekeHealerDecider(10);

        int adjHitPoints = (int)(hitPoints * .1);
        while (adjHitPoints > 0)
        {
            int nextHP = 1;
            if (adjHitPoints < 1)
            {
                nextHP = adjHitPoints;
            }

            clanMembers.add(new ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
