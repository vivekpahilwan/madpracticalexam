package com.example.gp;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        List<NewsArticle> mArticles = new ArrayList<>();
        mArticles.add(new NewsArticle("Article 1", "This is the first article", "https://via.placeholder.com/150"));
        mArticles.add(new NewsArticle("Article 2", "This is the second article", "https://via.placeholder.com/150"));
        mArticles.add(new NewsArticle("Article 3", "This is the third article", "https://via.placeholder.com/150"));
        mArticles.add(new NewsArticle("Article 4", "This is the fourth article", "https://via.placeholder.com/150"));
        mArticles.add(new NewsArticle("Article 5", "This is the fifth article", "https://via.placeholder.com/150"));

        // Handle item click
        NewsAdapter mAdapter = new NewsAdapter(mArticles, position -> {
            // Handle item click
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    public static class NewsArticle {

        private final String mTitle;
        private final String mDescription;
        private final String mImageUrl;

        public NewsArticle(String title, String description, String imageUrl) {
            mTitle = title;
            mDescription = description;
            mImageUrl = imageUrl;
        }

        public String getTitle() {
            return mTitle;
        }

        public String getDescription() {
            return mDescription;
        }

        public String getImageUrl() {
            return mImageUrl;
        }

    }

    public static class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> implements com.example.gp.NewsAdapter {

        private final List<NewsArticle> mArticles;
        private final OnItemClickListener mListener;

        public interface OnItemClickListener {
            void onItemClick(int position);
        }

        public NewsAdapter(List<NewsArticle> articles, OnItemClickListener listener) {
            mArticles = articles;
            mListener = listener;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView mImageView;
            public TextView mTitleTextView;
            public TextView mDescriptionTextView;

            public ViewHolder(View itemView, final OnItemClickListener listener) {
                super(itemView);
                mImageView = itemView.findViewById(R.id.image_view);
                mTitleTextView = itemView.findViewById(R.id.title_text_view);
                mDescriptionTextView = itemView.findViewById(R.id.description_text_view);

                itemView.setOnClickListener(v -> {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                });
            }
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.news_article_item, parent, false);
            return new ViewHolder(itemView, mListener);
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            NewsArticle article = mArticles.get(position);
            holder.mTitleTextView.setText(article.getTitle());
            holder.mDescriptionTextView.setText(article.getDescription());
            Picasso.get().load(article.getImageUrl()).into(holder.mImageView);
        }


        @Override
        public int getItemCount() {
            return mArticles.size();
        }
    }
}
