package in.codewithmike.myapplication.UserInterface;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import in.codewithmike.myapplication.R;
import in.codewithmike.myapplication.utils.Tools;

public class BirthdayGreetingApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_greeting_app);

        Tools.setSystemBarColorInt(this, Color.parseColor("#000000"));
    }
}
