package src.models;

import java.time.Year;
import java.util.Map;

public class AcademicPeriod {
    private static int countAcademicPeriod;
    private int id;
    private Year year;
    private byte type;

    public AcademicPeriod() {
        this.id = ++AcademicPeriod.countAcademicPeriod;
    }

    public AcademicPeriod(byte type) {
        this.id = ++AcademicPeriod.countAcademicPeriod;
        this.year = Year.now();
        this.type = type;
    }

    public AcademicPeriod(byte type, Year year) {
        this.id = ++AcademicPeriod.countAcademicPeriod;
        this.year = year;
        this.type = type;
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

    public static AcademicPeriod fromJson(Map<String, String> json) {
        return new AcademicPeriod(
            Byte.parseByte(json.get("type")),
            Year.of(Integer.parseInt(json.get("year")))
        );
    }

    @Override
    public String toString() {
        return String.format("AcademicPeriod(name=%d-%d)", this.year.getValue(), this.type);
    }
}
