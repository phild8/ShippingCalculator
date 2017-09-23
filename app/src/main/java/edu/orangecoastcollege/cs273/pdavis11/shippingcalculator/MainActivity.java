package edu.orangecoastcollege.cs273.pdavis11.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // Currency formatter
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    // Connections from the controller to the View
    private EditText mOuncesTotal;
    private TextView mBaseTextView;
    private TextView mAddedTextView;
    private TextView mTotalTextView;

    // Connection from the controller to the Model
    private ShipItem mShipItem = new ShipItem();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connect all the widgets with the view.
        mOuncesTotal = (EditText) findViewById(R.id.ouncesEditTExt);
        mBaseTextView = (TextView) findViewById(R.id.baseTextView);
        mAddedTextView = (TextView) findViewById(R.id.amountAddedTextView);
        mTotalTextView = (TextView) findViewById(R.id.totalCostTextView);

        mOuncesTotal.addTextChangedListener(weightWatcher);
    }

    private void updateViews() {
        mBaseTextView.setText(currency.format(mShipItem.getmBaseCost()));
        mAddedTextView.setText(currency.format(mShipItem.getmAddedCost()));
        mTotalTextView.setText(currency.format(mShipItem.getmTotalCost()));
    }

    private final TextWatcher weightWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence text, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence text, int i, int i1, int i2) {
            try {
                int totalOunces = Integer.parseInt(text.toString());

                mShipItem.setmOunces(totalOunces);
            } catch (NumberFormatException e){
                mShipItem.setmOunces(0);
            }
            updateViews();
        }

        @Override
        public void afterTextChanged(Editable editable) {}
    };

}
