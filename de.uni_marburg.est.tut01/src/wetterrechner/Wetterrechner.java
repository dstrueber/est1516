package wetterrechner;
public class Wetterrechner {
	public static void main(String[] args) {
		int[] day = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
		int[] temperatur = { 17, 15, 10, 16, 14, 16, 8, 7, 11, 4, 13, 15, 19,
				21 };

		// Durchschnittstemperatur
		System.out.println("Durchschnittstemperatur");
		int durchschnitt = 0;
		for (int i = 0; i < temperatur.length; i++) {
			durchschnitt = temperatur[i];
		}
		durchschnitt = durchschnitt / temperatur.length;
		System.out.println("\tDie Durchschnittstemperatur betraegt: "
				+ durchschnitt);

		// Maximale und minimale Temperatur
		System.out.println("Maximale und minimale Temperatur");
		int max = 0;
		int min = 0;
		for (int i = 0; i < temperatur.length; i++) {
			if (max < temperatur[i]) {
				max = temperatur[i];
			}
			if (min > temperatur[i]) {
				min = temperatur[i];
			}
		}
		System.out.println("\tMaximale Temperatur: " + max);
		System.out.println("\tMinimale Temperatur: " + min);

		// Größter Temperaturumschwung
		System.out
				.println("Aufeinanderfolgende Tage mit größter Temperaturveränderung");
		int maxTempDiff = 0;
		int ergebnisTag = 0;
		for (int i = 0; i < temperatur.length; i++) {
			int newMaxDiff = 0;
			if ((i + 1) < temperatur.length) {
				if (temperatur[i] >= temperatur[i + 1]) {
					newMaxDiff = temperatur[i] - temperatur[i + 1];
				}
				if (maxTempDiff < newMaxDiff) {
					maxTempDiff = newMaxDiff;
					ergebnisTag = i;
				}
			}
		}
		System.out.println("\tMaximale Temperaturveränderung: " + maxTempDiff
				+ " von Tag " + (ergebnisTag + 1) + " zu Tag "
				+ (ergebnisTag + 2));

		System.out.println();
		System.out.println("Tabellarische Ausgabe der Temperaturen");
		System.out.print("Tag: \t\t");
		for (int i = 0; i < day.length; i++) {
			System.out.print(day[i] + "\t");
		}
		System.out.println();
		System.out.print("Temperatur \t");
		for (int j = 0; j < temperatur.length; j++) {
			System.out.print(temperatur[j] + "\t");
		}
	}
}