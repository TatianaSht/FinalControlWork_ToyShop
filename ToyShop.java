import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyShop {

    public static void main(String[] args) throws IOException {
        
        ArrayList<Toy> toys = new ArrayList<>();
        toys.add(new Toy(1, "Transformer", 20));
        toys.add(new Toy(2, "Racing car", 20));
        toys.add(new Toy(3, "Doll", 60));

        fileWriter(toys, "RaffleToys.txt", 10);  
    }


    // Приоритетная очередь с учетом веса игрушки
    public static PriorityQueue<Toy> getQueue(ArrayList<Toy> toys, int number) {
        Comparator<Toy> comparator = (o1, o2) -> o1.getProbability() - o2.getProbability();
        PriorityQueue<Toy> prizeToy = new PriorityQueue<>(comparator);

        for (int i = 0; i < toys.size(); i++) {
            for (int j = 0; j < (toys.get(i).getProbability() * number / 100); j++) {
                prizeToy.add(toys.get(i));
            }
        }
        return prizeToy;
    }

    
    // Рандомный выбор призовой игрушки 
    public static Toy getRaffleToy(PriorityQueue<Toy> toyDeliveryQueue) {
        Toy result = null;
        Random random = new Random();
        int element = random.nextInt(0, toyDeliveryQueue.size());

        for (int i = 0; i <= element; i++) {
            result = toyDeliveryQueue.poll();
        }
        return result;
    }


    // Запись в файл очереди выдачи призовых игрушек
    public static void fileWriter(ArrayList<Toy> toys, String text, Integer number) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(text));

        for (int i = 0; i < number; i++) {
            Toy toy = getRaffleToy(getQueue(toys, number));
            writer.write(toy.toString() + "\n");
        }
        writer.close();
    }
}