package week4;

public class BayviewGlenPools {
    public static void main(String[] args) {
        final int length = 20;
        final int width = 8;
        final int shallowLength = 5;
        final int transition = 7;
        final int shallowHeight = 3;
        final int deepHeight = 8;

        final int linerCost = 2;

        double volume = getVolume(length, width, shallowHeight, shallowLength, transition, deepHeight);
        double surfaceArea = getSurfaceArea(length, width, shallowHeight, shallowLength, transition, deepHeight);
        double ninetyPercentFull = volume * 0.9;
        double linerPrice = surfaceArea * linerCost;

        System.out.println("The volume of the full pool is " + volume + " meters cubed");
        System.out.println("The volume of the pool at 90% full is " + ninetyPercentFull + " meters cubed");
        System.out.println("The surface area is " + surfaceArea + " meters squared");
        System.out.println("The price of the liner is $" + (double) Math.round(linerPrice * 100) / 100);



    }

    private static double getSurfaceArea(int length, int width, int shallowHeight, int shallowLength, int transition,
            int deepHeight) {
        double transitionLength = Math.sqrt((transition * transition) - ((deepHeight - shallowHeight) * (deepHeight - shallowHeight)));
        double deepLength = length - shallowLength - transitionLength;
        double areaBack = width * deepHeight;
        double areaFront = width * shallowHeight;
        double shallowBottom = width * shallowLength;
        double deepBottom = width * deepLength;
        double deepSides = deepLength * deepHeight * 2;
        double shallowSides = shallowLength * shallowHeight * 2;
        double aboveTransitionSides = transitionLength * shallowHeight * 2;
        double transitionSides = (transitionLength * (deepHeight - shallowHeight));
        double transitionBottom = transition * width;

        return areaBack + areaFront + shallowBottom + deepBottom + deepSides + shallowSides + aboveTransitionSides + transitionSides + transitionBottom;


    }

    private static double getVolume(int length, int width, int shallowHeight, int shallowLength, int transition,
            int deepHeight) {

        double transitionLength = Math.sqrt((transition * transition) - ((deepHeight - shallowHeight) * (deepHeight - shallowHeight)));
        double volumeDeep = deepHeight * (length - shallowLength - transitionLength) * width;
        double volumeTransition = ((transitionLength * (deepHeight - shallowHeight)) / 2) * width;
        double aboveVolumeTransition = transitionLength * shallowHeight * width;
        double volumeShallow = shallowLength * shallowHeight * width;

        return volumeDeep + volumeTransition + aboveVolumeTransition + volumeShallow;
    }
    
}
