package in.codewithmike.myapplication.UserInput;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.codewithmike.myapplication.R;
import in.codewithmike.myapplication.utils.Tools;

public class UserInputMain extends AppCompatActivity implements View.OnClickListener {

    private TextView tab_JustJavaApp, tab_CourtCounterApp, tab_ProjectRubric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input_main);

        initToolbar(); // instantiating toolbar

        initComponents(); // instantiating components

        tab_JustJavaApp.setOnClickListener(UserInputMain.this);
        tab_CourtCounterApp.setOnClickListener(UserInputMain.this);
        //tab_ProjectRubric.setOnClickListener(UserInputMain.this);
    }

    private void initToolbar() {
        ImageView backArrowButton = findViewById(R.id.backArrowButton);
        TextView headerTextView = findViewById(R.id.headerTextView);
        headerTextView.setText("Android Basic : User Input");
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Tools.setSystemBarColorInt(this, Color.parseColor("#FFFFFF"));
    }

    private void initComponents() {
        tab_JustJavaApp = findViewById(R.id.tab_JustJavaApp);
        tab_CourtCounterApp = findViewById(R.id.tab_CourtCounterApp);
        //tab_ProjectRubric = findViewById(R.id.tab_ProjectRubric);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_JustJavaApp:
                startActivity(new Intent(UserInputMain.this, JustJavaApp.class));
                break;
            case R.id.tab_CourtCounterApp:
                startActivity(new Intent(UserInputMain.this, CourtCounter.class));
                break;
            /*case R.id.tab_ProjectRubric:
                startActivity(new Intent(UserInputMain.this, ProjectRubric.class));
                break;*/
            default:
                Toast.makeText(this, "No Class to show", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
