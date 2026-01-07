package com.bisforboosted.witheredfoxyjumpscare.util;

import com.bisforboosted.witheredfoxyjumpscare.Constants;
import net.minecraft.resources.Identifier;

public class Utils {
    public static Identifier getIdentifierByTick(int tick) {
        switch (tick) {
            case 0:
                return Constants.WITHERED_FOXY_JUMPSCARE_1;
            case 1:
                return Constants.WITHERED_FOXY_JUMPSCARE_2;
            case 2:
                return Constants.WITHERED_FOXY_JUMPSCARE_3;
            case 3:
                return Constants.WITHERED_FOXY_JUMPSCARE_4;
            case 4:
                return Constants.WITHERED_FOXY_JUMPSCARE_5;
            case 5:
                return Constants.WITHERED_FOXY_JUMPSCARE_6;
            case 6:
                return Constants.WITHERED_FOXY_JUMPSCARE_7;
            case 7:
                return Constants.WITHERED_FOXY_JUMPSCARE_8;
            case 8:
                return Constants.WITHERED_FOXY_JUMPSCARE_9;
            case 9:
                return Constants.WITHERED_FOXY_JUMPSCARE_10;
            case 10:
                return Constants.WITHERED_FOXY_JUMPSCARE_11;
            case 11:
                return Constants.WITHERED_FOXY_JUMPSCARE_12;
            case 12:
                return Constants.WITHERED_FOXY_JUMPSCARE_13;
            case 13:
                return Constants.WITHERED_FOXY_JUMPSCARE_14;
            default:
                return Constants.WITHERED_FOXY_JUMPSCARE_1;
        }
    }
}
