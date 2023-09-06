package firstTask;

import javax.xml.namespace.QName;

public abstract class Animal implements Swimable, Runnable {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
