package com.company;

public class Main {

    public static void main(String[] args) {
	    SetT<Integer> zbior = new SetT<>();


        zbior.add(2);
        zbior.add(3);
        zbior.add(5);
        zbior.add(2);
        System.out.println(zbior.isEmpty());

        for (Integer znak : zbior)
            System.out.print(znak + " ");
        System.out.print('\n');

        SetT<Integer> zbior_2 = new SetT<>();

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
