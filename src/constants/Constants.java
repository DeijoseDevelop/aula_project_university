package src.constants;

import java.util.*;
import src.enums.*;

public class Constants {
    public Map<String, CivilState> civilStates;
    public Map<String, Shift> chifts;

    public Constants() {
        this.civilStates = this.getCivilStates();
        this.chifts = this.getChifts();
    }

    private Map<String, CivilState> getCivilStates() {
        Map<String, CivilState> civilStates = new TreeMap<String, CivilState>();

        civilStates.put("single", CivilState.SINGLE);
        civilStates.put("married", CivilState.MARRIED);
        civilStates.put("divorced", CivilState.DIVORCED);
        civilStates.put("widower", CivilState.WIDOWER);

        return civilStates;
    }

    private Map<String, Shift> getChifts() {
        Map<String, Shift> shifts = new TreeMap<String, Shift>();

        shifts.put("morning", Shift.MORNING);
        shifts.put("afternoon", Shift.AFTERNOON);
        shifts.put("night", Shift.NIGHT);

        return shifts;
    }

    public CivilState getCivilState(String state) {
        return this.civilStates.get(state);
    }

    public Shift getChift(String state) {
        return this.chifts.get(state);
    }
}
