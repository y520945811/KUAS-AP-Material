package silent.kuasapmaterial.models;

import android.support.annotation.NonNull;

import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.answers.CustomEvent;

public class BusModel implements Comparable<BusModel> {

	public boolean isReserve;
	public String EndEnrollDateTime;
	public String runDateTime;
	public String endStation;
	public String limitCount;
	public String reserveCount;
	public String Time;
	public String busId;
	public String cancelKey;

	@Override
	public boolean equals(Object o) {
		try {
			return o instanceof BusModel &&
					EndEnrollDateTime.equals(((BusModel) o).EndEnrollDateTime) &&
					endStation.equals(((BusModel) o).endStation) &&
					runDateTime.equals(((BusModel) o).runDateTime) &&
					cancelKey.equals(((BusModel) o).cancelKey);
		} catch (Exception e) {
			Answers.getInstance().logCustom(
					new CustomEvent("Gson").putCustomAttribute("Type", "Bus Equals")
							.putCustomAttribute("Exception", e.getMessage()));
			return false;
		}
	}

	@Override
	public int compareTo(@NonNull BusModel other) {
		return Math.abs(EndEnrollDateTime.compareTo(other.EndEnrollDateTime)) +
				Math.abs(endStation.compareTo(other.endStation)) +
				Math.abs(runDateTime.compareTo(other.runDateTime)) +
				Math.abs(cancelKey.compareTo(other.cancelKey));
	}
}
