package ClanFatuova;


import clanmelee.Clan;
import clanmelee.ClanMember;

import java.util.ArrayList;
/**
 * Created by Rocco on 4/19/17.
 */
public class ClanFatuova extends Clan{



        public ClanFatuova(int clanID)
        {
            super("Clan Fatuova", clanID);
        }
        /**
         * This class serves as the main factory which brings together all clan member types into a final list.
         */
        @Override
        public ArrayList<clanmelee.ClanMember> getClanMembers(int hitPoints)
        {
            ArrayList<clanmelee.ClanMember> fullClanMembers = new ArrayList<>();

            FatuovaWarriorMember Warrior = new FatuovaWarriorMember(getClanID());
            FatuovaHealerMember Healer = new FatuovaHealerMember(getClanID());

            fullClanMembers.addAll(Warrior.getClanMembers(hitPoints));
            fullClanMembers.addAll(Healer.getClanMembers(hitPoints));

            return fullClanMembers;
        }
    }


