import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class ArrayListHome {
    public static void main(String[] args) throws FileNotFoundException {
        // 1й пункт
        try (Scanner scanner = new Scanner(new FileInputStream("File.txt"))) {
            ArrayList<String> line = new ArrayList<>();
            while (scanner.hasNextLine()) {
                line.add(scanner.nextLine());
            }
            for (String s : line) {
                System.out.println(s);
            }
        }

        // 2й пункт
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 8, 15, 16, 23, 42));
        System.out.println(list + " размер = " + list.size());

        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                --i;
            }
        }
        System.out.println(list + " размер = " + list.size());

        // 3й пункт
        ArrayList<Integer> initialList = new ArrayList<>(Arrays.asList(1, 5, 2, 1, 3, 5));

        ArrayList<Integer> newList = new ArrayList<>(initialList);

        for (int i = 0; i < newList.size(); ++i) {
            for (int j = i + 1; j < newList.size(); ++j) {
                if (newList.get(i).equals(newList.get(j))) {
                    newList.remove(j);
                    --j;
                }
            }
        }
        /*
        или так
        ArrayList<Integer> newList = new ArrayList<>(new LinkedHashSet<>(initialList));
        */
        System.out.println(initialList + " размер = " + initialList.size());
        System.out.println(newList + " размер = " + newList.size());
    }
}

