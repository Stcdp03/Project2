package ClanDahdoh;
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by saradahdoh on 4/19/17.
 */
public class DahdohWarriorDecider implements ActionPointDecider  {
    private int actionPoints;

    public DahdohWarriorDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();
        if (!clanIDsMatch)
        {
            return actionPoints;
        }
        else
        {
            return 0;
        }
    }
}

