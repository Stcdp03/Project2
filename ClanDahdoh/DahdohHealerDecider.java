package ClanDahdoh;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

/**
 * Created by saradahdoh on 4/19/17.
 */
public class DahdohHealerDecider implements ActionPointDecider {
    private int actionPoints;
    public DahdohHealerDecider(int actionPoints)
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
