import java.util.Arrays;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        if (!Character.isUpperCase(a)) {
            throw new IllegalArgumentException("diamond print only allow uppercase letters");
        }

        int rowSize = 1 + 2 * (a - 'A');
        String[] diamond = new String[rowSize];
        char[] row = new char[rowSize];
        Arrays.fill(row, ' ');


        for (int idx = 0, middle = rowSize / 2, c = 'A'; idx <= diamond.length / 2; idx++, c++) {
            row[middle + idx] = (char) c;
            row[middle - idx] = (char) c;

            String diamondRow = new String(row);
            diamond[idx] = diamondRow;
            diamond[diamond.length - 1 - idx] = diamondRow;

            row[middle + idx] = ' ';
            row[middle - idx] = ' ';
        }

        return Arrays.asList(diamond);
    }

}
