package in.codewithmike.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import in.codewithmike.myapplication.UserInterface.UserInterfaceMain;
import in.codewithmike.myapplication.utils.Tools;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView tab_UserInterface, tab_UserInput, tab_MultiScreenApp, tab_Networking, tab_DataStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tools.setSystemBarColorInt(this, Color.parseColor("#FFFFFF"));

        initComponents(); // instantiating components

        tab_UserInterface.setOnClickListener(MainActivity.this);
        tab_UserInput.setOnClickListener(MainActivity.this);
        tab_MultiScreenApp.setOnClickListener(MainActivity.this);
        tab_Networking.setOnClickListener(MainActivity.this);
        tab_DataStorage.setOnClickListener(MainActivity.this);
    }

    private void initComponents() {
        tab_UserInterface = findViewById(R.id.tab_UserInterface);
        tab_UserInput = findViewById(R.id.tab_UserInput);
        tab_MultiScreenApp = findViewById(R.id.tab_MultiScreenApp);
        tab_Networking = findViewById(R.id.tab_Networking);
        tab_DataStorage = findViewById(R.id.tab_DataStorage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_UserInterface:
                startActivity(new Intent(MainActivity.this, UserInterfaceMain.class));
                break;
            case R.id.tab_UserInput:
                //startActivity(new Intent(MainActivity.this, UserInterfaceMain.class));
                break;
            case R.id.tab_MultiScreenApp:
                //startActivity(new Intent(MainActivity.this, UserInterfaceMain.class));
                break;
            case R.id.tab_Networking:
                //startActivity(new Intent(MainActivity.this, UserInterfaceMain.class));
                break;
            case R.id.tab_DataStorage:
                //startActivity(new Intent(MainActivity.this, UserInterfaceMain.class));
                break;
            default:
                Toast.makeText(this, "No Class to show", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
