public abstract class AbstractAttractions {
    private String name;
    private String startWorking;
    private String endWorking;
    private double cost;

    public AbstractAttractions(String name, String startWorking, String endWorking, double cost) {
        this.name = name;
        this.startWorking = startWorking;
        this.endWorking = endWorking;
        this.cost = cost;
    }

    public AbstractAttractions() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartWorking() {
        return startWorking;
    }

    public void setStartWorking(String startWorking) {
        this.startWorking = startWorking;
    }

    public String getEndWorking() {
        return endWorking;
    }

    public void setEndWorking(String endWorking) {
        this.endWorking = endWorking;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Attractions{" +
                "name='" + name + '\'' +
                ", startWorking='" + startWorking + '\'' +
                ", endWorking='" + endWorking + '\'' +
                ", cost=" + cost +
                '}';
    }
    abstract void printInfo(AbstractAttractions attractions);
}
