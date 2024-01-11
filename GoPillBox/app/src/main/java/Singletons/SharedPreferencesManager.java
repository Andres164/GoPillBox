/*
package Singletons;
import android.content.Context;
import android.content.SharedPreferences;

import Models.UserMedicationView;

public class SharedPreferencesManager {

    private static final String PREF_NAME = "MyPrefs";
    private static final String MEDICATION_LIST_KEY = "medicationList";

    private static SharedPreferencesManager instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private SharedPreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static synchronized SharedPreferencesManager getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPreferencesManager(context);
        }
        return instance;
    }

    public void saveMedicationList(UserMedicationView[] medicationList) {
        String medicationListJson = Gson.toJson(medicationList);
        editor.putString(MEDICATION_LIST_KEY, medicationListJson);
        editor.apply();
    }

    public UserMedicationView[] getMedicationList() {
        String medicationListJson = sharedPreferences.getString(MEDICATION_LIST_KEY, "");
        return Gson.fromJson(medicationListJson, UserMedicationView[].class);
    }
}

*/