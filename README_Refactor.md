We refactored the method runMelee in the Class ClanMelee 
because it is a long method by adding a private helper method. 
We named it (addParticipants) and we pass 
(clans, hitPoints,clanNames, clanStats , participants) 
as a parameter and we invoke addParticipants in the runMelee method.