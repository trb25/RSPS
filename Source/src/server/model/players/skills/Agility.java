package server.model.players.skills;
 
import server.model.players.Client;
import server.util.Misc;
 
/*
 * @Revised for TrisidiaX RSPS Coded by Trisidia.
 */
 
public class Agility {
 
    public Client client;
    public int agtimer = 10;
    public boolean bonus = false;
 
    public Agility(Client c) {
        client = c;
    }
         
         
     
    public void AgilityLog(Client c, String Object, int level,
                    int x, int y, int a, int b, int xp)
    {
 
    if (c.playerLevel[c.playerAgility] < level) {
        c.sendMessage("You need a Agility level of "+ level +" to pass this " + Object + ".");
        return;
    }
        if (c.absX == a && c.absY == b) {
        c.fmwalkto(x, y);
        //c.startAnimation(emote);
        c.getPA().addSkillXP(xp, c.playerAgility);
        c.getPA().refreshSkill(c.playerAgility);
        }
    }
 
    public void AgilityNet(Client c, String net, int level,
                int a, int b, int h, int x, int y, int emote, int xp)
    {
 
    if (c.playerLevel[c.playerAgility] < level) {
        c.sendMessage("You need a Agility level of "+ level +" to pass this " + net + ".");
        return;
    }
    if (c.absX == a && c.absY == b) {
        //c.startAnimation(emote);
        c.teleportToX = x;
        c.teleportToY = y;
        c.heightLevel = h;
        c.updateRequired = true;
        c.appearanceUpdateRequired = true;
        c.getPA().addSkillXP(xp, c.playerAgility);
        c.getPA().refreshSkill(c.playerAgility);
        c.turnPlayerTo(c.getX()- 1, c.getY());
        }
    }
 
    public void AgilityBranch(Client c, String branch, int level,
                    int x, int y, int h, int a, int b, int emote, int xp)
    {
 
    if (c.playerLevel[c.playerAgility] < level) {
        c.sendMessage("You need a Agility level of "+ level +" to pass this " + branch + ".");
        return;
    }
        //c.startAnimation(emote);
    if (c.absX == a && c.absY == b) {
        c.teleportToX = x;
        c.teleportToY = y;
        c.heightLevel = h;
        c.getPA().addSkillXP(xp, c.playerAgility);
        c.getPA().refreshSkill(c.playerAgility);
        }
    }
 
 
 
    public void AgilityPipe(Client c, String pipe, int level,
                    int a, int b, int x, int y, int add, int amount, int xp)
    {
 
    if (c.playerLevel[c.playerAgility] < level) {
        c.sendMessage("You need a Agility level of "+ level +" to pass this " + pipe + ".");
        return;
    }
    if (c.absX == a && c.absY == b)
    {
    if (bonus && c.ag1 == 1 && c.ag2 >= 1
            && c.ag3 >= 1 && c.ag4 >= 1
                && c.ag5 >= 1 && c.ag6 >= 1)
    {
        c.fmwalkto(x, y);
        c.turnPlayerTo(c.getX(), c.getY()+ 1);
        c.getPA().addSkillXP(2000, c.playerAgility);
        c.getPA().refreshSkill(c.playerAgility);
        c.getItems().addItem(add, amount);
        c.sendMessage("Congratulations, for completing course, here is "+ amount +" tickets, and 2000 exp!");
        bonus = false;
        c.ag1 = 0;
        c.ag2 = 0;
        c.ag3 = 0;
        c.ag4 = 0;
        c.ag5 = 0;
        c.ag6 = 0;
    } else {
        c.fmwalkto(x, y);
        c.getPA().addSkillXP(xp, c.playerAgility);
        c.getPA().refreshSkill(c.playerAgility);
        c.getItems().addItem(add, 1);
        c.turnPlayerTo(c.getX(), c.getY()+ 1);
        bonus = false;
        c.sendMessage("You did not get full exp for this course. And u got 1 agility ticket");
        c.ag1 = 0;
        c.ag2 = 0;
        c.ag3 = 0;
        c.ag4 = 0;
        c.ag5 = 0;
        c.ag6 = 0;
        }
    }
}
 
 
    public void AgilityTicketCounter(Client c, String ticket,
                            int remove, int amount, int xp) {
    if (c.getItems().playerHasItem(2996)) {
        if (ticket.equals("1"))
        {
            c.getItems().deleteItem2(remove, amount);
            c.getPA().addSkillXP(xp, c.playerAgility);
            c.getPA().refreshSkill(c.playerAgility);
            c.sendMessage("You got "+ xp + " Agility Exp!");
        }
    }
    if (c.getItems().playerHasItem(2996, 10)) {
        if (ticket.equals("10"))
        {
            c.getItems().deleteItem2(remove, amount);
            c.getPA().addSkillXP(xp, c.playerAgility);
            c.getPA().refreshSkill(c.playerAgility);
            c.sendMessage("You got "+ xp + " Agility Exp!");
        }
    }
    if (c.getItems().playerHasItem(2996, 25)) {
        if (ticket.equals("25"))
        {
            c.getItems().deleteItem2(remove, amount);
            c.getPA().addSkillXP(xp, c.playerAgility);
            c.getPA().refreshSkill(c.playerAgility);
            c.sendMessage("You got "+ xp + " Agility Exp!");
        }
    }
    if (c.getItems().playerHasItem(2996, 100)) {
        if (ticket.equals("100"))
        {
            c.getItems().deleteItem2(remove, amount);
            c.getPA().addSkillXP(xp, c.playerAgility);
            c.getPA().refreshSkill(c.playerAgility);
            c.sendMessage("You got "+ xp + " Agility Exp!");
        }
    }
    if (c.getItems().playerHasItem(2996, 1000)) {
        if (ticket.equals("1000"))
        {
            c.getItems().deleteItem2(remove, amount);
            c.getPA().addSkillXP(xp, c.playerAgility);
            c.getPA().refreshSkill(c.playerAgility);
            c.sendMessage("You got "+ xp + " Agility Exp!");
        }
    }
        else
        {
            c.sendMessage("You need more agility tickets to get this Exp!");
            return;
        }
    }
 
 
 
}