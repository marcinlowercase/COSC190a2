package cosc190_assignment_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AirQuery {

    public static List<AirCraft> loadInfo(String path) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(path))){
            return lines.skip(1)
                    .map(line -> line.split(","))
                    .map(AirCraft::new)
                    .collect(Collectors.toList());
        }
    }

    public static List<String> getCountryList(List<AirCraft> airCraftList) {
        return airCraftList.stream()
                .map(AirCraft::getCountry)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public static ArrayList<String> identifyTypes(List<AirCraft> airCraftList) {
        return (ArrayList<String>) airCraftList.stream()
                .map(AirCraft::getType)
                .distinct()
                .collect(Collectors.toList());
    }

    public static int getCount(List<AirCraft> airCraftList, String country) {
        return (int) airCraftList.stream()
                .filter(ct -> ct.getCountry().equals(country))
                .count();
    }

    public static List<AirCraft> getListByType(List<AirCraft> airCraftList, String type) {
        return airCraftList.stream()
                .filter(t -> t.getType().equals(type))
                .collect(Collectors.toList());
    }

    public static List<AirCraft> getListByTypeSortYear(List<AirCraft> airCraftList, String type) {
        return airCraftList.stream()
                .filter(t -> t.getType().equals(type))
                .sorted(Comparator.comparingInt(AirCraft::getInService))
                .collect(Collectors.toList());
    }

    public static List<String> getNamesBySubTypeYear(List<AirCraft> airCraftList, String subType, int year) {
        return airCraftList.stream()
                .filter(a -> a.isOfSubtype(subType))
                .filter(y -> y.getInService()== year)
                .map(AirCraft::getName)
                .collect(Collectors.toList());

    }

    public static List<String> getCountByCountry(List<AirCraft> airCraftList) {
        return airCraftList.stream()
                .collect(Collectors.groupingBy(AirCraft::getCountry, Collectors.counting()))
                .entrySet()
                .stream()
                .map(a -> a.getKey() + ":" + a.getValue())
                .collect(Collectors.toList());
    }

    public static List<String> getCountByType(List<AirCraft> airCraftList, int year) {
        return airCraftList.stream()
                .filter(y -> y.getInService() == year)
                .collect(Collectors.groupingBy(AirCraft::getType, Collectors.counting()))
                .entrySet()
                .stream()
                .map(a -> a.getKey() + ":" + year + ":" + a.getValue())
                .collect(Collectors.toList());
    }

    public static List<String> getSubTypes(List<AirCraft> airCraftList){
        return airCraftList.stream()
                .map(AirCraft::getSubTypes)
                .reduce(new ArrayList<>(), (a, b) -> {
                    a.addAll(b);
                    return a;
                })
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
