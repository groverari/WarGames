public class PopulationGetter {
    public static int bigCity(){
        int min= 8000000;
        int max = 12000000;
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
    public static int medCity(){
        int min= 3000000;
        int max = 8000000;
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
    public static int smallCity(){
        int min= 1000000;
        int max = 3000000;
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
    public static int military(){
        int min= 10000;
        int max = 30000;
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }
}
