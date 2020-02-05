/**
 * @author Krasyuk Vladimir Andreevich Cheliabins 2020
 */
public class UsefulMethods {
    static public int GetNumberOfEntryArrays(int[] Array1, int[] Array2) {
        int numberOfEntry = 0;
        for (int i = 0; i < Array2.length; i++) {
            for (int x = 0; x < Array1.length; x++) {
                if (Array2[i] == Array1[x]) {
                    numberOfEntry += 1;
                }


            }
        }
        return numberOfEntry;
    }
    static public int GetUniqueArrayValues(int[] Array) {
        int numberUniqueValues = 1;
        for (int i = 0; i <= Array.length-2; i++) {
            if(Array[i] != Array[i+1])
                numberUniqueValues += 1;
        }
        return numberUniqueValues;
    }
}
