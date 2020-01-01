package in.codewithmike.myapplication.UserInput;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import in.codewithmike.myapplication.R;
import in.codewithmike.myapplication.utils.Tools;

/**
 * This app displays an order form  to order coffee.
 */

public class JustJavaApp extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_java_app);

        initToolbar(); // instantiating toolbar
    }

    private void initToolbar() {
        ImageView backArrowButton = findViewById(R.id.backArrowButton);
        TextView headerTextView = findViewById(R.id.headerTextView);
        headerTextView.setText("User Input : Just Java App");
        backArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Tools.setSystemBarColorInt(this, Color.parseColor("#FFFFFF"));
    }

    /* This method is called when increment button is clicked. */
    public void increment(View view) {
        if (quantity == 100) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            //Exit this method early because there's nothing left to do
            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }

    /* This method is called when decrement button is clicked. */
    public void decrement(View view) {
        if (quantity == 1) {
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            //Exit this method early because there's nothing left to do
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }

    /* This method is called when order button is clicked. */
    public void submitOrder(View view) {
        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String orderSummaryMessage = createOrderSummary(name, price, quantity, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, "Just java order for " + orderSummaryMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        // displayMessage(orderSummaryMessage);
    }

    /*This method displays the given quantity value on the screen. */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" " + numberOfCoffees);
    }

    /*This method displays price for the given quantity value on the screen. */
    /*private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }*/

    /**
     * Calculates the price of the order.
     *
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @param addChocolate    is whether or not the user wants chocolate topping
     * @return total price
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        // Price of 1 cup of coffee
        int baseprice = 5;

        // Add $1 if the user wants whipped cream
        if (addWhippedCream) {
            baseprice = baseprice + 1;
        }

        // Add $2 if the user wants chocolate
        if (addChocolate) {
            baseprice = baseprice + 2;
        }

        // Calculate the total order price by multiplying by quantity
        return quantity * baseprice;
    }

    /**
     * Creates the summary of the order.
     *
     * @param name                    of the customer
     * @param totalPrice              is the total price of coffee ordered
     * @param quantityOfCoffeeOrdered is the quantity of one coffee
     * @param addWhippedCream         is whether or not the user wants whipped cream topping
     * @param addChocolate            is whether or not the user wants chocolate topping
     * @return order summary message
     */
    private String createOrderSummary(String name, int totalPrice, int quantityOfCoffeeOrdered, boolean addWhippedCream, boolean addChocolate) {
        return "Name: " + name +
                "\nAdd whipped cream? " + addWhippedCream +
                "\nAdd chocolate? " + addChocolate +
                "\nQuantity: " + quantityOfCoffeeOrdered +
                "\nTotal: $" + totalPrice +
                "\nThank you!";
    }
}