package com.techmorphosis.qube.utils;

import java.text.DecimalFormat;

public class MathUtils {

    private static final String[] tensNames = {
            "",
            " ten",
            " twenty",
            " thirty",
            " forty",
            " fifty",
            " sixty",
            " seventy",
            " eighty",
            " ninety"
    };

    private static final String[] numNames = {
            "",
            " one",
            " two",
            " three",
            " four",
            " five",
            " six",
            " seven",
            " eight",
            " nine",
            " ten",
            " eleven",
            " twelve",
            " thirteen",
            " fourteen",
            " fifteen",
            " sixteen",
            " seventeen",
            " eighteen",
            " nineteen"
    };

    private MathUtils() {
    }

    private static String convertLessThanOneThousand(int number) {
        String soFar;

        if (number % 100 < 20) {
            soFar = numNames[number % 100];
            number /= 100;
        } else {
            soFar = numNames[number % 10];
            number /= 10;

            soFar = tensNames[number % 10] + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames[number] + " hundred" + soFar;
    }


    public static String convert(long number) {
        // 0 to 9 999 999 999
        if (number == 0) {
            return "zero";
        }

        String snumber = Long.toString(number);

        // pad with "0"
        String mask = "0000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        // XXXnnnnnnn
        int crores = Integer.parseInt(snumber.substring(0, 3));
        // nnnXXnnnnn
        int lacs = Integer.parseInt(snumber.substring(3, 5));
        // nnnnnXXnnn
        int tenThousands = Integer.parseInt(snumber.substring(5, 7));
        // nnnnnnnnnXXX
        int thousands = Integer.parseInt(snumber.substring(7, 10));

        String tradCrores;
        switch (crores) {
            case 0:
                tradCrores = "";
                break;
            case 1:
                tradCrores = convertLessThanOneThousand(crores)
                        + " crore ";
                break;
            default:
                tradCrores = convertLessThanOneThousand(crores)
                        + " crore ";
        }
        String result = tradCrores;

        String tradLacs;
        switch (lacs) {
            case 0:
                tradLacs = "";
                break;
            case 1:
                tradLacs = "one lac ";
                break;
            default:
                tradLacs = convertLessThanOneThousand(lacs)
                        + " lac ";
        }
        result = result + tradLacs;


        String tradtenThousands;
        switch (tenThousands) {
            case 0:
                tradtenThousands = "";
                break;
            case 1:
                tradtenThousands = convertLessThanOneThousand(tenThousands)
                        + " thousand ";
                break;
            default:
                tradtenThousands = convertLessThanOneThousand(tenThousands)
                        + " thousand ";
        }
        result = result + tradtenThousands;

        String tradThousand;
        tradThousand = convertLessThanOneThousand(thousands);
        result = result + tradThousand;

        // remove extra spaces!
        return result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
    }
}