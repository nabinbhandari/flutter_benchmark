package com.nabinbhandari.flutterbenchmark;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * This class represents the launcher activity.
 * <br/>
 * Created on 7/13/18 at 4:06 PM
 *
 * @author bnabin51@gmail.com
 */
public class TestActivity extends Activity {

    private static final int N = 20000;

    static {
        System.loadLibrary("benchmark");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public void onClickFlutter(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void onClickJava(View view) {
        long startTime = System.currentTimeMillis();
        long nThPrimeNumber = nThPrimeNumber(N);
        long elapsed = System.currentTimeMillis() - startTime;

        final String text = "Java - " + N + "th prime number: " + nThPrimeNumber + "\ntime: " + elapsed + " ms";
        System.err.println(text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void onClickC(View view) {
        long startTime = System.currentTimeMillis();
        long nThPrimeNumber = nativeGetNthPrimeNumber(N);
        long elapsed = System.currentTimeMillis() - startTime;

        final String text = "C - " + N + "th prime number: " + nThPrimeNumber + "\ntime: " + elapsed + " ms";
        System.err.println(text);
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    //https://stackoverflow.com/a/9625716/5137352
    private static long nThPrimeNumber(int n) {
        int counter = 0;

        for (long i = 1; ; i++) {
            if (isPrime(i))
                counter++;

            if (counter == n) {
                return i;
            }
        }
    }

    private static boolean isPrime(long n) {
        if (n < 2) return false;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    private static native long nativeGetNthPrimeNumber(int n);

}
