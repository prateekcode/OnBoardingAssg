package co.riek.onboardingassg.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

import co.riek.onboardingassg.model.BoardingItemModel;
import co.riek.onboardingassg.R;

public class BoardingItemAdapter extends RecyclerView.Adapter<BoardingItemAdapter.BoardingItemViewHolder> {

    private final ArrayList<BoardingItemModel> boardingItemModels;

    public BoardingItemAdapter(ArrayList<BoardingItemModel> itemModels){
        boardingItemModels = itemModels;
    }

    public static class BoardingItemViewHolder extends RecyclerView.ViewHolder{

        private final ShapeableImageView shapeableImageView;
        private final AppCompatTextView textView;

        public BoardingItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_onboarding_text);
            shapeableImageView = itemView.findViewById(R.id.iv_onboarding_item_image);
        }

        public AppCompatTextView getTextView() {
            return textView;
        }

        public ShapeableImageView getShapeableImageView() {
            return shapeableImageView;
        }
    }

    @NonNull
    @Override
    public BoardingItemAdapter.BoardingItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_onboarding_screen, parent, false);
        return new BoardingItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BoardingItemAdapter.BoardingItemViewHolder holder, int position) {
        holder.getShapeableImageView().setImageDrawable(boardingItemModels.get(position).getBoardingImage());
        holder.getTextView().setText(boardingItemModels.get(position).getBoardingText());
    }

    @Override
    public int getItemCount() {
        return boardingItemModels.size();
    }

}
