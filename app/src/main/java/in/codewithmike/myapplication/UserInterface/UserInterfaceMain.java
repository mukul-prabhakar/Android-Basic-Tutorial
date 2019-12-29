package in.codewithmike.myapplication.UserInterface;

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

public class UserInterfaceMain extends AppCompatActivity implements View.OnClickListener {

    private TextView tab_GreetingApp, tab_SelfGreeting, tab_ProjectRubric;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface_main);

        initToolbar(); // instantiating toolbar

        initComponents(); // instantiating components

        tab_GreetingApp.setOnClickListener(UserInterfaceMain.this);
        tab_SelfGreeting.setOnClickListener(UserInterfaceMain.this);
        tab_ProjectRubric.setOnClickListener(UserInterfaceMain.this);

    }

    private void initToolbar() {
        ImageView backArrowButton = findViewById(R.id.backArrowButton);
        TextView headerTextView = findViewById(R.id.headerTextView);
        headerTextView.setText("Android Basic : User Interface");
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Tools.setSystemBarColorInt(this, Color.parseColor("#FFFFFF"));
    }

    private void initComponents() {
        tab_GreetingApp = findViewById(R.id.tab_GreetingApp);
        tab_SelfGreeting = findViewById(R.id.tab_SelfGreeting);
        tab_ProjectRubric = findViewById(R.id.tab_ProjectRubric);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_GreetingApp:
                startActivity(new Intent(UserInterfaceMain.this, BirthdayGreetingApp.class));
                break;
            case R.id.tab_SelfGreeting:
                startActivity(new Intent(UserInterfaceMain.this, SelfGreetingCard.class));
                break;
            case R.id.tab_ProjectRubric:
                startActivity(new Intent(UserInterfaceMain.this, ProjectRubric.class));
                break;
            default:
                Toast.makeText(this, "No Class to show", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
