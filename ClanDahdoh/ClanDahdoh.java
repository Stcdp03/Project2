package ClanDahdoh;
import clanmelee.Clan;
import clanmelee.ClanMember;
import java.util.ArrayList;
/**
 * Created by saradahdoh on 4/19/17.
 */
public class ClanDahdoh extends Clan {

    public ClanDahdoh(int clanID)
    {
        super("Clan Dahdoh", clanID);
    }

    @Override
    public ArrayList<clanmelee.ClanMember> getClanMembers(int hitPoints)
    {
        ArrayList<clanmelee.ClanMember> fullClanMembers = new ArrayList<>();

        DahdohWarriorMember dWarrior = new DahdohWarriorMember(getClanID());
        DahdohHealerMember dHealer = new DahdohHealerMember(getClanID());

        fullClanMembers.addAll(dWarrior.getClanMembers(hitPoints));
        fullClanMembers.addAll(dHealer.getClanMembers(hitPoints));

        return fullClanMembers;
    }
}

