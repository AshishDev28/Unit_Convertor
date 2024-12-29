package com.example.Task_unit_con;


import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/converter")
    @CrossOrigin(origins = "*")
    public class Controller {
        @GetMapping("/length")
        public double convertLength(
                @RequestParam double value,
                @RequestParam String fromUnit,
                @RequestParam String toUnit) {

            if (fromUnit.equalsIgnoreCase("meters") && toUnit.equalsIgnoreCase("kilometers")) {
                return value / 1000;
            } else if (fromUnit.equalsIgnoreCase("kilometers") && toUnit.equalsIgnoreCase("meters")) {
                return value * 1000;
            } else if (fromUnit.equalsIgnoreCase("feet") && toUnit.equalsIgnoreCase("meters")) {
                return value * 0.3048;
            } else if (fromUnit.equalsIgnoreCase("meters") && toUnit.equalsIgnoreCase("feet")) {
                return value / 0.3048;
            } else {
                throw new IllegalArgumentException("Invalid units");
            }
        }

        @GetMapping("/weight")
        public double convertWeight(
                @RequestParam double value,
                @RequestParam String fromUnit,
                @RequestParam String toUnit) {

            if (fromUnit.equalsIgnoreCase("grams") && toUnit.equalsIgnoreCase("kilograms")) {
                return value / 1000;
            } else if (fromUnit.equalsIgnoreCase("kilograms") && toUnit.equalsIgnoreCase("grams")) {
                return value * 1000;
            } else if (fromUnit.equalsIgnoreCase("pounds") && toUnit.equalsIgnoreCase("kilograms")) {
                return value * 0.453592;
            } else if (fromUnit.equalsIgnoreCase("kilograms") && toUnit.equalsIgnoreCase("pounds")) {
                return value / 0.453592;
            } else {
                throw new IllegalArgumentException("Invalid units");
            }
        }

        @GetMapping("/temperature")
        public double convertTemperature(
                @RequestParam double value,
                @RequestParam String fromUnit,
                @RequestParam String toUnit) {

            if (fromUnit.equalsIgnoreCase("celsius") && toUnit.equalsIgnoreCase("fahrenheit")) {
                return (value * 9 / 5) + 32;
            } else if (fromUnit.equalsIgnoreCase("fahrenheit") && toUnit.equalsIgnoreCase("celsius")) {
                return (value - 32) * 5 / 9;
            } else {
                throw new IllegalArgumentException("Invalid units");
            }
        }
    }


