package sg.edu.rp.c346.rpwebsites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.KeyEvent;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    TextView tv2;
    Spinner spn1;
    Spinner spn2;
    Button  btnGo;
    KeyEvent key1;
    WebView wvMyPage;
    ArrayList<String> alSub;
    ArrayAdapter<String> aaSub;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonAdd);
        wvMyPage = findViewById(R.id.WebView);

        wvMyPage.setWebViewClient(new WebViewClient());
        wvMyPage.getSettings().setAllowFileAccessFromFileURLs(false);
        wvMyPage.getSettings().setJavaScriptEnabled(true);
        wvMyPage.getSettings().setDisplayZoomControls(true);
        alSub = new ArrayList<>();

        String[]strNumbers = getResources().getStringArray(R.array.RpSub);
        alSub.addAll(Arrays.asList(strNumbers));

        aaSub = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,alSub);
        spn2.setAdapter(aaSub);



        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        alSub.clear();
                        String[]strNumbers = getResources().getStringArray(R.array.RpSub);
                        alSub.addAll(Arrays.asList(strNumbers));
                        break;

                    case 1:
                        alSub.clear();
                        String[]strNumbers2 = getResources().getStringArray(R.array.SoiSub);
                        alSub.addAll(Arrays.asList(strNumbers2));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String [][] sites = {
                        {"https://www.rp.edu.sg/","https://www.rp.edu.sg/student-life"},
                        {"https://www.rp.edu.sg/soi/full-time-diplomas/details/r47",
                                "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"}
                };
                String url = sites[spn1.getSelectedItemPosition()][spn2.getSelectedItemPosition()];

                /*String url = "";
                if(spn2.getSelectedItem().equals("HomePage")){
                    url = "https://www.rp.edu.sg/";
                }
                else if (spn2.getSelectedItem().equals("Student Life")){
                    url = "https://www.rp.edu.sg/student-life";
                }
                else if (spn2.getSelectedItem().equals("Student Life")){
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
            } else {
                    url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                }*/
                wvMyPage.loadUrl(url);
                tv1.setVisibility(View.GONE);
                tv2.setVisibility(View.GONE);
                spn1.setVisibility(View.GONE);
                spn2.setVisibility(View.GONE);
                btnGo.setVisibility(View.GONE);
                wvMyPage.setVisibility(View.VISIBLE);


        }});




    }
    @Override
    public void onBackPressed()
    {
        spn1.setVisibility(View.VISIBLE);
        spn2.setVisibility(View.VISIBLE);
        btnGo.setVisibility(View.VISIBLE);
        tv1.setVisibility(View.VISIBLE);
        tv2.setVisibility(View.VISIBLE);
        wvMyPage.setVisibility(View.GONE);
    }
}
