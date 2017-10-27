package com.example.amd.docbaorss;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new docbaorss().execute("https://vnexpress.net/rss/so-hoa.rss");
    }
    private class docbaorss extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder content = new StringBuilder();
            try {
                URL url = new URL(strings[0]);
                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line="";
                while((line=bufferedReader.readLine())!=null){
                    content.append(line);
                }
                bufferedReader.close();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content.toString();

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodelist = document.getElementsByTagName("item");
            Toast.makeText(MainActivity.this, "Item"+nodelist.getLength(), Toast.LENGTH_SHORT).show();
            NodeList nodeListdescription = document.getElementsByTagName("description");
            String tieude="";
            String hinhanh="";
            String link="";
            for(int i=1;i<nodelist.getLength();i++){
                String cdata=nodeListdescription.item(i+1).getTextContent();
                Pattern p = Pattern.compile("<img[^>]+src\\s*-\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher match=p.matcher(cdata);
                if(match.find()){
                    hinhanh=match.group(1);
                    Log.d("hinhanh: ",hinhanh+"......"+i);
                }

                Element element= (Element) nodelist.item(i);
                tieude = parser.getValue(element,"title");


            }

        }
    }
}
