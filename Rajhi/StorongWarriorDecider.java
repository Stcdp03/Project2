package clanmelee.Rajhi;



import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;

/**
 * Created by soma on 4/17/17.
 */
public class StorongWarriorDecider implements ActionPointDecider {


    private int actionPoints;

    public StorongWarriorDecider(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    @Override
    public int decideActionPoints(ClanMember self, ClanMember opponent) {
        //Check if clan IDs match
        boolean clanIDsMatch = self.getClanID() == opponent.getClanID();

        //If opponent is in different clans --> fight
        if (!clanIDsMatch) {
            return actionPoints*5;
        }

        //If opponent is in same clan --> retreat
        else {
            return 0;
        }
    }
}


