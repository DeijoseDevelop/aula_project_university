package src.models;

import java.time.Year;
import java.util.*;

import src.interfaces.DataModel;

public class AcademicPeriod implements DataModel {
    private static int countAcademicPeriod;
    private int id;
    private Year year;
    private byte type;
    private List<AcademicOffert> academicOfferts;

    public AcademicPeriod() {
        this.id = ++AcademicPeriod.countAcademicPeriod;
    }

    public AcademicPeriod(byte type) {
        this.id = ++AcademicPeriod.countAcademicPeriod;
        this.year = Year.now();
        this.type = type;
        this.academicOfferts = new ArrayList<AcademicOffert>();
    }

    public AcademicPeriod(byte type, Year year) {
        this.id = ++AcademicPeriod.countAcademicPeriod;
        this.year = year;
        this.type = type;
        this.academicOfferts = new ArrayList<AcademicOffert>();
    }

    public int getId() {
        return this.id;
    }

    public Year getYear() {
        return this.year;
    }

    public byte getType() {
        return this.type;
    }

    public String getName() {
        return String.format("%s-%s", this.year.getValue(), this.type);
    }

    public List<AcademicOffert> getAcademicOfferts() {
        return academicOfferts;
    }

    public void addAcademicOffert(AcademicOffert asAcademicOffert) {
        this.academicOfferts.add(asAcademicOffert);
    }

    public void addAllAcademicOffert(AcademicOffert... asAcademicOfferts) {
        for (AcademicOffert academicOffert : asAcademicOfferts) {
            this.academicOfferts.add(academicOffert);
        }
    }

    public static List<AcademicPeriod> fromJsonList(List<Map<String, String>> jsonList) {
        List<AcademicPeriod> academicPeriods = new ArrayList<AcademicPeriod>();
        for (Map<String, String> json : jsonList) {
            academicPeriods.add(AcademicPeriod.fromJson(json));
        }
        return academicPeriods;
    }

    public static AcademicPeriod fromJson(Map<String, String> json) {
        return new AcademicPeriod(
            Byte.parseByte(json.get("type")),
            Year.of(Integer.parseInt(json.get("year")))
        );
    }

    public static AcademicPeriod getObj(List<AcademicPeriod> data, int id) throws Exception {
        AcademicPeriod selectedAcademicPeriod = null;
        for (AcademicPeriod academicPeriod : data) {
            if (academicPeriod.getId() == id) selectedAcademicPeriod = academicPeriod;
        }

        if (selectedAcademicPeriod == null) {
            throw new Exception("There is no such academic period.");
        }

        return selectedAcademicPeriod;
    }

    @Override
    public Map<String, String> toJson(){
        Map<String, String> json = new HashMap<String, String>();

        return json;
    }

    @Override
    public String toString() {
        return String.format("AcademicPeriod(name=%d-%d)", this.year.getValue(), this.type);
    }
}
