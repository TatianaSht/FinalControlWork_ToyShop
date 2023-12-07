public class Toy {
    private int id;
    private String name;
    private int probability;

    public Toy(int id, String name, int probability) {
        this.id = id;
        this.name = name;
        this.probability = probability;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProbability() {
        return probability;
    }

    public String toString() {
        return "id: " + getId() + ", Вес: " + getProbability() + ", Наименование: " + getName();
    }   
}
