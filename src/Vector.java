import java.util.Objects;

public class Vector {

    public final int x;
    public final int y;

    Vector(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {

        if (this == other)
            return true;
        if (!(other instanceof Vector))
            return false;

        Vector that = (Vector) other;

        return (this.x == that.x && this.y == that.y);
    }

    public Vector add(Vector vector) {
        return new Vector(this.x + vector.x, this.y + vector.y);
    }

    public String toString() {

        return "(" + x + ", " + y + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

}
