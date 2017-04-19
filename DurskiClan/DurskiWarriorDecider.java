package DurskiClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class DurskiWarriorDecider implements ActionPointDecider {
    private int actionPoints;

    public DurskiWarriorDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }
    @Override
    public int decideActionPoints(clanmelee.ClanMember me, clanmelee.ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (!clanIDsMatch)
            return actionPoints;
        else
            return 0;
    }
}

