package eg.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import eg.application.view.MapController;
import gov.esprit.domain.Station;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MapApp extends Application implements MapComponentInitializedListener {

	GoogleMapView mapView;
	GoogleMap map;
	public List<Station> stationList = new ArrayList<Station>();

	@Override
	public void start(Stage stage) throws Exception {
		mapView = new GoogleMapView();
	    mapView.addMapInializedListener(this);

	    Scene scene = new Scene(mapView);
	    stage.setTitle("JavaFX and Google Maps");
	    stage.setScene(scene);
	    stage.show();
	}

	@Override
	public void mapInitialized() {
		
		MapOptions mapOptions = new MapOptions();
		mapOptions.center(new LatLong(36.7965054, 10.1827451)).overviewMapControl(false)
				.panControl(false).rotateControl(false).scaleControl(false).streetViewControl(false).zoomControl(false)
				.zoom(12);

		map = mapView.createMap(mapOptions);
		

		for(Station station : stationList ){
		MarkerOptions markerOptions = new MarkerOptions();

		markerOptions.position(new LatLong(station.getLat(), station.getLon())).visible(Boolean.TRUE).title("My Marker");

		Marker marker = new Marker(markerOptions);

		map.addMarker(marker);
		}
		
	}
	
	public static void main(String[] args) {
    
        launch(args); 
    }
	
	@Override
    public void stop() throws Exception {

      if (MapController.getScriptProcess() != null) {
        MapController.getScriptProcess().destroy();
      }
      super.stop();
    }
}
    
