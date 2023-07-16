public class State {
    private String name;
    protected State(String name){
        this.name = name;
    }

    protected State() {
        this("Melaka");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
