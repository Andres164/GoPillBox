package Models;

import java.io.Serializable;

public class UserMedicationView implements Serializable {
    public int UserId;
    public String MedicationName = null;
    public String MedicNotes = null;
    public float Dose;
    public String DoseUnitOfMesure = null;
    public float DosingFrequencyInHours = 0;
    public int TimeInTreatmentInDays = 0;

    public UserMedicationView() {}

    public UserMedicationView(
        int UserId,
        String MedicationName,
        String MedicNotes,
        float Dose,
        String DoseUnitOfMesure,
        float DosingFrequencyInHours,
        int TimeInTreatmentInDays
    ) {
        this.UserId = UserId;
        this.MedicationName = MedicationName;
        this.MedicNotes = MedicNotes;
        this.Dose = Dose;
        this.DoseUnitOfMesure = DoseUnitOfMesure;
        this.DosingFrequencyInHours = DosingFrequencyInHours;
        this.TimeInTreatmentInDays = TimeInTreatmentInDays;
    }
}
