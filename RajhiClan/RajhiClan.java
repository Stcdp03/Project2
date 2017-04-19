package RajhiClan;

import java.util.ArrayList;

/**
 * Created by soma on 4/19/17.
 *
 *
 *
 */
import clanmelee.Clan;
import clanmelee.ClanMember;


public class RajhiClan extends Clan{


    public RajhiClan(int clanID)
    {
        super("RajhiClan", clanID);
    }
    /**
     * This class serves as the main factory which brings together all clan member types into a final list.
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints)
    {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        RajhiHealerMember RHealer = new RajhiHealerMember(getClanID());
        RajhiWarriorMember RWarrior = new RajhiWarriorMember(getClanID());


        fullClanMembers.addAll(RHealer.getClanMembers(hitPoints));
        fullClanMembers.addAll(RWarrior.getClanMembers(hitPoints));


        return fullClanMembers;
    }
}
