/**
 * Created by Luke Pollen of pollenanalytics.com on 05/07/2017.
 */

package pollenStats;

public class TruthTables {

    public static void main(String args[]) {
        int size = 4;
        generateTable(0, size, new int[size]);
    }

    private static void generateTable(int index, int size, int[] current) {
        if(index == size) { // generated a full "solution"
            for(int i = 0; i < size; i++) {
                System.out.print(current[i] + " ");
            }
            // Prints a blank line after the current character.
            System.out.println();
        } else {
            for(int i = 0; i < 2; i++) {
                current[index] = i;
                generateTable(index + 1, size, current);
            }
        }
    }

}
