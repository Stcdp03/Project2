
package clanmelee;

import static clanmelee.ClanMember.ClanMemberType.HEALER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ClanMelee {

    /*
    *	ClansWins wraps a hashMap of ClanWins which keep track of the number of wins of each clan
    */
    ClansWins clansWins = new ClansWins();

    /**
     * this method simulates the fight between different clans for a given hitPoints value
     * @param clans - the clans that are participating
     * @param hitPoints - number of hitpoints given to each clan
     */

    public void runMelee(Collection<Clan> clans, int hitPoints) {
        // participants holds all the clanmembers from different clans
        ArrayList<ClanMember> participants = new ArrayList<>();
        // totalClanCount is the  number of clans in the game
        int totalClanCount = clans.size();
        // clanNames hold the names of all the clans in the game
        String[] clanNames = new String[totalClanCount];
        // ClanStats class stores the status(hitPoints, playerCount, number of healers and warriors) of clans
        ClanStats clanStats = new ClanStats(totalClanCount);


        addParticipants(clans, hitPoints,clanNames,clanStats,participants);

        int clanCount = totalClanCount;

        boolean[] previouslyAlive = new boolean[totalClanCount];
        Arrays.fill(previouslyAlive, true);
        int roundCount = 0;

        /*
         * This piece of code simulates the rounds
          */
        while (clanCount > 1) {
            Collections.shuffle(participants);
            clanStats = new ClanStats(totalClanCount);

            // This array holds the information about which clans are alive and which are eliminated
            boolean[] currentlyAlive = new boolean[totalClanCount];
            Arrays.fill(currentlyAlive, false);

            // This arraylist holds the remaing participants(who do not end up dead after interaction)
            ArrayList<ClanMember> remaining = new ArrayList<>(participants.size());

            /*
            * The following piece of code picks two clanMembers from the participants and runs the interaction
            * whoever among p1 and p2 or both remain alive after interaction, they are added to remaining
            */
            for (int i = 0; i < participants.size() - 1; i += 2) {
                ClanMember p1 = participants.get(i);
                ClanMember p2 = participants.get(i + 1);

                runInteraction(p1, p2);

                if (p1.isAlive()) {
                    clanStats.addPlayer(p1);
                    currentlyAlive[p1.getClanID()] = true;
                    remaining.add(p1);
                }
                if (p2.isAlive()) {
                    clanStats.addPlayer(p2);
                    currentlyAlive[p2.getClanID()] = true;
                    remaining.add(p2);
                }
            }


            // if there are odd number of participants make the last participant sit out
            if (participants.size() % 2 == 1) {
                ClanMember lastPlayer = participants.get(participants.size() - 1);
                int lastID = lastPlayer.getClanID();
                lastPlayer.dealIterationDamage(0);
                if (lastPlayer.isAlive()) {
                    clanStats.addPlayer(lastPlayer);
                    currentlyAlive[lastID] = true;
                    remaining.add(lastPlayer);
                }
            }

            clanCount = clanStats.getClanCount();

            roundCount += 1;


            // after the round finishes, check whether if any of the clan is eliminated(none of it's member is alive)
            for (int i = 0; i < totalClanCount; i++) {
                if (!currentlyAlive[i] && previouslyAlive[i]) {
                    if (clanNames[i] == null)
                        continue;
                    System.out.println(clanNames[i] + " eliminated after " +
                            roundCount + " interactions");
                }
            }

            previouslyAlive = currentlyAlive;

            participants = remaining;
        }

        // see if all the clans are eliminated or there is winner

        if (clanCount == 0) {
            System.out.println("All were slain after " + roundCount
                    + " interactions!");
        } else {
            int victorID = clanStats.getWinner();
            System.out.println(clanNames[victorID] + " emerged victorious after " +
                    roundCount + " interactions!");
            clansWins.addWin(victorID);
        }
    }
    /**
     * Add new mutator helper method name addParticipants
     * @param - This method requires all pieces that it changes in the code
     */
    private void addParticipants(Collection<Clan> clans, int hitPoints, String[] clanNames,ClanStats clanStats ,ArrayList<ClanMember> participants) {


        for (Clan clan : clans) {

            //the following piece of code adds each clan's data(ID and name) to clansWins
            int clanID = clan.getClanID();
            String clanName = clan.getClanName();
            if (clansWins.clanCount() < clans.size())
                clansWins.addClan(clanID, clanName);

            // following piece of code gets all the members from a clan and then add it to participants list
            Collection<ClanMember> members = clan.getClanMembers(hitPoints);
            if (!validateClan(members, hitPoints, clanID, clan.getClanName()))
                continue;
            clanNames[clanID] = clan.getClanName();
            participants.addAll(members);

            // following piece of code updates the information in the clanStats object
            for (ClanMember member : members)
                clanStats.addPlayer(member);
        }
    }

    /**
     * this method runs the interaction between two selected clanmembers from the participants
     * @param p1 first clan member
     * @param p2 other clan member
     */
    private void runInteraction(ClanMember p1, ClanMember p2) {
        int p1Action = p1.getActionPoints(p2);
        int p2Action = p2.getActionPoints(p1);

        applyAction(p1, p1Action, p2, p2Action);
        applyAction(p2, p2Action, p1, p1Action);
    }


    /**
     * A ClanMember can either be a healer or a warrior, if P1 is a healer, it will heal p2 by P1ActionPoints
     * if P1 is a warrior and P2 doesn't run (P2Action > 0), then p1 will inflict damage on p2 with 50/50 chance
     * @param p1 first clan member
     * @param p1Action actionPoints of first clan member
     * @param p2 other clan member
     * @param p2Action action points of second clan member
     */
    private void applyAction(ClanMember p1, int p1Action,
                             ClanMember p2, int p2Action) {
        if (p1.getType() == HEALER)
            p2.heal(p1Action);
        else {
            if (p2Action > 0 || Math.random() < 0.5)
                p2.dealDamage(p1Action);
        }
    }


    /**
     * This method prints the status of clansWins(how many wins each clan has)
     */
    void printStats() {
        clansWins.print();
    }

    /**
     * This method validates a clan, for a clan to be valid, all the clan members should have same ids
     * and sum of hitpoints of individual clan members should be smaller or equal to the maximum hitpoints allowed for the clan
     * @param members - a list of members that are to checked if they form a valid clan
     * @param hitPoints - hitPoints assigned to the clan
     * @param clanId - id of the clan
     * @param clanName - name of the clan
     */

    private boolean validateClan(Collection<ClanMember> members, int hitPoints,
                                 int clanID, String clanName) {
        int hitPointSum = 0;
        for (ClanMember cm : members) {
            if (cm.getClanID() != clanID) {
                System.out.println(clanName + " does not have consistent clan IDs!!");
                System.out.println(clanName + " DISQUALIFIED!!");
                return false;
            }
            hitPointSum += cm.getMaxHitPoints();
        }
        if (hitPointSum > hitPoints) {
            System.out.println(clanName + " has " + hitPointSum +
                    " hit points when only " + hitPoints + " are allowed!!");
            System.out.println(clanName + " DISQUALIFIED!!");
            return false;
        }
        return true;
    }
}
