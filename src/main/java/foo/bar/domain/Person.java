package foo.bar.domain;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author roy.zhuo
 */
public class Person {

    private String name;
    private Car car;
    private Address address;
    private String city;
    private List<Car> cars;
    private String info;
    private Map<String, Car> hashCar;
    private Properties properties;

    public Person() {
        System.out.println("person create");
    }

    public Person(String name, Car car) {
        // System.out.println("person youcan create");
        this.name = name;
        this.car = car;
    }

    public Person(String name, Car car, Address address, List<Car> cars, Map<String, Car> hashCar, Properties properties) {
        this.name = name;
        this.car = car;
        this.address = address;
        this.cars = cars;
        this.hashCar = hashCar;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", car=" + car +
            ", address=" + address +
            ", city='" + city + '\'' +
            ", cars=" + cars +
            ", info='" + info + '\'' +
            ", hashCar=" + hashCar +
            ", properties=" + properties +
            '}';
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Map<String, Car> getHashCar() {
        return hashCar;
    }

    public void setHashCar(Map<String, Car> hashCar) {
        this.hashCar = hashCar;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
