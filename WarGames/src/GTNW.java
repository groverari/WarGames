import com.sun.javaws.exceptions.InvalidArgumentException;
import com.sun.media.jfxmediaimpl.HostUtils;

import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
/*
Gameplay
    copmuter vs user
    user vs user
    computer vs computer


    Game methodolgy
    Goal: fewest casualties of your country with the most casualties of enemy country
    Each turn gives you the opportunity to nuke one place on the other side

 */

public class GTNW {
    private static final int NUKES = 8;
    public static Map<String, Integer> USAc = new TreeMap<String, Integer>();
    public static Map<String, Integer> USAm = new TreeMap<String, Integer>();
    public static Map<String, Integer> USSRm = new TreeMap<String, Integer>();

    public static Map<String, Integer> USSRc = new TreeMap<String, Integer>();

    private static void generateMaps(){
        for (Cities c: Cities.values()) {
            USAc.put(c.name, c.pop);
        }
        for(USSRCities c: USSRCities.values())
          {  USSRc.put(c.name, c.pop);}
        for(USAMilitary m: USAMilitary.values()){
            USAm.put(m.name, m.pop);
        }
        for(USSRMilitary m : USSRMilitary.values()){
            USSRm.put(m.name, m.pop);
        }

    }

    public static String logon(String username){
        if(username.equals("Joshua"))return "hard";
        else if(username.equals("Falken")) return "easy";
        else if(username.equals("Ariesh")) return"robot test";
        else return null;
    }
    public static int USAturn(Scanner s ){
        System.out.println("USA would you like to bomb a \n1: City \nor \n2: Military base");
        Map<String, Integer> temp = s.nextInt() == 1? USSRc: USSRm;
        String location;
        while(true) {
            System.out.println("Pick a \n Type the name of the city");
            int counter = 1;
            for (String l : temp.keySet()) {
                System.out.println(counter + "     " + l);
                counter++;
            }
            location = s.nextLine();
            if (!temp.containsKey(location)) {
                System.out.println("Try again");
            }
            else break;
        }
        System.out.println("You just killed "+ temp.get(location)+ " people");
        return temp.remove(location);

    }
    public static int USSRturn (Scanner s){
        System.out.println("USSR would you like to bomb a \n1: City \nor \n2: Military base");
        Map<String, Integer> temp = s.nextInt() == 1? USAc: USAm;
        String location;
        while(true) {
            System.out.println("Pick a \n Type the name of the city");
            int counter = 1;
            for (String l : temp.keySet()) {
                System.out.println(counter + "     " + l);
                counter++;
            }
            location = s.nextLine();
            if (!temp.containsKey(location)) {
                System.out.println("Try again");
            }

            else break;
        }
        System.out.println("You just killed "+ temp.get(location)+ " people");
        return temp.remove(location);
    }
    public static int AIH(String country){
        Map<String, Integer> temp;
        if (country == "USA") {
            temp = Math.random()> .6 ? USSRm: USSRc;
        }
        else{
            temp  = Math.random()> .6 ? USAm: USAc;
        }

        int big = 0;
        String biggest = "";
        for(String key: temp.keySet()){
            if(temp.get(key)> big)
                biggest = key;
        }
        System.out.println(country+ " bombed "+ biggest +" and killed "+ temp.get(biggest));
        return temp.remove(biggest);
    }
    public static int AIE(String  country){
        Map<String, Integer> temp;
        if (country == "USA") {
            temp = Math.random()> .6 ? USSRm: USSRc;
        }
        else{
            temp  = Math.random()> .6 ? USAm: USAc;
        }
        Object [] x= temp.keySet().toArray();

        int random = (int)Math.random()*x.length;
        System.out.println(country+" bombed "+ x[random] +" and killed "+ temp.get(x[random]));
        return temp.remove(x[random]);

    }
    public static boolean noBombing(int deaths){
        if(deaths> 40000 || deaths ==0){
            return true;
        }
        if(Math.random()< .4)
            return true;
        return false;
    }
    public static String GameAI(Scanner s, String country, String difficulty) {
        int USAdeaths = 0;
        int USSRdeaths = 0;

        int deaths=0;
        if (country == "USSR") {

            for (int i = 0; i < NUKES; i++) {
                if (noBombing(deaths)) {
                    if (difficulty == "easy") {
                        deaths = AIE("USA");
                        USSRdeaths += deaths;
                    }
                    else {
                        deaths = AIH("USA");
                        USSRdeaths +=  deaths;
                    }
                    if(noBombing(deaths)){
                        deaths = USSRturn(s);
                        USAdeaths += deaths;
                    }

                }
            }
        } else {



            for (int i = 0; i < NUKES; i++) {
                if(noBombing(deaths)){
                    deaths = USAturn(s);
                    USSRdeaths += deaths;

                }

                if(noBombing(deaths)) {
                    if (difficulty == "easy") {
                        deaths = AIE("USSR");
                        USAdeaths += deaths;

                    } else {
                        deaths = AIH("USSR");
                        USAdeaths += deaths;
                    }
                }

            }
        }
        String winner;
        if(USAdeaths>= USSRdeaths)
            winner = winner(USSRdeaths, "USSR");
        else
            winner = winner(USAdeaths, "USA");

        return winner;

    }
    public static String game(Scanner s){
        int USAdeaths =0;
        int USSRdeaths =0;
        int deaths = 0;

        for(int i = 0; i < NUKES;i++){
            if(noBombing(deaths)){
                deaths  = USAturn(s);
                USSRdeaths+= deaths;
            }
           if(noBombing(deaths)) {
               deaths = USSRturn(s);
               USAdeaths += deaths;
           }

           }
        String winner;
        if(USAdeaths>= USSRdeaths)
            winner = winner(USSRdeaths, "USSR");
        else
            winner = winner(USAdeaths, "USA");

        return winner;
    }
    public static String totalAI(){
        int deaths =0;
        int USAdeaths = 0;
        int USSRDeaths = 0;

        for(int i =0; i< NUKES; i++){
            if(noBombing(deaths )){
                deaths = AIH("USA");
                USSRDeaths += deaths;
            }
            if(noBombing(deaths)) {
                deaths = AIH("USSR");
                USAdeaths+= deaths;
            }
        }
        String winner;
        if(USAdeaths>= USSRDeaths)
            winner = winner(USSRDeaths, "USSR");
        else
            winner = winner(USAdeaths, "USA");

        return winner;

    }
    public static String winner(int deaths, String country){
        double totalPop = 0;
        if(country == "USSR"){
            for(USSRCities c: USSRCities.values()){
               totalPop += c.pop;
            }
            for(USSRMilitary m: USSRMilitary.values()){
                totalPop += m.pop;
            }
        }
        else{
            for(USAMilitary c: USAMilitary.values()){
                totalPop += c.pop;
            }
            for(Cities c: Cities.values()){
                totalPop += c.pop;
            }
        }
        if(((double)deaths)/totalPop >= .8) return "none";
        else return country;
    }
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("LOGON:");
        String difficulty = logon(scan.nextLine());
        if(difficulty == null) {
            System.out.println("Invalid Logon Connection Terminated");
            return;
        }
        if(difficulty.equals("robot test")){
            for(int i = 0; i< 1000;i++){
                generateMaps();
                System.out.println(totalAI());
            }
        }
        System.out.println("Welcome back Professor Falken");
        System.out.println("Would you like to play a game of Chess?");
        String response = scan.nextLine();
        if(response.equalsIgnoreCase("yes")) return;
        System.out.println("Would you like to play Global Thermonuclear Warfare?");
        response = scan.nextLine();
        if(response.equalsIgnoreCase("no")) return;
        String winner = "";
        System.out.println("Launching Global Thermo Nuclear Warfare");
        generateMaps();
        System.out.println("How many players would you like to play 1 or 2?");
        response = scan.nextLine();
        if(response.equalsIgnoreCase("zero")){

            winner = totalAI();
        }
        else if(response.equals("1")){
            System.out.println("Which country would you like to play: USA or USSR?");
            response = scan.nextLine();
            if(response.equals("USSR"))
                winner = GameAI(scan, "USSR", difficulty);
            else
                winner = GameAI(scan, "USA", difficulty);
        }
        else if(response.equals("2")){
            game(scan);
        }
        else {
            System.out.println("You are too stupid to play\n CONNECTION TERMINATED");
            return;
        }
        if(winner.equals( "none"))
            System.out.println("No one wins");
        else
            System.out.println(winner + " wins!");

        /*
         Game order:
         1. pick sides
         2. display sets of targets
         3. remove target from list
         4. next player turn

         Build order:
         1. 2 maps of both sides
         2. AI
         3. make move class
         */




    }
}
