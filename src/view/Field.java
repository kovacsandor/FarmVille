package view;

import component.*;

public class Field {

    /**
     * <p>Draws a Field.</p>
     *
     * @param field - the Field to be drawn
     */
    public static String draw(component.Field field) {
        String result;
        Installation installation = field.getInstallation();
        if (field.getIsActionUnderExecution()) {
            result = "X ";
        } else if (installation == null) {
            result = "[]";
        } else if (installation instanceof Barley && installation.isReady()) {
            result = "B ";
        } else if (installation instanceof Barley) {
            result = "b ";
        } else if (installation instanceof Corn && installation.isReady()) {
            result = "C ";
        } else if (installation instanceof Corn) {
            result = "c ";
        } else if (installation instanceof FireStation && installation.isReady()) {
            result = "S ";
        } else if (installation instanceof FireStation) {
            result = "s ";
        } else if (installation instanceof FowlHouse && installation.isReady()) {
            result = "F ";
        } else if (installation instanceof FowlHouse) {
            result = "f ";
        } else if (installation instanceof Garage && installation.isReady()) {
            result = "G ";
        } else if (installation instanceof Garage) {
            result = "g ";
        } else if (installation instanceof Laboratory && installation.isReady()) {
            result = "L ";
        } else if (installation instanceof Laboratory) {
            result = "l ";
        } else if (installation instanceof Oats && installation.isReady()) {
            result = "O ";
        } else if (installation instanceof Oats) {
            result = "o ";
        } else if (installation instanceof Pigpen && installation.isReady()) {
            result = "P ";
        } else if (installation instanceof Pigpen) {
            result = "p ";
        } else if (installation instanceof Rice && installation.isReady()) {
            result = "R ";
        } else if (installation instanceof Rice) {
            result = "r ";
        } else if (installation instanceof Wheat && installation.isReady()) {
            result = "W ";
        } else if (installation instanceof Wheat) {
            result = "w ";
        } else {
            throw new RuntimeException("Unexpected scenario.");
        }
        return result;
    }
}
