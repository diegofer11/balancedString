package balanced;

import java.util.*;

public class Balanced {
    public static void main(String[] args) {
        // EJERCICIO 1
        for (int idx = 1; idx <= 20; idx++) {
            if (idx % 3 == 0 && idx % 5 == 0) {
                System.out.println("fizzbuzz");
            } else if (idx % 5 == 0) {
                System.out.println("buzz");
            } else if (idx % 3 == 0) {
                System.out.println("fizz");
            } else {
                System.out.println(idx);
            }
        }

        //EJERCICIO 2
        Set<Integer> chars = new HashSet<>();
        String s = "El viejo Señor Gómez pedía queso, kiwi y habas, pero le ha tocado un saxo.".toLowerCase();
        s = s.replace("ñ", "n");
        s = s.replace("ó", "o");
        s = s.replace("í", "i");
        s = s.replace("û", "u");
        s = s.replace(".", "");
        s = s.replace(",", "");
        s = s.replace(" ", "");
        boolean b = s.length() > 25 && s.chars()
                .filter(i -> i >= 'a' && i <= 'z') //only alphabet
                .filter(chars::add)                //add to our tracking set if we reach this point
                .filter(i -> chars.size() == 26)   //filter the 26th letter found
                .findAny().isPresent();
        System.out.println("el texto:::" + s + " es:" + b);

        //EJERCICIO 3
        Car car1 = new Car("Ford", "EcoSport", "2020", "A123");
        Car car2 = new Car("Audi", "Q2", "2021", "A124");
        Car car3 = new Car("Ford", "Aspire", "2021", "A125");
        Car car4 = new Car("Audi", "Q2", "2021", "A124");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);

        Set<String> uniqueMakes = new HashSet<>();
        cars.forEach(c -> {
            if (uniqueMakes.contains(c.getMake())) {
                uniqueMakes.remove(c.getMake());
            } else {
                uniqueMakes.add(c.getMake());
            }
        });

        System.out.println("unique makes:::" + uniqueMakes);

        //EJERCICIO 4
        Random random = new Random();

        int[] array = random.ints(20, 10, 100).toArray();
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arr, start, end);
            quickSort(arr, start, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;
        return i + 1;
    }
}