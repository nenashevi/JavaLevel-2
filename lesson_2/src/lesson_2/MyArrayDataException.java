package lesson_2;

public class MyArrayDataException extends IllegalArgumentException {
    private int row, col;

    public MyArrayDataException(String s, int row, int col) {
        super(s);
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
