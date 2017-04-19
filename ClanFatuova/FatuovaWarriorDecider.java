package ClanFatuova;
import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by Rocco on 4/19/17.
 */
public class FatuovaWarriorDecider implements ActionPointDecider {
    private int actionPoints;

    public FatuovaWarriorDecider(int actionPoints)
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
