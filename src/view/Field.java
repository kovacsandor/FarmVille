package view;

import component.*;

public class Field {

    public static String draw(component.Field field) {
        String result;
        Installation installation = field.getInstallation();
        if (field.getIsActionUnderExecution()) {
            result = "X ";
        } else if (installation == null) {
            result = "[]";
        } else if (installation.getClass() == Barley.class && installation.isReady()) {
            result = "B ";
        } else if (installation.getClass() == Barley.class) {
            result = "b ";
        } else if (installation.getClass() == Corn.class && installation.isReady()) {
            result = "C ";
        } else if (installation.getClass() == Corn.class) {
            result = "c ";
        } else if (installation.getClass() == FireStation.class && installation.isReady()) {
            result = "S ";
        } else if (installation.getClass() == FireStation.class) {
            result = "s ";
        } else if (installation.getClass() == FowlHouse.class && installation.isReady()) {
            result = "F ";
        } else if (installation.getClass() == FowlHouse.class) {
            result = "f ";
        } else if (installation.getClass() == Garage.class && installation.isReady()) {
            result = "G ";
        } else if (installation.getClass() == Garage.class) {
            result = "g ";
        } else if (installation.getClass() == Laboratory.class && installation.isReady()) {
            result = "L ";
        } else if (installation.getClass() == Laboratory.class) {
            result = "l ";
        } else if (installation.getClass() == Oats.class && installation.isReady()) {
            result = "O ";
        } else if (installation.getClass() == Oats.class) {
            result = "o ";
        } else if (installation.getClass() == Pigpen.class && installation.isReady()) {
            result = "P ";
        } else if (installation.getClass() == Pigpen.class) {
            result = "p ";
        } else if (installation.getClass() == Rice.class && installation.isReady()) {
            result = "R ";
        } else if (installation.getClass() == Rice.class) {
            result = "r ";
        } else if (installation.getClass() == Wheat.class && installation.isReady()) {
            result = "W ";
        } else if (installation.getClass() == Wheat.class) {
            result = "w ";
        } else {
            throw new RuntimeException("Unexpected scenario.");
        }
        return result;
    }
}
