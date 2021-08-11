package application;

import java.util.Arrays;

public enum TrafficLightColorEnum {

  RED(3000L, "GREEN") {
    @Override
    public TrafficLightColorEnum changeColor() {
      return TrafficLightColorEnum.findByName(this.getNextNodeName());
    }
  },
  GREEN(5000L, "YELLOW") {
    @Override
    public TrafficLightColorEnum changeColor() {
      return TrafficLightColorEnum.findByName(this.getNextNodeName());
    }
  },
  YELLOW(1000L, "RED") {
    @Override
    public TrafficLightColorEnum changeColor() {
      return TrafficLightColorEnum.findByName(this.getNextNodeName());
    }
  };

  private final long durationMillis;
  private final String nextNodeName;

  TrafficLightColorEnum(long durationMillis, String nextNodeName) {
    this.durationMillis = durationMillis;
    this.nextNodeName = nextNodeName;
  }

  public static TrafficLightColorEnum findByName(String name) {
    return Arrays.stream(TrafficLightColorEnum.values())
        .filter(tlc -> name.equalsIgnoreCase(tlc.name()))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Not found!"));
  }

  public long getDurationMillis() {
    return durationMillis;
  }

  public String getNextNodeName() {
    return nextNodeName;
  }

  public abstract TrafficLightColorEnum changeColor();
}
