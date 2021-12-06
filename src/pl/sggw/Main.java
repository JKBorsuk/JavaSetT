package pl.sggw;

public class Main {

    public static void main(String[] args) {
        WzimSet<Integer> zbior = new WzimSet<>();


        zbior.add(2);
        zbior.add(3);
        zbior.add(5);
        zbior.add(2);
        System.out.println(zbior.isEmpty());

        for (Integer znak : zbior)
            System.out.print(znak + " ");
        System.out.print('\n');

        WzimSet<Integer> zbior_2 = new WzimSet<>();

        zbior_2.add(2);
        zbior_2.add(3);
        zbior_2.add(7);

        System.out.println(zbior.addAll(zbior_2));

        for (Integer znak : zbior)
            System.out.print(znak + " ");
        System.out.print('\n');

        zbior.removeAll(zbior_2);

        for (Integer znak : zbior)
            System.out.print(znak + " ");
        System.out.print('\n');

        zbior.remove(5);

        for (Integer znak : zbior)
            System.out.print(znak + " ");
        System.out.print('\n');
    }
}
