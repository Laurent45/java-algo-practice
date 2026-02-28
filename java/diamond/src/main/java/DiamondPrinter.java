import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {
        if (!Character.isUpperCase(a)) {
            throw new IllegalArgumentException("diamond print only allow uppercase letters");
        }

        int sideLength = 1 + 2 * (a - 'A');
        List<String> diamond = new ArrayList<>(sideLength);
        StringBuilder row = new StringBuilder(" ".repeat(sideLength));

        row.setCharAt(0, a);
        row.setCharAt(sideLength - 1, a);
        diamond.add(row.toString());
        row.setCharAt(0, ' ');
        row.setCharAt(sideLength - 1, ' ');

        a--;
        int shrunkSize = 1;
        while (a >= 'A') {
            row.setCharAt(shrunkSize, a);
            row.setCharAt(sideLength - 1 - shrunkSize, a);

            diamond.addFirst(row.toString());
            diamond.addLast(row.toString());

            row.setCharAt(shrunkSize, ' ');
            row.setCharAt(sideLength - 1 - shrunkSize, ' ');

            shrunkSize++;
            a--;
        }

        return diamond;
    }

}
