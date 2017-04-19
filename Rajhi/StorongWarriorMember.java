package clanmelee.Rajhi;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.Clan;
import java.util.ArrayList;

import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by soma on 4/17/17.
 */
public class StorongWarriorMember extends Clan {
    public StorongWarriorMember(int clanID) {
        super("Warrior", clanID);
    }

    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> clanMembers = new ArrayList<>();

        ActionPointDecider decider = new StorongWarriorDecider(16);

        int adjHitPoints = (int)(hitPoints * .40);
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
