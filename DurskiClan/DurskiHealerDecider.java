package clanmelee.DurskiClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

public class DurskiHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public DurskiHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch) {
            return actionPoints;
        }
        else {
            return 0;
        }
    }
}