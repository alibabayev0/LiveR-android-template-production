package com.gaan.liver.ui.discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.gaan.liver.R;
import com.gaan.liver.data.model.api.response.GetEventResponse;
import com.gaan.liver.databinding.ActivityDiscoverBinding;
import com.gaan.liver.databinding.ItemNearbyPlacesBinding;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class DiscoverNearbyEventsAdapter extends RecyclerView.Adapter<DiscoverNearbyEventsAdapter.DiscoverNearbyEventsViewHolder> {

    private Context mContext;
    private List<GetEventResponse> mGetEventResponseList = Collections.emptyList();

    public DiscoverNearbyEventsAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public DiscoverNearbyEventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNearbyPlacesBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.item_nearby_places,parent,false);
        return new DiscoverNearbyEventsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull DiscoverNearbyEventsViewHolder holder, int position) {
        holder.bindMoview(mGetEventResponseList.get(position));
    }

    public void setAdapterList(List<GetEventResponse> getEventResponses){
        mGetEventResponseList = getEventResponses;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mGetEventResponseList.size();
    }


    public class DiscoverNearbyEventsViewHolder extends RecyclerView.ViewHolder {
        private ItemNearbyPlacesBinding mItemNearbyPlacesBinding;
        public DiscoverNearbyEventsViewHolder(ItemNearbyPlacesBinding itemNearbyPlacesBinding) {
            super(itemNearbyPlacesBinding.getRoot());
            mItemNearbyPlacesBinding = itemNearbyPlacesBinding;
        }

        void bindMoview(GetEventResponse data){
            mItemNearbyPlacesBinding.setVariable(BR.nearbyEventModel,data);
            mItemNearbyPlacesBinding.executePendingBindings();
        }
    }
}
