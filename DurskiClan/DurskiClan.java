package DurskiClan;

import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;


public class DurskiClan extends Clan {
    public DurskiClan(int clanID) {
        super("DurskiClan", clanID);
    }
    /**
     * This class serves as the main factory which brings together all clan member types into a final list.
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints) {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        DurskiHealer healer = new DurskiHealer(getClanID());
        DurskiWarrior warrior = new DurskiWarrior(getClanID());

        fullClanMembers.addAll(healer.getClanMembers(hitPoints));
        fullClanMembers.addAll(warrior.getClanMembers(hitPoints));


        return fullClanMembers;
    }
}

