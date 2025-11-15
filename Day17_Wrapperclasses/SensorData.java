import java.util.ArrayList;

public class SensorData{
    public static void logTemperature(ArrayList<Double> storage, Double temp) {
        storage.add(temp);
    }

    public static void main(String[] args) {

        ArrayList<Double> temperatureLog = new ArrayList<>();
        double sensorReading1 = 25.7;
        Double sensorReading2 = 30.2;
        Double sensorReading3 = null;

        logTemperature(temperatureLog, sensorReading1); 
        logTemperature(temperatureLog, sensorReading2); 
        logTemperature(temperatureLog, sensorReading3); 
        System.out.println("Sensor Temperature Log: " + temperatureLog);

        for (Double temp : temperatureLog) {
            if (temp != null) {
                double primitiveTemp = temp;  
                System.out.println(primitiveTemp);
            } else {
                System.out.println("Processed Temperature: NULL value skipped");
            }
        }
    }
}

