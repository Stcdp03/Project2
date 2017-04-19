package PolichClan;

import static clanmelee.ClanMember.ClanMemberType.HEALER;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by johnpolich on 4/19/17.
 */
public class PolichWarriorDecider implements clanmelee.ActionPointDecider {
    private int actionPoints;

    public PolichWarriorDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(clanmelee.ClanMember me, clanmelee.ClanMember other) {
        boolean clanIDsMatch = me.getClanID() == other.getClanID();

        if (clanIDsMatch == false && other.getType() == WARRIOR) {
            if (other.getHitPoints() > actionPoints *2 ){
                return 0;
            }
            else if(other.getHitPoints()>1000000){
                return actionPoints;
            }
            else {
                return actionPoints*2;
            }
        }

        if (clanIDsMatch == false && other.getType() == HEALER) {
            return actionPoints;
        }
        return  0;
    }
}
