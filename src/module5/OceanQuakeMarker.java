package module5;

import java.util.LinkedList;
import java.util.Queue;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.AbstractMarker;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import processing.core.PApplet;
import processing.core.PGraphics;

/** Implements a visual marker for ocean earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * @author Your name here
 *
 */
public class OceanQuakeMarker extends EarthquakeMarker {
	
	UnfoldingMap map;
	boolean isOcean;
	Marker clickedPos;
	Marker cityPos;
	Queue<Marker> cities = new LinkedList<Marker>();
	Queue<Marker> clones = new LinkedList<Marker>();
	
	public OceanQuakeMarker(PointFeature quake) {
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = false;
	}
	

	/** Draw the earthquake as a square */
	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) 
	{
		pg.pushStyle();
		pg.rect(x-radius, y-radius, 2*radius, 2*radius);
		
		if(isOcean)
		{
			
			clones.offer(cities.poll());
			
			while(!cities.isEmpty())
			{
				cityPos = cities.peek();
				clones.offer(cities.poll());
				ScreenPosition sp = ((AbstractMarker) cityPos).getScreenPosition(map);
				pg.fill(0,0,0);
				pg.line(x, y, sp.x, sp.y);
				
			}
			
			cities = clones;
		}
		else
		{
			pg.noStroke();
		}
		pg.popStyle();
	}


	public void drawLine(boolean isOcean, Queue<Marker> cities, UnfoldingMap map) 
	{
		this.isOcean = isOcean;
		this.cities = cities;
		this.map = map;
	}


	public void drawLine(boolean isOcean) 
	{
		this.isOcean = isOcean;
	}
}
