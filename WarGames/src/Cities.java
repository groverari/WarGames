public enum Cities {
    Seattle ("Seattle", PopulationGetter.medCity()),
    NewYork( "New York", PopulationGetter.bigCity()),
    LosAngles("Los Angeles", PopulationGetter.bigCity()),
    Chicago("Chicago", PopulationGetter.medCity()),
    DC("Washington DC", PopulationGetter.smallCity()),
    LasVegas ("Las Vegas", PopulationGetter.medCity()),
    Indy ( "Indianopolis", PopulationGetter.smallCity()),
    Tacoma("Tacoma", PopulationGetter.bigCity()),
    Puyallup("Puyallup", PopulationGetter.smallCity()),
    Dallas("Dallas", PopulationGetter.medCity());
    public String name;
    public int pop;
    Cities(String name, int Pop){
        this.name = name;
        pop = Pop;
    }
}
