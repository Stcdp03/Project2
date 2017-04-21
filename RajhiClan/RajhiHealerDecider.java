package RajhiClan;

/**
 * Created by soma on 4/19/17.
 */


import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;


public class RajhiHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public RajhiHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch) {
            return actionPoints * 2;
        } else {
            return 0;
        }
    }
}