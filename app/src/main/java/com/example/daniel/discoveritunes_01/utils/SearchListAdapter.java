package com.example.daniel.discoveritunes_01.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.daniel.discoveritunes_01.R;
import com.example.daniel.discoveritunes_01.model.Result;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 5/27/17.
 */

public class SearchListAdapter extends RecyclerView.Adapter<SearchListAdapter.SearchViewHolder> {

    private static final String BASE_URL_IMG = "http://a1.itunes.apple.com/r10/Music/3b/6a/33";

    private List<Result> results;
    private int rowLayout;
    private Context context;

    public SearchListAdapter(List<Result> results, int rowLayout, Context context) {
        this.results = results;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new SearchViewHolder(view, context, results);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        Glide.with(context.getApplicationContext())
                .load(BASE_URL_IMG + results.get(position).getArtworkUrl30())
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(holder.artWrk30);
        holder.trackNameTxtVw.setText(results.get(position).getTrackName());
        holder.priceTxtVw.setText(results.get(position).getTrackPrice().toString());
        holder.descriptionTxtVw.setText(results.get(position).getKind());
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void updateList(List<Result> listResult){
        results = listResult;
        notifyDataSetChanged();
    }

    /*
        This is SearchViewHolder pattern helps you work with each item of the
        recyclerview, in here we will work with the recyclerview
     */
    public class SearchViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.cv_artworkUrl30)
        ImageView artWrk30;
        @BindView(R.id.cv_trackName)
        TextView trackNameTxtVw;
        @BindView(R.id.cv_price)
        TextView priceTxtVw;
        @BindView(R.id.cv_description)
        TextView descriptionTxtVw;

        LinearLayout linearLayout;
        List<Result> results = new ArrayList<>();
        Context context;

        public SearchViewHolder(View itemView, Context context, List<Result> results) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.context = context;
            this.results = results;
        }

        @Override
        public void onClick(View view) {
            int cdPosition = getAdapterPosition();
            Toast.makeText(context, "position " + cdPosition, Toast.LENGTH_SHORT).show();
        }
    }
}
