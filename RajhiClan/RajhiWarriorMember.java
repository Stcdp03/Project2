package RajhiClan;


import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by soma on 4/19/17.
 */
public class RajhiWarriorMember extends Clan {
    public RajhiWarriorMember(int clanID) {
        super("RajhiWarrior", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new RajhiWarriorDecider(16);

        int adjHitPoints = (int)(hitPoints * .70);
        while (adjHitPoints > 0) {
            int nextHP = 899;
            if (adjHitPoints < 899)
                nextHP = adjHitPoints;

            clanMembers.add(new ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
