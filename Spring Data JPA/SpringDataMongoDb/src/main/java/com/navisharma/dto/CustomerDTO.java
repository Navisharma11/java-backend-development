package com.navisharma.dto;

public class CustomerDTO
{
    private String id;

    private Integer custNo;

    private String name;

    private String city;

    public CustomerDTO(String name, String id, Integer custNo, String city)
    {
        super();
        this.name = name;
        this.id = id;
        this.custNo = custNo;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerDTO()
    {
        super();
    }

    public Integer getCustNo() {
        return custNo;
    }

    public void setCustNo(Integer custNo) {
        this.custNo = custNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ", custNo=" + custNo +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
