import java.util.LinkedHashMap;
import java.util.Map;

class NewCity {
	private final String name;
	private final Map<NewCity, Integer> routes;

	public NewCity(String name) {
		this(name, new LinkedHashMap<>());
	}

	public NewCity(String name, Map<NewCity, Integer> initialRoutes) {
		this.name = name;
		this.routes = new LinkedHashMap<>(initialRoutes);
	}

	public void addRoute(NewCity neighbor, int cost) {
		routes.put(neighbor, cost);
	}

	public String getDescription() {
		StringBuilder sb = new StringBuilder(name);
		for (Map.Entry<NewCity, Integer> entry : routes.entrySet()) {
			sb.append("\n").append(entry.getKey().getName()).append(":").append(entry.getValue());
		}
		return sb.toString();
	}

	public String getName() {
		return name;
	}
}

