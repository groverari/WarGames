public enum USSRCities {
    Moscow("Moscow", PopulationGetter.bigCity()),
    Stalingrad("Stalingrad", PopulationGetter.medCity()),
    Kiev("Kiev", PopulationGetter.bigCity()),
    Novosibrisk("Novosibrisk", PopulationGetter.smallCity()),
    Kazan("Kazan", PopulationGetter.smallCity()),
    Baku("Baku", PopulationGetter.medCity()),
    Odessa("Odessa", PopulationGetter.bigCity()),
    Samara("Samara", PopulationGetter.smallCity()),
    Volograd("Volograd", PopulationGetter.medCity()),
    Leningrad("Lenningrad", PopulationGetter.medCity());

    public String name;
    public int pop;
    USSRCities(String name, int Pop){
        this.name = name;
        pop = Pop;
    }
}
