package algo;

import java.util.List;

public class LandOrRiver {

    public static void main(String[] args) {
        /*
        * 0 – represents 1 acre of land
        * 1 – represents 1 km of river
        * */
        int[] parcels = {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0};

        int numbersOfLandParcels = findNumberOfParcel(ParcelType.LAND, parcels);
        System.out.println(numbersOfLandParcels);

        int numbersOfRiverParcels = findNumberOfParcel(ParcelType.RIVER, parcels);
        System.out.println(numbersOfRiverParcels);

        int lengthOfLargestLandParcel = findLengthOfLargestParcel(ParcelType.LAND, parcels);
        System.out.println(lengthOfLargestLandParcel);

        int lengthOfLargestRiverParcel = findLengthOfLargestParcel(ParcelType.RIVER, parcels);
        System.out.println(lengthOfLargestRiverParcel);
    }

    private static int findNumberOfParcel(ParcelType parcelType, int[] parcels) {
        int numberOfParcel = 0;
        boolean isElegibleToCount = true;
        for (int i = 0; i<parcels.length; i++) {
            if(parcelType.getParcelValue() == parcels[i] && isElegibleToCount) {
                isElegibleToCount = false;
                numberOfParcel = numberOfParcel + 1;
            } else if(parcelType.getParcelValue() != parcels[i]){
                isElegibleToCount = true;
            }
        }

        return numberOfParcel;
    }

    private static int findLengthOfLargestParcel(ParcelType parcelType, int[] parcels) {
        int lengthOfLargestParcel = 0, lengthOfParcel = 0;

        for (int i = 0; i<parcels.length; i++) {
            if(parcelType.getParcelValue() == parcels[i]) {
                lengthOfParcel = lengthOfParcel + 1;
            } else {
                if(lengthOfLargestParcel < lengthOfParcel) lengthOfLargestParcel = lengthOfParcel;
                lengthOfParcel = 0;
            }
        }

        if(lengthOfLargestParcel < lengthOfParcel) lengthOfLargestParcel = lengthOfParcel;

        return lengthOfLargestParcel;
    }
}

enum ParcelType {
    LAND(1), RIVER(0);

    private final int parcelValue;

    ParcelType(int value) {
        this.parcelValue = value;
    }

    public int getParcelValue() {
        return parcelValue;
    }
}
