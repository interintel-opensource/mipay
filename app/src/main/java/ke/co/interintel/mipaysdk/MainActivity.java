package ke.co.interintel.mipaysdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import ke.co.interintel.mipay.Mipay;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case Mipay.REQUEST_CODE_MIPAY_PAYMENT:
                if (resultCode == Activity.RESULT_OK) {
                    String result = data.getStringExtra("message");
                    Log.i(TAG, result);
                    try {
                        JSONObject payload = new JSONObject(result);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else if (resultCode == Activity.RESULT_CANCELED) {
                    //Write your code if there's no result
                }

                break;

            default:
                break;
        }
    }


    public void pay(View view) {

        String reference = "1-INTINT-CVI35";
        Mipay.checkout(this, reference);

    }

}