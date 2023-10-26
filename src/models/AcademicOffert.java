package src.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import src.constants.Constants;
import src.enums.Shift;
import src.interfaces.DataModel;
import src.utils.DataFilter;

public class AcademicOffert implements DataModel {
    private static int countAcademicOffert;
    private int id;
    private Shift shift;
    private short numberOfQuotas;
    private AcademicProgram academicProgram;
    private AcademicPeriod academicPeriod;

    public AcademicOffert() {
        this.id = ++AcademicOffert.countAcademicOffert;
    }

    public AcademicOffert(
        Shift shift,
        short numberOfQuotas,
        AcademicProgram academicProgram,
        AcademicPeriod academicPeriod
    ) {
        this.id = ++AcademicOffert.countAcademicOffert;
        this.shift = shift;
        this.numberOfQuotas = numberOfQuotas;
        this.academicProgram = academicProgram;
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
        return academicPeriod;
    }

    public void setAcademicProgram(AcademicProgram academicProgram) {
        this.academicProgram = academicProgram;
    }

    public static List<AcademicOffert> fromJsonList(
        List<Map<String, String>> jsonList,
        DataFilter dataFilter
    ) throws NumberFormatException, Exception {
        List<AcademicOffert> academicOfferts = new ArrayList<AcademicOffert>();
        for (Map<String, String> json : jsonList) {
            academicOfferts.add(AcademicOffert.fromJson(json, dataFilter));
        }
        return academicOfferts;
    }

    public static AcademicOffert fromJson(
        Map<String, String> json,
        DataFilter dataFilter
    ) throws NumberFormatException, Exception {

        AcademicProgram academicProgram = dataFilter.getAcademicProgram(
            Integer.parseInt(json.get("academic_program"))
        );
        AcademicPeriod academicPeriod = dataFilter.getAcademicPeriod(
            Integer.parseInt(json.get("academic_period"))
        );

        AcademicOffert academicOffert = new AcademicOffert(
            Constants.chifts.get(json.get("shift")),
            Short.parseShort(json.get("number_of_quotas")),
            academicProgram,
            academicPeriod
        );

        return academicOffert;
    }

    public static AcademicOffert getObj(List<AcademicOffert> data, int id) throws Exception {
        AcademicOffert selectedAcademicOffert = null;
        for (AcademicOffert academicOffert : data) {
            if (academicOffert.getId() == id) selectedAcademicOffert = academicOffert;
        }

        if (selectedAcademicOffert == null) {
            throw new Exception("There is no such academic offert.");
        }

        return selectedAcademicOffert;
    }

    @Override
    public String toString() {
        return String.format("AcademicOffert(id=%d)", this.id);
    }
}
