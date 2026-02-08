import java.util.ArrayList;
import java.util.List;

class FlowerFieldBoard {
    private final List<String> board;
    private final int rowSize;
    private final int columnSize;

    FlowerFieldBoard(List<String> boardRows) {
        board = boardRows;
        rowSize = boardRows.size();
        columnSize = board.isEmpty() ? 0 : board.getFirst().length();
    }


    List<String> withNumbers() {
        ArrayList<String> result = new ArrayList<>(rowSize);

        for (int i = 0; i < rowSize; i++) {
            StringBuilder rowWithNumber = new StringBuilder(columnSize);

            for (int j = 0; j < columnSize; j++) {
                if (board.get(i).charAt(j) == ' ') {
                    rowWithNumber.append(countFlowers(i, j));
                } else if (board.get(i).charAt(j) == '*') {
                    rowWithNumber.append("*");
                } else {
                    throw new RuntimeException("Board can only contain spaces and asterisks");
                }
            }
            result.add(rowWithNumber.toString());
        }
        return result;
    }

    private String countFlowers(int row, int col) {
        int flowers = 0;

        for (int dr = -1 ; dr <= 1 ; dr++) {
            for (int dc = -1 ; dc <= 1 ; dc++) {
                if (dr == 0 && dc == 0) continue;

                int curRow = row + dr;
                int curCol = col + dc;

                if (curRow >= 0 && curRow < rowSize && curCol >= 0 && curCol < columnSize) {
                    if (board.get(curRow).charAt(curCol) == '*') flowers++;
                }
            }
        }
        return flowers == 0 ? " " : flowers + "";
    }

}