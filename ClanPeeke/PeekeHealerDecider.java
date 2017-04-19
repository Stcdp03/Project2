package ClanPeeke;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;


public class PeekeHealerDecider implements ActionPointDecider {
    private int actionPoints;

    public PeekeHealerDecider(int actionPoints)
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
