package foo.bar.domain;

/**
 * @author roy.zhuo
 */
public class Address {
    private String cityName;

    public Address() {
        System.out.println("address constructor...");
    }

    public Address(String cityName) {

        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Address{" +
            "cityName='" + cityName + '\'' +
            '}';
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
