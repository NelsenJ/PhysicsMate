package physicsmate.model;

public class Wave {

    // v = f * lambda

    public static double calculateVelocity(double frequency, double wavelength) {
        return frequency * wavelength;
    }

    public static double calculateFrequency(double velocity, double wavelength) {
        return velocity / wavelength;
    }

    public static double calculateWavelength(double velocity, double frequency) {
        return velocity / frequency;
    }
}
