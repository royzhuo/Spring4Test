package foo.bar.domain;

/**
 * @author roy.zhuo
 */
public class Car {

    private String carName;
    private int maxSpeed;
    private double price;

    public Car(String carName, int maxSpeed, double price) {
        //System.out.println("car youcan create");
        this.carName = carName;
        this.maxSpeed = maxSpeed;
        this.price = price;
    }

    public Car() {
        System.out.println("car wucan create");
    }

    @Override
    public String toString() {
        return "Car{" +
            "carName='" + carName + '\'' +
            ", maxSpeed=" + maxSpeed +
            ", price=" + price +
            '}';
    }

    public String getCarName() {

        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
