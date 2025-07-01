@Entity
public class EarthquakeEvent {
    @Id
    private String id;
    private String location;
    private double magnitude;
    private Instant timestamp;
    private double latitude;
    private double longitude;
}
