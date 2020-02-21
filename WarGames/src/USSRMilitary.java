public enum USSRMilitary {
    KGB("KGB Headquarters", PopulationGetter.military()),
    Hantsavichy("Hantsavichy Radar Station", PopulationGetter.military()),
    Baikonur("Baikonur Cosmodrome", PopulationGetter.military()),
    Shayrat("Shayrat Airbase", PopulationGetter.military()),
    Kremlin("Kremlin", PopulationGetter.military());

    public String name;
    public int pop;
    USSRMilitary(String name, int Pop){
        this.name = name;
        pop = Pop;
    }
}
