package D3.models;

public class Address {
    private String street;
    private String postalCode;
    private String city;
    private String county;

    Address(String street, String postalCode, String city, String country) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.county = country;
    }

    public String getStreet() {
        return this.street;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.county;
    }
}
