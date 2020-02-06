package edu.miracosta.cs134.costalattacars;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import edu.miracosta.cs134.costalattacars.model.CarLoan;

public class LoanSummaryActivity extends AppCompatActivity {

    private CarLoan carLoan;
    private NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
    private TextView monthlyPaymentTextView, carPriceTextView, salesTaxRateTextView, taxAmountTextView,
    downPaymentTextView, totalCostTextView, borrowedAmountTextView, interestAmountTextView, loanTermTextView;
    private Button returnButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_summary);

        //Extract the data from the intent
        double carPrice, downPayment;
        int loanTerm;
        Intent intent = getIntent();

        carPrice = intent.getDoubleExtra("CarPrice", 0.0);
        downPayment = intent.getDoubleExtra("DownPayment", 0.0);
        loanTerm = intent.getIntExtra("LoanTerm", 5);

        //Send data to the Model(carLoan)
        carLoan = new CarLoan();
        carLoan.setPrice(carPrice);
        carLoan.setDownPayment(downPayment);
        carLoan.setLoanTerm(loanTerm);

        // Populate the text views with the data from the carLoan model
        monthlyPaymentTextView = findViewById(R.id.monthlyPaymentTextView);
        carPriceTextView = findViewById(R.id.carPriceEditText);
        salesTaxRateTextView = findViewById(R.id.salesTaxRateTextView);
        taxAmountTextView = findViewById(R.id.taxAmountTextView);
        downPaymentTextView = findViewById(R.id.downPaymentTextView);
        totalCostTextView = findViewById(R.id.totalCostTextView);
        borrowedAmountTextView = findViewById(R.id.borrowedAmountTextView);
        interestAmountTextView = findViewById(R.id.interestAmountTextView);
        loanTermTextView = findViewById(R.id.loanTermTextView);
        returnButton = findViewById(R.id.returnButton);
    }

    public void returnToMain(View v)
    {
        // Done with LoanSummaryActivity, so "finish" it
        finish();
    }
}
