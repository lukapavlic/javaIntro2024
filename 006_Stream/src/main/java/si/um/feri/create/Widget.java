package si.um.feri.create;

public class Widget {

    private String name;
    private boolean ready;

    public Widget(String name, boolean ready) {
        super();
        this.name = name;
        this.ready = ready;
    }

    public boolean isReady() {
        return this.ready;
    }

    public void execute() {
        System.out.println("Uporabljam: " + this.name);
    }

}
