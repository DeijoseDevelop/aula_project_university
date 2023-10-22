package src.models;

import java.time.Year;
import java.util.Map;

import src.constants.Constants;
import src.enums.Shift;

public class AcademicOffert {
    private static int countAcademicOffert;
    private int id;
    private AcademicProgram academicProgram;
    private Shift shift;
    private short numberOfQuotas;
    private AcademicPeriod academicPeriod;

    public AcademicOffert() {
        this.id = ++AcademicOffert.countAcademicOffert;
    }

    public AcademicOffert(
        AcademicProgram academicProgram,
        Shift shift,
        short numberOfQuotas,
        AcademicPeriod academicPeriod
    ) {
        this.id = ++AcademicOffert.countAcademicOffert;
        this.academicProgram = academicProgram;
        this.shift = shift;
        this.numberOfQuotas = numberOfQuotas;
        this.academicPeriod = academicPeriod;
    }

    public int getId() {
        return this.id;
    }

    public AcademicProgram getAcademicProgram() {
        return this.academicProgram;
    }

    public Shift getShift() {
        return this.shift;
    }

    public short getNumberOfQuotas() {
        return this.numberOfQuotas;
    }

    public AcademicPeriod getAcademicPeriod() {
        return this.academicPeriod;
    }

    public void setAcademicProgram(AcademicProgram academicProgram) {
        this.academicProgram = academicProgram;
    }

    public void setAcademicPeriod(AcademicPeriod academicPeriod) {
        this.academicPeriod = academicPeriod;
    }

    public static AcademicOffert fromJson(Map<String, String> json) {
        Constants constants = new Constants();
        return new AcademicOffert(
            new AcademicProgram(json.get("academic_program")),
            constants.getChift(json.get("shift")),
            Short.parseShort(json.get("number_of_quotas")),
            new AcademicPeriod(
                Byte.parseByte(json.get("academic_period_type")),
                Year.of(Integer.parseInt(json.get("academic_period_year")))
            )
        );
    }

    @Override
    public String toString() {
        return String.format("AcademicOffert(id=%d)", this.id);
    }
}
