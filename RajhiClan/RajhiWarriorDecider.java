package RajhiClan;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by soma on 4/19/17.
 */
public class RajhiWarriorDecider implements ActionPointDecider{
    private int actionPoints;

    public RajhiWarriorDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }
    @Override
    public int decideActionPoints(ClanMember me, ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (!clanIDsMatch && other.getType() == WARRIOR) {
            if (other.getHitPoints() <= (other.getMaxHitPoints() / 2)) {
                return actionPoints * 2;
            }
            else {
                return actionPoints;
            }
        }

        if (!clanIDsMatch && other.getType() == HEALER) {
            return actionPoints * 4;
        }
        return  0;
    }
}
