package clanmelee.Rajhi;

import clanmelee.ActionPointDecider;
import clanmelee.ClanMember;
import clanmelee.Clan;
import static clanmelee.ClanMember.ClanMemberType.WARRIOR;
import static clanmelee.ClanMember.ClanMemberType.HEALER;

import java.util.ArrayList;
/**
 * Created by soma on 4/17/17.
 */
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


        WarriorMember WM = new WarriorMember(getClanID());
        HealerMember HM = new HealerMember(getClanID());

        fullClanMembers.addAll(HM.getClanMembers(hitPoints));
        fullClanMembers.addAll(WM.getClanMembers(hitPoints));


        return fullClanMembers;
    }
}
