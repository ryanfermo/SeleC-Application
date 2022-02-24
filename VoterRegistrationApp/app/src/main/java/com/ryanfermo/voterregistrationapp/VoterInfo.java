package com.ryanfermo.voterregistrationapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class VoterInfo {
    public static String makeHTTPRequest(URL url) throws IOException {
        HttpURLConnection connection= (HttpURLConnection) url.openConnection();
        InputStream inputStream=connection.getInputStream();
        Scanner scanner=new Scanner(inputStream);
        scanner.useDelimiter("\\A");

        try {
            boolean hasInput = scanner.hasNext();
            if (hasInput)
                return scanner.next();
            else return null;
        }
        finally {
            connection.disconnect();
        }
    }
}
