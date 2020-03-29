import java.util.Objects;

public class Body {
    String name;
    Body primary;

    public Body(String name){
        this.name = name;
        // default: a body that does not orbit round another is mapped to itself
        this.primary = this;
    }

    public void setPrimary(Body primary){
        this.primary = primary;
    }

    @Override
    public String toString() {
        return name + "->" + primary.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Body body = (Body) o;
        return Objects.equals(name, body.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
