public enum USAMilitary {
    Pentagon("Pentagon", PopulationGetter.military()+4000),
    WhiteHouse("White House", PopulationGetter.military()),
    Area51("Area 51", PopulationGetter.military()),
    Lewis("Joint Base Lewis McCord", PopulationGetter.military()),
    Knox("Fort Knox", PopulationGetter.military());



    public String name;
    public int pop;
    USAMilitary(String name, int Pop){
        this.name = name;
        pop = Pop;
    }
}
