package ClanPeeke;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;


public class PeekeWarriorDecider implements ActionPointDecider {
    private int actionPoints;

    public PeekeWarriorDecider(int actionPoints)
    {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (!clanIDsMatch)
        {
            return (me.getMaxHitPoints() * 2) + 10;
        }
        else
        {
            return 0;
        }
    }
}
