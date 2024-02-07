package cosc190_assignment_2;

import java.util.*;
import java.util.stream.Stream;

public class AirCraft {
    private String type;
    private List<String> subTypes;
    private String name;
    private int inService;
    private String country;

//    public AirCraft(String[] sArgs) {
//        if ( sArgs.length == 5){
//            this.type = sArgs[TYPE];
//            this.subTypes.add(sArgs[SUBTYPES]);
//            this.name = sArgs[NAME];
//            this.inService = Integer.parseInt(sArgs[INSERVICE]);
//            this.country = sArgs[COUNTRY];
//        } else {
//            this.type = sArgs[0];
//            String subRaw = Arrays.toString(Arrays.copyOfRange(sArgs,1, sArgs.length - 3));
//            this.subTypes = Arrays.stream(subRaw.split(",|and"))
//                    .map(x -> x.replaceAll("[\"\\[\\]]", "" ))
//                    .map(String::trim)
//                    .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
//                    .toList();
//            this.name = sArgs[sArgs.length - 3];
//            this.inService = Integer.parseInt(sArgs[sArgs.length - 2]);
//            this.country = sArgs[sArgs.length - 1];
//        }
//    }

    public AirCraft(String[] sArgs) {
            this.type = sArgs[0];
            String subRaw = Arrays.toString(Arrays.copyOfRange(sArgs,1, sArgs.length - 3));
            this.subTypes = Arrays.stream(subRaw.split(","))
                    .map(x -> x.replaceAll("[\"\\[\\]]", "" ))
                    .map(String::trim)
                    .map(s -> s.substring(0,1).toUpperCase() + s.substring(1))
                    .toList();
            this.name = sArgs[sArgs.length - 3];
            this.inService = Integer.parseInt(sArgs[sArgs.length - 2]);
            this.country = sArgs[sArgs.length - 1];
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getInService() {
        return inService;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getSubTypes() {
        return subTypes;
    }

    public boolean isOfSubtype(String sSubType){
        return this.subTypes.stream()
                .anyMatch(str -> str.compareToIgnoreCase(sSubType) == 0);
    }

    @Override
    public boolean equals(Object obOther) {
        if (this == obOther) return true;
        if (obOther == null || getClass() != obOther.getClass()) return false;
        AirCraft airCraft = (AirCraft) obOther;
        return inService == airCraft.inService && Objects.equals(type, airCraft.type) && Objects.equals(subTypes, airCraft.subTypes) && Objects.equals(name, airCraft.name) && Objects.equals(country, airCraft.country);
    }

    @Override
    public String toString() {
        return "AirCraft{" +
                "type='" + type + '\'' +
                ", subTypes=" + subTypes +
                ", name='" + name + '\'' +
                ", inService=" + inService +
                ", country='" + country + '\'' +
                '}';
    }
}

