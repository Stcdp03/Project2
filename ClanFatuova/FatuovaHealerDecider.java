package ClanFatuova;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
/**
 * Created by Rocco on 4/19/17.
 */
public class FatuovaHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public FatuovaHealerDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other)
    {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch)
        {
            return actionPoints;
        }
        else
        {
            return 0;
        }
    }

}
