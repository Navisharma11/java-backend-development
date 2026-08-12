package com.navisharma.RestApiXML.model;

import tools.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//@XmlRootElement
@JacksonXmlRootElement    // To share or receive data in the form of xml By default jackson api bind the data only for the json so for xml we need to add the dependency
public class Course
{
    private Integer id;
    private String course;
    private String duration;
    private Double cost;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Course() {
        super();
    }

    public Course(Integer id, String course, String duration, Double cost) {
        super();
        this.id = id;
        this.course = course;
        this.duration = duration;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", course='" + course + '\'' +
                ", duration='" + duration + '\'' +
                ", cost=" + cost +
                '}';
    }
}
