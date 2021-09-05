package com.streams.playground;

import com.streams.playground.model.Hotel;
import com.streams.playground.model.Room;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class HotelManager {
    private static final List<Hotel> hotels = List.of(new Hotel("JW Marriott",
                                                                List.of(
                                                                        new Room("Delux", 2300, 3),
                                                                        new Room("Standard", 1300, 2)),
                                                                7),
                                                      new Hotel("Westin",
                                                                List.of(
                                                                        new Room("Delux", 2340, 4),
                                                                        new Room("Standard", 1200, 2)),
                                                                8),
                                                      new Hotel("Trident",
                                                                List.of(
                                                                        new Room("Premium", 1340, 2),
                                                                        new Room("Standard", 900, 1)),
                                                                9));

    public static void main(String[] args) {
        System.out.printf("%s: %s%n", "hotelNames", hotelNames());
        System.out.printf("%s: %s%n", "roomTypes", roomTypes());
        System.out.printf("%s: %s%n", "hotelWithRating", hotelWithRating());
        System.out.printf("%s: %s%n", "hotelsWithRating", hotelsWithRating());
        System.out.printf("%s: %s%n", "cheapestRoomRentForHotelWithRating", cheapestRoomRentForHotelWithRating());
        System.out.printf("%s: %s%n", "nameInCapitalForHotelWithRating", nameInCapitalForHotelWithRating());
        System.out.printf("%s: %s%n", "getHotelNamesHavingRoomOfCapacity", getHotelNamesHavingRoomOfCapacity());
        System.out.printf("%s: %s%n", "cheapestRoom", cheapestRoom());
        System.out.printf("%s: %s%n", "getConcatenatedHotelNames", getConcatenatedHotelNames());
        System.out.printf("%s: %s%n", "getHotelRatings", getHotelRatings());
        System.out.printf("%s: %s%n", "getRoomRentsByRoomType", getRoomRentsByRoomType());
    }

    /**
     * Return list of all hotels
     */
    public static List<String> hotelNames() {
        return hotels.stream().map(Hotel::name).toList();
    }

    /**
     * Return all the unique types of rooms in all the hotels
     */
    public static List<String> roomTypes() {
        return hotels.stream().flatMap(h -> h.rooms().stream().map(Room::type)).distinct().toList();
    }

    /**
     * Find a hotel with rating greater than 7
     */
    public static Optional<Hotel> hotelWithRating() {
        return hotels.stream().filter(h -> h.rating() > 7).findAny();
    }

    /**
     * Find all hotels with rating greater than 7
     */
    public static List<Hotel> hotelsWithRating() {
        return hotels.stream().filter(h -> h.rating() > 7).toList();
    }

    /**
     * Return name of the hotel in capital having rating greater than 7
     */
    public static Optional<String> nameInCapitalForHotelWithRating() {
        return hotels.stream()
                     .filter(h -> h.rating() > 7)
                     .findAny()
                     .map(h -> h.name().toUpperCase());
    }

    /**
     * Find the cheapest room rent for a hotel having rating greater than 7
     */
    public static Optional<Double> cheapestRoomRentForHotelWithRating() {
        return hotels.stream()
                     .filter(h -> h.rating() > 7)
                     .findAny()
                     .flatMap(h -> h.rooms().stream().map(Room::price).min(Double::compare));
    }

    /**
     * Get the name of the hotels, having at least one room of capacity greater than 2
     */
    public static List<String> getHotelNamesHavingRoomOfCapacity() {
        return hotels.stream()
                     .filter(h -> h.rooms().stream().anyMatch(r -> r.capacity() > 2))
                     .map(Hotel::name)
                     .toList();

    }

    /**
     * Get the price of any room having price less than 2000 in a hotel having rating greater than 4. If not found throw exception
     */
    public static Double cheapestRoom() {
        return hotels.stream()
                     .filter(h -> h.rating() > 4)
                     .flatMap(h -> h.rooms().stream().filter(r -> r.price() < 2000))
                     .findAny()
                     .map(Room::price)
                     .orElseThrow(() -> new RuntimeException("No room found"));

    }

    /**
     * Get comma separated string containing all the hotel names (without using Collectors.joining())
     * If no hotel is present return empty string
     */
    public static String getConcatenatedHotelNames() {
        return hotels.stream().map(Hotel::name).reduce((a, b) -> a + ", " + b).orElse("");
    }

    /**
     * Return a map of hotel name and rating
     */
    public static Map<String, Integer> getHotelRatings() {
        return hotels.stream().collect(Collectors.toMap(Hotel::name, Hotel::rating));
    }

    /**
     * Return all the room rents for each type of the room along with the type of the room
     */
    public static Map<String, List<Double>> getRoomRentsByRoomType() {
        return hotels.stream()
                     .flatMap(h -> h.rooms().stream())
                     .collect(groupingBy(Room::type, mapping(Room::price, toList())));
    }
}
