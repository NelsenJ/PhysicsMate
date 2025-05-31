package physicsmate.model;

public class KineticEnergy {

    public static double calculateEnergy(double mass, double velocity) {
        return 0.5 * mass * velocity * velocity;
    }

    public static double calculateMass(double energy, double velocity) {
        return (2 * energy) / (velocity * velocity);
    }

    public static double calculateVelocity(double energy, double mass) {
        return Math.sqrt((2 * energy) / mass);
    }
}
