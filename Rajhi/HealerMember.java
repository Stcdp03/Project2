package clanmelee.RajhiClan;

import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
/**
 * Created by soma on 4/18/17.
 */
public class HealerMember extends Clan  {


    public HealerMember(int clanID) {
        super("Healer", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

       ActionPointDecider decider = new HealerDecider(10);

        int adjHitPoints = (int)(hitPoints * .15);
        while (adjHitPoints > 0) {
            int nextHP = 100;
            if (adjHitPoints < 100)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), HEALER, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
