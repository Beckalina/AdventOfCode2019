import java.util.Objects;

public class Satellite {
    String name;

    public Satellite(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Satellite satellite = (Satellite) o;
        return Objects.equals(name, satellite.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
