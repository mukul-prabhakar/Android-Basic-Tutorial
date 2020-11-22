package in.codewithmike.myapplication.Networking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import in.codewithmike.myapplication.R;
import in.codewithmike.myapplication.databinding.ActivityNetworkingMainBinding;

public class NetworkingMain extends AppCompatActivity {

    private ActivityNetworkingMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNetworkingMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.earthquakeAppTab.setOnClickListener(v ->
                startActivity(new Intent(getApplicationContext(), EarthquakeActivity.class)));

    }
}