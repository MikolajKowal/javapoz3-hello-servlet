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

    private int counter = 0;

    public Board() {
        array = new String[9];  // implementujemy 9 elementową tablicę Stringów
    }

    /**
     *
     * @param position values (1-9)
     */
    public boolean addMove (int position, String sign) {
        boolean valueToReturn = false;
        if (checkRange(position) && isPositionEmpty(position)){
            array[position - 1] = sign;
            counter++;
            valueToReturn = true;
        }
        return valueToReturn;
    }

    public boolean isGameFinished() {
        return isFulfilled() || checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean isFulfilled() {
        return counter == 9;
    }

    private boolean areValuesEquals(int i, int j, int k) {
        return array[i] != null && array[i].equals(array[j]) && array[i].equals(array[k]);
    }

    private boolean checkRows() {
        boolean flag;
        int i = 0;
        do {
            flag = areValuesEquals(i, i + 1, i + 2);
            i += 3;
        } while (i < 9 && !flag);
        return flag;
    }

    private boolean checkColumns() {
        boolean flag;
        int i = 0;
        do {
            flag = areValuesEquals(i, i + 3, i + 6);
            i++;
        } while (i < 3 && !flag);
        return flag;
    }

    private boolean checkDiagonals() {
        return array[4] != null && (areValuesEquals(0, 4, 8) || areValuesEquals(2, 4, 6));
    }

    private boolean checkRange(int position) {
        return (position > 0 && position < 10);
    }

    private boolean isPositionEmpty(int position) {
        return array[position - 1] == null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i] == null ? (i + 1) : array[i]);
            stringBuilder.append((i + 1) % 3 == 0 ? "\n" : "|");
        }
        return stringBuilder.toString();
    }

    public int getCounter() {
        return counter;
    }
}