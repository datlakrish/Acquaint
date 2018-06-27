package com.verity.datlashiv.acquaint;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class PdfFragment extends Fragment {

    PDFView pdfView;

    public PdfFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pdf, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        pdfView = view.findViewById(R.id.pdfView);

        new RetrievePDF().execute("https://www.bls.gov/news.release/pdf/famee.pdf");


    }

    class RetrievePDF extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection.getResponseCode() == 200){
                        inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                }
            }  catch (IOException e) {
                return null;
            }
            return String.valueOf(inputStream);
        }


        protected void onPostExecute(InputStream inputStream) {
              pdfView.fromStream(inputStream).load();
        }
    }
}
