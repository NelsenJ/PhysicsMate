package physicsmate.model;

public class NewtonSecondLaw {

    public static double calculateForce(double mass, double acceleration) {
        return mass * acceleration;
    }

    public static double calculateMass(double force, double acceleration) {
        return force / acceleration;
    }

    public static double calculateAcceleration(double force, double mass) {
        return force / mass;
    }
}
