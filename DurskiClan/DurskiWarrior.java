package DurskiClan;

import java.util.ArrayList;
import clanmelee.ActionPointDecider;
import clanmelee.Clan;
import clanmelee.ClanMember;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;


public class DurskiWarrior extends Clan {
    public DurskiWarrior(int clanID) {
        super("Barbarian", clanID);
    }

    @Override
    public ArrayList<clanmelee.ClanMember> getClanMembers(int hitPoints) {
        ArrayList<clanmelee.ClanMember> clanMembers = new ArrayList<>();

        clanmelee.ActionPointDecider decider = new DurskiWarriorDecider(10);

        int adjHitPoints = (int)(hitPoints * .30);
        while (adjHitPoints > 0) {
            int nextHP = 500;
            if (adjHitPoints < 500)
                nextHP = adjHitPoints;

            clanMembers.add(new clanmelee.ClanMember(getClanID(), WARRIOR, nextHP, decider));
            adjHitPoints -= nextHP;
        }
        return clanMembers;
    }
}
