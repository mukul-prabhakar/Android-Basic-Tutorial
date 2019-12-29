package in.codewithmike.myapplication.UserInterface;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import in.codewithmike.myapplication.R;
import in.codewithmike.myapplication.utils.Tools;

public class ProjectRubric extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_rubric);

        initToolbar(); // instantiating toolbar

    }

    private void initToolbar() {
        ImageView backArrowButton = findViewById(R.id.backArrowButton);
        TextView headerTextView = findViewById(R.id.headerTextView);
        headerTextView.setText("Project Rubric");
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Tools.setSystemBarColorInt(this, Color.parseColor("#FFFFFF"));
    }
}
