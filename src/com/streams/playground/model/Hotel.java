package com.streams.playground.model;

import java.util.List;

public record Hotel(String name, List<Room> rooms, int rating) {

}
