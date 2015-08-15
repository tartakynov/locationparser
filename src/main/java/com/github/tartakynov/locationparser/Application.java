package com.github.tartakynov.locationparser;

import com.taykey.twitterlocationparser.DefaultLocationParser;
import com.taykey.twitterlocationparser.LocationParser;
import com.taykey.twitterlocationparser.dto.Location;
import py4j.GatewayServer;

public class Application {
    private LocationParser locationParser = new DefaultLocationParser();

    public String countryCode(String text) {
        if (text != null) {
            Location location = locationParser.parseText(text);
            if (location != null) {
                return location.getCountryCode();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Application app = new Application();
        GatewayServer server = new GatewayServer(app);
        server.start();
    }
}
