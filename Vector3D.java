public class Vector3D {
    double x;
    double y;
    double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }

    double getZ() {
        return z;
    }

    public String toString() {
        return "(" + String.format("%.2f", getX()) + ", " + String.format("%.2f",getY()) + ", " + String.format("%.2f", getZ()) + ")";
    }

    public double getMagnitude(Vector3D vector) {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public double normalize() {
        if (getMagnitude(this) == 0) {
            throw new IllegalStateException();
        }

        return getMagnitude(this) / getMagnitude(this);
    }

    public Vector3D add(Vector3D other) {
        double newX = x + other.x;
        double newY = y + other.y;
        double newZ = z + other.z;

        return new Vector3D(newX, newY, newZ);
    }

    public Vector3D multiply(double scaler) {
        double newX = x * scaler;
        double newY = y * scaler;
        double newZ = z * scaler;

        return new Vector3D(newX, newY, newZ);
    }

    public double dotProduct(Vector3D other) {
        double newX = x * other.x;
        double newY = y * other.y;
        double newZ = z * other.z;

        return newX + newY + newZ;
    }

    public Double angleBetweenTwoVectors(Vector3D other) {
        return Math.acos(dotProduct(other) / (getMagnitude(other) * getMagnitude(this)));
    }

    public Vector3D crossProduct(Vector3D other) {
        double newX = y * other.z - z * other.y;
        double newY = z * other.x - x * other.z;
        double newZ = x * other.y - y * other.x;

        return new Vector3D(newX, newY, newZ);
    }

    public static void main(String[] args) {
        Vector3D vector = new Vector3D(1, 2, 3);

        System.out.println(vector);
    }
}

