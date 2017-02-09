package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PGraphics;
import processing.core.PImage;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
		
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		 
		//pg.tint(0, 0, 255);
		//pg.ellipse(x, y, 5, 5);
		pg.image(EarthquakeCityAirportMap.img, x, y, 10, 10);
	}

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		
	}
	
}
