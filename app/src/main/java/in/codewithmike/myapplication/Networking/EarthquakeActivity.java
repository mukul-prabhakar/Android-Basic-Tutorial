package in.codewithmike.myapplication.Networking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import in.codewithmike.myapplication.R;
import in.codewithmike.myapplication.databinding.ActivityEarthquakeBinding;
import in.codewithmike.myapplication.databinding.ActivityNetworkingMainBinding;

public class EarthquakeActivity extends AppCompatActivity {

    private ActivityEarthquakeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEarthquakeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake("7.2","San Francisco", "Feb 2, 1998"));
        earthquakes.add(new Earthquake("5.2","London", "Feb 2, 1998"));
        earthquakes.add(new Earthquake("6.2","Tokyo", "Feb 2, 1998"));
        earthquakes.add(new Earthquake("8.2","Mexico City", "Feb 2, 1998"));
        earthquakes.add(new Earthquake("6.2","Moscow", "Feb 2, 1998"));
        earthquakes.add(new Earthquake("5.2","Rio de Janeiro", "Feb 2, 1998"));
        earthquakes.add(new Earthquake("5.2","Paris", "Feb 2, 1998"));

        EarthquakeAdapter adapter = new EarthquakeAdapter(this, earthquakes);
        binding.earthquakeListView.setAdapter(adapter);
    }
}