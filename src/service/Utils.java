package service;

import dto.FareDto;

import java.util.List;

public class Utils {

    public static String makeFile (List<FareDto> list, int blankLines, String[] headerLines) {
        StringBuilder sb = new StringBuilder();
        sb.append(makeHeader(headerLines));
        for (int i = 1; i <= blankLines; i++) {
            sb.append("\n");
        }
        int length = list.size();
        for (int i = 0; i < length; i++) {
            sb.append(getLine(list.get(i)));
            if (i < length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private static String getLine(FareDto fareDto) {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(fareDto.getDriverId()).append("\"").append(",").append(fareDto.getName()).append(",")
                .append(fareDto.getCostFare());
        return sb.toString();
    }

    private static String makeHeader(String... headerLines) {
        StringBuilder sb = new StringBuilder();
        int length = headerLines.length;
        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                sb.append("\"").append(headerLines[i]).append("\"");
            } else {
                sb.append("\"").append(headerLines[i]).append("\"").append(",");
            }
        }
        return sb.toString();
    }
}
