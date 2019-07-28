import java.util.Scanner;

public class Blood_Distribution {
   // Hello there
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int oNegativeUnits = in.nextInt();
        int oPositiveUnits = in.nextInt();
        int aNegativeUnits = in.nextInt();
        int aPositiveUnits = in.nextInt();
        int bNegativeUnits = in.nextInt();
        int bPositiveUnits = in.nextInt();
        int abNegativeUnits = in.nextInt();
        int abPositiveUnits = in.nextInt();

        int oNegativePatients = in.nextInt();
        int oPositivePatients = in.nextInt();
        int aNegativePatients = in.nextInt();
        int aPositivePatients = in.nextInt();
        int bNegativePatients = in.nextInt();
        int bPositivePatients = in.nextInt();
        int abNegativePatients = in.nextInt();
        int abPositivePatients = in.nextInt();

        int satisfied = 0;

        if (oNegativePatients > oNegativeUnits) {
            satisfied += oNegativeUnits;
            oNegativeUnits = 0;
        }
        else {
            satisfied += oNegativePatients;
            oNegativeUnits -= oNegativePatients;
        }
        if (oPositivePatients > oPositiveUnits) { // all units assigned to a patient
            satisfied += oPositiveUnits;
            oPositivePatients -= oPositiveUnits;
            oPositiveUnits = 0;
        }
        else { // all patients assigned to a unit
            satisfied += oPositivePatients;
            oPositiveUnits -= oPositivePatients;
            oPositivePatients = 0;
        }
        if (oPositivePatients > oNegativeUnits) {
            satisfied += oNegativeUnits;
            oPositivePatients -= oNegativeUnits;
            oNegativeUnits = 0;
        }
        else {
            satisfied += oPositivePatients;
            oNegativeUnits -= oPositivePatients; // giving o- blood to o- patients
            oPositivePatients = 0;
        }
        if (aNegativePatients > aNegativeUnits) {
            satisfied += aNegativeUnits;
            aNegativePatients -= aNegativeUnits;
            aNegativeUnits = 0;
        }
        else {
            satisfied += aNegativePatients;
            aNegativeUnits -= aNegativePatients;
            aNegativePatients = 0;
        }
        if (aNegativePatients > oNegativeUnits) {
            satisfied += oNegativeUnits;
            aNegativePatients -= oNegativeUnits;
            oNegativeUnits = 0;
        }
        else {
            satisfied += aNegativePatients;
            oNegativeUnits -= aNegativePatients;
            aNegativePatients = 0;
        }
        if (aPositivePatients > aPositiveUnits) {
            satisfied += aPositiveUnits;
            aPositivePatients -= aPositiveUnits;
            aPositiveUnits = 0;
        }
        else {
            satisfied += aPositivePatients;
            aPositiveUnits -= aPositivePatients;
            aPositivePatients = 0;
        }
        if (aPositivePatients > aNegativeUnits) {
            satisfied += aNegativeUnits;
            aPositivePatients -= aNegativeUnits;
            aNegativeUnits = 0;
        }
        else {
            satisfied += aPositivePatients;
            aNegativeUnits -= aPositivePatients;
            aPositivePatients = 0;
        }
        if (aPositivePatients > oPositiveUnits) {
            satisfied += oPositiveUnits;
            aPositivePatients -= oPositiveUnits;
            oPositiveUnits = 0;
        }
        else {
            satisfied += aPositivePatients;
            oPositiveUnits -= aPositivePatients;
            aPositivePatients = 0;
        }
        if (aPositivePatients > oNegativeUnits) {
            satisfied += oNegativeUnits;
            aPositivePatients -= oNegativeUnits;
            oNegativeUnits = 0;
        }
        else {
            satisfied += aPositivePatients;
            oNegativeUnits -= aPositivePatients;
            aPositivePatients = 0;
        }
        if (bNegativePatients > bNegativeUnits) {
            satisfied += bNegativeUnits;
            bNegativePatients -= bNegativeUnits;
            bNegativeUnits = 0;
        }
        else {
            satisfied += bNegativePatients;
            bNegativeUnits -= bNegativePatients;
            bNegativePatients = 0;
        }
        if (bNegativePatients > oNegativeUnits) {
            satisfied += oNegativeUnits;
            bNegativePatients -= oNegativeUnits;
            oNegativeUnits = 0;
        }
        else {
            satisfied += bNegativePatients;
            oNegativeUnits -= bNegativePatients;
            bNegativePatients = 0;
        }
        if (bPositivePatients > bPositiveUnits) {
            satisfied += bPositiveUnits;
            bPositivePatients -= bPositiveUnits;
            bPositiveUnits = 0;
        }
        else {
            satisfied += bPositivePatients;
            bPositiveUnits -= bPositivePatients;
            bPositivePatients = 0;
        }
        if (bPositivePatients > bNegativeUnits) {
            satisfied += bNegativeUnits;
            bPositivePatients -= bNegativeUnits;
            bNegativeUnits = 0;
        }
        else {
            satisfied += bPositivePatients;
            bNegativeUnits -= bPositivePatients;
            bPositivePatients = 0;
        }
        if (bPositivePatients > oPositiveUnits) {
            satisfied += oPositiveUnits;
            bPositivePatients -= oPositiveUnits;
            oPositiveUnits = 0;
        }
        else {
            satisfied += bPositivePatients;
            oPositiveUnits -= bPositivePatients;
            bPositivePatients = 0;
        }
        if (bPositivePatients > oNegativeUnits) {
            satisfied += oNegativeUnits;
            bPositivePatients -= oNegativeUnits;
            oNegativeUnits = 0;
        }
        else {
            satisfied += bPositivePatients;
            oNegativeUnits -= bPositivePatients;
            bPositivePatients = 0;
        }
        if (abNegativePatients > abNegativeUnits) {
            satisfied += abNegativeUnits;
            abNegativePatients -= abNegativeUnits;
            abNegativeUnits = 0;
        }
        else {
            satisfied += abNegativePatients;
            abNegativeUnits -= abNegativePatients;
            abNegativePatients = 0;
        }
        if (abNegativePatients > bNegativeUnits) {
            satisfied += bNegativeUnits;
            abNegativePatients -= bNegativeUnits;
            bNegativeUnits = 0;
        }
        else {
            satisfied += abNegativePatients;
            bNegativeUnits -= abNegativePatients;
            abNegativePatients = 0;
        }
        if (abNegativePatients > aNegativeUnits) {
            satisfied += aNegativeUnits;
            abNegativePatients -= aNegativeUnits;
            aNegativeUnits = 0;
        }
        else {
            satisfied += abNegativePatients;
            aNegativeUnits -= abNegativePatients;
            abNegativePatients = 0;
        }
        if (abNegativePatients > oNegativeUnits) {
            satisfied += oNegativeUnits;
            abNegativePatients -= oNegativeUnits;
            oNegativeUnits = 0;
        }
        else {
            satisfied += abNegativePatients;
            oNegativeUnits -= abNegativePatients;
            abNegativePatients = 0;
        }
        if (abPositivePatients > abPositiveUnits) {
            satisfied += abPositiveUnits;
            abPositivePatients -= abPositiveUnits;
            abPositiveUnits = 0;
        }
        else {
            satisfied += abPositivePatients;
            abPositiveUnits -= abPositivePatients;
            abPositivePatients = 0;
        }
        if (abPositivePatients > abNegativeUnits) {
            satisfied += abNegativeUnits;
            abPositivePatients -= abNegativeUnits;
            abNegativeUnits = 0;
        }
        else {
            satisfied += abPositivePatients;
            abNegativeUnits -= abPositivePatients;
            abPositivePatients = 0;
        }
        if (abPositivePatients > bPositiveUnits) {
            satisfied += bPositiveUnits;
            abPositivePatients -= bPositiveUnits;
            bPositiveUnits = 0;
        }
        else {
            satisfied += abPositivePatients;
            bPositiveUnits -= abPositivePatients;
            abPositivePatients = 0;
        }
        if (abPositivePatients > bNegativeUnits) {
            satisfied += bNegativeUnits;
            abPositivePatients -= bNegativeUnits;
            bNegativeUnits = 0;
        }
        else {
            satisfied += abPositivePatients;
            bNegativeUnits -= abPositivePatients;
            abPositivePatients = 0;
        }
        if (abPositivePatients > aPositiveUnits) {
            satisfied += aPositiveUnits;
            abPositivePatients -= aPositiveUnits;
            aPositiveUnits = 0;
        }
        else {
            satisfied += abPositivePatients;
            aPositiveUnits -= abPositivePatients;
            abPositivePatients = 0;
        }
        if (abPositivePatients > aNegativeUnits) {
            satisfied += aNegativeUnits;
            abPositivePatients -= aNegativeUnits;
            aNegativeUnits = 0;
        }
        else {
            satisfied += abPositivePatients;
            aNegativeUnits -= abPositivePatients;
            abPositivePatients = 0;
        }
        if (abPositivePatients > oPositiveUnits) {
            satisfied += oPositiveUnits;
            abPositivePatients -= oPositiveUnits;
            oPositiveUnits = 0;
        }
        else {
            satisfied += abPositivePatients;
            oPositiveUnits -= abPositivePatients;
            abPositivePatients = 0;
        }
        if (abPositivePatients > oNegativeUnits) {
            satisfied += oNegativeUnits;
            abPositivePatients -= oNegativeUnits;
            oNegativeUnits = 0;
        }
        else {
            satisfied += abPositivePatients;
            oNegativeUnits -= abPositivePatients;
            abPositivePatients = 0;
        }
        System.out.println(satisfied);
    }
}
