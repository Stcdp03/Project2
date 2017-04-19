package PolichClan;

/**
 * Created by johnpolich on 4/19/17.
 */
public class PolichHealerDecider implements clanmelee.ActionPointDecider {
    private int actionPoints;

    public PolichHealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }
    //Returns the value in actionPoints if the clanID of me and other is the same and  or returns 0 if they aren't

    @Override
    public int decideActionPoints(clanmelee.ClanMember me, clanmelee.ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch)
            return actionPoints;
        else
            return 0;
    }
}
