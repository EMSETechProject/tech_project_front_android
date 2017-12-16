package com.camarasa.robin.nutritivecoach.Activities.Database;

/**
 * Created by robin on 10/12/17.
 */

public class PhysicalData {
    private static Long id;
    private static Float weight;
    private static Long age;
    private static Float size;

    public PhysicalData() {
    }

    public static Float getSize() {
        return size;
    }

    public static Long getId() {
        return id;
    }

    public static Float getWeight() {
        return weight;
    }

    public static Long getAge() {
        return age;
    }

    public static void setAge(Long age) {
        PhysicalData.age = age;
    }

    public static void setId(Long id) {
        PhysicalData.id = id;
    }

    public static void setSize(Float size) {
        PhysicalData.size = size;
    }

    public static void setWeight(Float weight) {
        PhysicalData.weight = weight;
    }
}
