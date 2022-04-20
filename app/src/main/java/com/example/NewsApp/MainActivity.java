package com.example.NewsApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements newsAdapter.OnRowClickListener{
    RecyclerView topStoriesRecyclerView,newRecyclerView1,newRecyclerView2;
    topStoriesAdapter topStoriesAdapter;
    newsAdapter newsAdapter1,newsAdapter2;

    List<News> newsList = new ArrayList<>();
    List<News> newsList1 = new ArrayList<>();
    List<News> newsList2 = new ArrayList<>();
    List<News> allNews = new ArrayList<>();
    Integer[] imageList = {R.drawable.photo1, R.drawable.photo2,R.drawable.photo3,R.drawable.photo4,R.drawable.photo5,R.drawable.photo6};
    String[] smallDescription = {"A Holy Week procession ...","Couple say goodbye at ...","A boy in the ruins of ...","A leaping tiger and migrating ..."};
    String[] bigDescription = {"Danyk Rak, 12, holds a cat while standing on the debris of his house destroyed by Russian shelling.","A mass grave in Bucha, the aftermath of the Russian attack on the station in Kramatorsk, young Ukrainian refugees in Tijuana and the shelling of Kharkiv: photographs from the seventh week of the Russian invasion of Ukraine","Yehor, seven, holding a wooden rifle in front of destroyed Russian military vehicles near Chernihiv, Ukraine. ","An aerial view of the Dead Sea, 50 km from Amman in Jordan"};
    String[] newsSource = {"9NEWS","7NEWS","ABC NEWS","THE AGE"};
    RecyclerView fragmentOneRecyclerView;
    fragmentAdapter fragAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // top stories
        topStoriesRecyclerView = findViewById(R.id.topStoriesRecyclerView);
        topStoriesAdapter = new topStoriesAdapter(newsList, MainActivity.this);
        topStoriesRecyclerView.setAdapter(topStoriesAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        topStoriesRecyclerView.setLayoutManager(layoutManager);

        for (int i= 0 ; i< imageList.length; i++)
        {

            News news = new News(i, imageList[i]);
            newsList.add(news);

        }

        //News layout
        newRecyclerView1 = findViewById(R.id.newRowRecycler1);
        newRecyclerView2 = findViewById(R.id.newRowRecycler2);

        newsAdapter1 = new newsAdapter(newsList1,MainActivity.this,this);
        newRecyclerView1.setAdapter(newsAdapter1);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };

        newRecyclerView1.setLayoutManager(layoutManager1);
        newsAdapter2 = new newsAdapter(newsList2,MainActivity.this,this);
        newRecyclerView2.setAdapter(newsAdapter2);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false) {
            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        newRecyclerView2.setLayoutManager(layoutManager2);

        for (int i=0;i<newsSource.length;i++)
        {
            if(i<=1)
            {
                News news = new News(i,imageList[i],smallDescription[i],newsSource[i]);
                newsList1.add(news);
                news = new News(i,imageList[i],smallDescription[i],bigDescription[i],newsSource[i]);
            }
            else{
                News news1 = new News(i,imageList[i],smallDescription[i],bigDescription[i],newsSource[i]);
                newsList2.add(news1);
            }
        }


    }

    @Override
    public void onItemClick(int position,String source) {
        for (int i = 0; i < newsSource.length; i++) {
            News news = new News(i, imageList[i], smallDescription[i], newsSource[i]);
            allNews.add(news);
        }
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        switch (position){
            case 0:
                if(source.equals("9NEWS")){
                    setContentView(R.layout.fragment_one1);
 }
                else {setContentView(R.layout.fragment_three);
                }
                fragmentOneRecyclerView = findViewById(R.id.fragmentOneRecyclerView);
                fragAdapter = new fragmentAdapter(allNews,this);
                fragmentOneRecyclerView.setAdapter(fragAdapter);
                fragmentOneRecyclerView.setLayoutManager(layoutManager2);
                break;
            case 1:
                if(source.equals("7NEWS")){
                    setContentView(R.layout.fragment_two);
                }
                else{
                    setContentView(R.layout.fragment_four);
                }
                fragmentOneRecyclerView = findViewById(R.id.fragmentOneRecyclerView);
                fragAdapter = new fragmentAdapter(allNews,this);
                fragmentOneRecyclerView.setAdapter(fragAdapter);
                fragmentOneRecyclerView.setLayoutManager(layoutManager2);
                break;
        }

    }

}