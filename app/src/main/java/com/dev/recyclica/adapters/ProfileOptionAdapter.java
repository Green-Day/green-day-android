package com.dev.recyclica.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.recyclica.R;
import com.dev.recyclica.pojo.ProfileOption;

import java.util.ArrayList;
import java.util.List;

public class ProfileOptionAdapter extends RecyclerView.Adapter<ProfileOptionAdapter.ViewHolderOption> {

    private List<ProfileOption> options = new ArrayList<>();

    public void setOptions(List<ProfileOption> newOptions) {
        options.addAll(newOptions);
    }

    @NonNull
    @Override
    public ViewHolderOption onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.option_view, parent, false);

        return new ViewHolderOption(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderOption holder, int position) {
        holder.bind(options.get(position));
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    class ViewHolderOption extends RecyclerView.ViewHolder {

        private TextView mOptionName;
        private TextView mDescription;
        private Switch mActivate;

        public ViewHolderOption(@NonNull View itemView) {
            super(itemView);
            mActivate = itemView.findViewById(R.id.switch_option);
            mDescription = itemView.findViewById(R.id.tv_option_description);
            mOptionName = itemView.findViewById(R.id.tv_option_name);
        }

        public void bind(ProfileOption option) {
            mActivate.setChecked(option.isActivate());
            mDescription.setText(String.valueOf(option.getDescription()));
            mOptionName.setText(String.valueOf(option.getName()));
        }

    }
}
