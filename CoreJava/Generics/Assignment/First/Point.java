package CoreJava.Generics.Assignment.First;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        // complete the code here
        if (this == obj)
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        // complete the code here
        return this.x;
        //return 0;
    }
}