package src.utils;

import java.util.*;

import src.models.*;

public class DataFilter {
    List<AcademicProgram> academicPrograms;
    List<AcademicPeriod> academicPeriods;
    List<AcademicOffert> academicOfferts;
    List<Student> students;
    List<Applicant> applicants;

    public DataFilter() {
        this.academicPrograms = new ArrayList<AcademicProgram>();
        this.academicPeriods = new ArrayList<AcademicPeriod>();
        this.academicOfferts = new ArrayList<AcademicOffert>();
        this.students = new ArrayList<Student>();
        this.applicants = new ArrayList<Applicant>();
    };

    public void setAcademicPrograms(List<AcademicProgram> academicPrograms) {
        this.academicPrograms = academicPrograms;
    }

    public void setAcademicPeriods(List<AcademicPeriod> academicPeriods) {
        this.academicPeriods = academicPeriods;
    }

    public void setAcademicOfferts(List<AcademicOffert> academicOfferts) {
        this.academicOfferts = academicOfferts;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }

    public AcademicProgram getAcademicProgram(int id) throws Exception {
        for (AcademicProgram obj : this.academicPrograms) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        throw new Exception("");
    }

    public List<AcademicProgram> filterAcademicPrograms(int... ids) {
        List<AcademicProgram> academicPrograms = new ArrayList<AcademicProgram>();
        for (AcademicProgram obj : this.academicPrograms) {
            for (int id : ids) {
                if (obj.getId() != 0 && obj.getId() == id) {
                    academicPrograms.add(obj);
                }
            }
        }
        return academicPrograms;
    }

    public AcademicPeriod getAcademicPeriod(int id) throws Exception {
        for (AcademicPeriod obj : this.academicPeriods) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        throw new Exception("");
    }

    public List<AcademicPeriod> filterAcademicPeriods(int... ids) {
        List<AcademicPeriod> academicPeriods = new ArrayList<AcademicPeriod>();
        for (AcademicPeriod obj : this.academicPeriods) {
            for (int id : ids) {
                if (obj.getId() != 0 && obj.getId() == id) {
                    academicPeriods.add(obj);
                }
            }
        }
        return academicPeriods;
    }

    public AcademicOffert getAcademicOffert(int id) throws Exception {
        for (AcademicOffert obj : this.academicOfferts) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        throw new Exception("");
    }

    public List<AcademicOffert> filterAcademicOfferts(int... ids) {
        List<AcademicOffert> academicOfferts = new ArrayList<AcademicOffert>();
        for (AcademicOffert obj : this.academicOfferts) {
            for (int id : ids) {
                if (obj.getId() != 0 && obj.getId() == id) {
                    academicOfferts.add(obj);
                }
            }
        }
        return academicOfferts;
    }

    public Student getStudent(int id) throws Exception {
        for (Student obj : this.students) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        throw new Exception("");
    }

    public List<Student> filterStudents(int... ids) {
        List<Student> students = new ArrayList<Student>();
        for (Student obj : this.students) {
            for (int id : ids) {
                if (obj.getId() != 0 && obj.getId() == id) {
                    students.add(obj);
                }
            }
        }
        return students;
    }

    public Applicant getApplicant(int id) throws Exception {
        for (Applicant obj : this.applicants) {
            if (obj.getId() == id) {
                return obj;
            }
        }
        throw new Exception("");
    }

    public List<Applicant> filterApplicants(int... ids) {
        List<Applicant> applicants = new ArrayList<Applicant>();
        for (Applicant obj : this.applicants) {
            for (int id : ids) {
                if (obj.getId() != 0 && obj.getId() == id) {
                    applicants.add(obj);
                }
            }
        }
        return applicants;
    }
}
