package clanmelee.Rajhi;
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;


/**
 * Created by soma on 4/17/17.
 */
public class HealerDecider implements ActionPointDecider {
    private int actionPoints;

    public HealerDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch) {
            return actionPoints*2;
        }
        else {
            return 0;
        }
    }
}
