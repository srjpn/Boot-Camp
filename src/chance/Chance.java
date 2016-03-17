package chance;

public class Chance {
    private double chance;

    private Chance(double chance) {
        this.chance = chance;
    }

    public static Chance create(double chance) throws InvalidProbabilityException {
        if(chance<0 || chance>1)
            throw new InvalidProbabilityException(chance);
        return new Chance(chance);
    }

    public Chance not() throws InvalidProbabilityException {
        return create(1-this.chance);
    }

    public Chance or(Chance chance1) throws InvalidProbabilityException {
        return create(this.chance+chance1.chance);
    }

    public Chance and(Chance chance) throws InvalidProbabilityException {
        return create(this.chance*chance.chance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chance)) return false;

        Chance chance1 = (Chance) o;

        return Double.compare(chance1.chance, chance) == 0;
    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(chance);
        return (int) (temp ^ (temp >>> 32));
    }
}
