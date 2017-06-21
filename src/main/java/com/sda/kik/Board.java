package com.sda.kik;

import java.util.Arrays;

public class Board {
    /** tablica String[]
     * konstruktor tworzący pustą tablicę ( 9 elementową )
     * metoda addMove (int position, char sign ) - po prostu ustawienie pozycji
     * toString ->
     * 1|2|3
     * X|O|6
     * O|X|9
     */

    private String[] array; // definiujemy tablicę Stringów

    public Board() {
        array = new String[9];  // implementujemy 9 elementową tablicę Stringów
    }

    /**
     *
     * @param position values (1-9)
     */
    public boolean addMove (int position, String sign) {
        boolean valueToReturn = false;
        if (isRangeValid(position) && isPositionEmpty(position)){
            array[position - 1] = sign;
            valueToReturn = true;
        }
        return valueToReturn;
    }

    private boolean isRangeValid(int position){
        return (position > 0 && position <10);
    }

    private boolean isPositionEmpty(int position){
        return array[position-1] == null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i] == null ? (i + 1) : array[i]); //używamy operatora trójargumentowego
            stringBuilder.append((i + 1) % 3 == 0 ? "\n" : "|");
        }
        return stringBuilder.toString();
    }
}
