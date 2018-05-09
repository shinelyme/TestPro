package com.lsngo.myapplication.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lsngo.myapplication.bean.WebBean;
import com.lsngo.myapplication.R;
import com.socks.library.KLog;

import java.util.List;

/**
 * Created by Administrator on 2017/3/23.
 */

public class mRecyclerView extends RecyclerView.Adapter<mRecyclerView.mViewHolder> {
    private Context context;
    private List<WebBean> list;

    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public mRecyclerView(Context context, List<WebBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public mViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_home_item,parent,false);
        mViewHolder mViewHolder = new mViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final mViewHolder holder, final int position) {
        final String title = list.get(position).getTitle();
        String pic_url = list.get(position).getPic_url();
        final String web_url = list.get(position).getWeb_url();
        holder.home_fragment_rv_title.setText(title);
        Glide.with(context).load(pic_url).into(holder.home_fragment_rv_iv);


        if (mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.itemView.setTag(R.id.tag_web_url,web_url);
                    holder.itemView.setTag(R.id.tag_title,title);
                    mOnItemClickListener.onItemClick(v,position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class mViewHolder extends RecyclerView.ViewHolder{

        private final ImageView home_fragment_rv_iv;
        private final TextView home_fragment_rv_title;

        public mViewHolder(View itemView) {
            super(itemView);
            home_fragment_rv_iv = (ImageView) itemView.findViewById(R.id.home_fragment_rv_iv);
            home_fragment_rv_title = (TextView) itemView.findViewById(R.id.home_fragment_rv_title);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View view,int postion);
    }
}
