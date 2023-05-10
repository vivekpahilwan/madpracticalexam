package com.example.progressdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button bt1;
ProgressDialog pd;
private int progressStatus=0;
private Handler progressHandler=new Handler();
private long filesize=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButtonClick();
    }
    public void addListenerOnButtonClick()
    {
        bt1=(Button) findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pd=new ProgressDialog(view.getContext());
                pd.setCancelable(true);
                pd.setMessage("File Downloading");
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd.setProgress(0);
                pd.setMax(100);
                pd.show();
                progressStatus=0;
                filesize=0;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(progressStatus<100)
                        {
                            progressStatus=doOperation();
                            try {

                                    Thread.sleep(1000);

                                }catch(InterruptedException e)
                                {
                                    e.printStackTrace();
                                }
                                progressHandler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        pd.setProgress(progressStatus);
                                    }
                                });

                        }
                        if(progressStatus>=100)
                        {
                            try {

                                    Thread.sleep(1000);
                                }
                                catch(InterruptedException e)
                                {
                                    e.printStackTrace();
                                }
                                pd.dismiss();
                            }

                    }
                }).start();
            }
        });
    }
    public int doOperation()
    {
        while(filesize<=10000)
        {
            filesize++;
            if (filesize==1000)
            {
                return 10;
            } else if (filesize==2000) {
                return 20;

            } else if (filesize==3000) {
                return 30;
            } else if (filesize==4000) {
                return 40;
            }


        }
        return 100;
    }
}