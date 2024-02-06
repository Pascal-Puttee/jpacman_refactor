package nl.tudelft.jpacman.points;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Properties;

/**
 * The responsibility of this loader is to obtain the appropriate points calculator.
 * By default the {@link DefaultPointCalculator} is returned.
 */
public class PointCalculatorLoader {

    @SuppressWarnings("rawtypes")
    private static Class clazz = null;

    /**
     * Load a points calculator and return it.
     *
     * @return The (dynamically loaded) points calculator.
     */
    @SuppressWarnings("unchecked")
    public PointCalculator load() {
        try {
            if (clazz == null) {
                clazz = loadClassFromFile();
            }

            return (PointCalculator) clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Could not dynamically load the points calculator.", e);
        }
    }

    @SuppressWarnings("rawtypes")
    private Class loadClassFromFile() throws IOException, ClassNotFoundException {
        String strategyToLoad = getCalculatorClassName();

        if ("DefaultPointCalculator".equals(strategyToLoad)) {
            return DefaultPointCalculator.class;
        }

        URL[] urls = new URL[]{getClass().getClassLoader().getResource("scoreplugins/")};

        try (URLClassLoader classLoader = new URLClassLoader(urls, getClass().getClassLoader())) {
            return classLoader.loadClass(strategyToLoad);
        }
    }

    private String getCalculatorClassName() throws IOException {
        Properties properties = new Properties();

        properties.load(getClass().getClassLoader().getResourceAsStream("scorecalc.properties"));

        return properties.getProperty("scorecalculator.name");
    }
}
