@Service
public class EarthquakeService {

    @Autowired
    private EarthquakeEventRepository repository;

    public List<EarthquakeEvent> getAllRecent() {
        return repository.findAll();
    }

    public void save(EarthquakeEvent event) {
        repository.save(event);
    }
}
