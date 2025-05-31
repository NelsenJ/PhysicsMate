package physicsmate.model;

public class Gravity {
    private static final double G = 6.67430e-11; // Konstanta gravitasi

    public static double calculateForce(double m1, double m2, double r) {
        return G * (m1 * m2) / (r * r);
    }

    public static double calculateMass1(double f, double m2, double r) {
        return (f * r * r) / (G * m2);
    }

    public static double calculateMass2(double f, double m1, double r) {
        return (f * r * r) / (G * m1);
    }

    public static double calculateDistance(double f, double m1, double m2) {
        return Math.sqrt((G * m1 * m2) / f);
    }
}
