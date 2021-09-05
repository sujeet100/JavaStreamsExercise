package com.streams.playground;

import com.streams.playground.model.Hotel;
import com.streams.playground.model.Room;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        return null;
    }

    /**
     * Return all the unique types of rooms in all the hotels
     */
    public static List<String> roomTypes() {
        return null;
    }

    /**
     * Find a hotel with rating greater than 7
     */
    public static Optional<Hotel> hotelWithRating() {
        return Optional.empty();
    }

    /**
     * Find all hotels with rating greater than 7
     */
    public static List<Hotel> hotelsWithRating() {
        return null;
    }

    /**
     * Return name of the hotel in capital having rating greater than 7
     */
    public static Optional<String> nameInCapitalForHotelWithRating() {
        return Optional.empty();
    }

    /**
     * Find the cheapest room rent for a hotel having rating greater than 7
     */
    public static Optional<Double> cheapestRoomRentForHotelWithRating() {
        return Optional.empty();
    }

    /**
     * Get the name of the hotels, having at least one room of capacity greater than 2
     */
    public static List<String> getHotelNamesHavingRoomOfCapacity() {
        return null;
    }

    /**
     * Get the price of any room having price less than 2000 in a hotel having rating greater than 4. If not found throw exception
     */
    public static Double cheapestRoom() {
        return null;
    }

    /**
     * Get comma separated string containing all the hotel names (without using Collectors.joining())
     * If no hotel is present return empty string
     */
    public static String getConcatenatedHotelNames() {
        return null;
    }

    /**
     * Return a map of hotel name and rating
     */
    public static Map<String, Integer> getHotelRatings() {
        return null;
    }

    /**
     * Return all the room rents for each type of the room along with the type of the room
     */
    public static Map<String, List<Double>> getRoomRentsByRoomType() {
        return null;
    }
}
