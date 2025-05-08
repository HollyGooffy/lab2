import java.util.LinkedHashMap;
import java.util.Map;

public class City {
	private final String name;
	private final Map<City, Integer> routes;

	public City(String name) {
		this.name = name;
		this.routes = new LinkedHashMap<>();
	}

	public void addRoute(City neighbor, int cost) {
		routes.put(neighbor, cost);
	}

	public String getDescription() {
		StringBuilder sb = new StringBuilder(name);
		for (Map.Entry<City, Integer> entry : routes.entrySet()) {
			sb.append("\n").append(entry.getKey().getName()).append(":").append(entry.getValue());
		}
		return sb.toString();
	}

	public String getName() {
		return name;
	}
}