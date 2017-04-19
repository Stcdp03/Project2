package ClanFatuova;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
/**
 * Created by Rocco on 4/19/17.
 */
public class FatuovaHealerMember extends Clan {
    public FatuovaHealerMember(int clanID)
    {
        super("Fatuova Healer", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();


        ActionPointDecider decider = new FatuovaHealerDecider(10);

        int adjHitPoints = (int)(hitPoints * .1);
        while (adjHitPoints > 0)
        {
            int nextHP = 200;
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
