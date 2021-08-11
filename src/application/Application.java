package application;

public class Application {

  public static void main(String[] args) throws InterruptedException {

    var trafficLightColor = TrafficLightColorEnum.RED;

    while (true) {
      System.out.println("My traffic light color is: " + trafficLightColor.name());
      Thread.sleep(trafficLightColor.getDurationMillis());
      trafficLightColor = trafficLightColor.changeColor();
    }

  }

}
