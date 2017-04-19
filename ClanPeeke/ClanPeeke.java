package ClanPeeke;

import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;

public class ClanPeeke extends Clan
{

    public ClanPeeke(int clanID)
    {
        super("Peeke Clan", clanID);
    }
    /**
     * This class serves as the main factory which brings together all clan member types into a final list.
     */
    @Override
    public ArrayList<ClanMember> getClanMembers(int hitPoints)
    {
        ArrayList<ClanMember> fullClanMembers = new ArrayList<>();

        PeekeWarriorMember Warrior = new PeekeWarriorMember(getClanID());
        PeekeHealerMember advHealer = new PeekeHealerMember(getClanID());

        fullClanMembers.addAll(Warrior.getClanMembers(hitPoints));

        return fullClanMembers;
    }
}

