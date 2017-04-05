package com.example.user.studentmanagementsystem;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 4/4/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private ArrayList<StudentData> dataList;
    private Activity ctx;
    private RecyclerAdapter recyclerAdapter;

    /**
     * @param ctx abz
     */
    public RecyclerAdapter(final Activity ctx) {
        this.dataList = new ArrayList<StudentData>();
        this.ctx = ctx;
        recyclerAdapter = this;
    }

    /**
     * @param studentData abp
     */
    public void addElementInList(final StudentData studentData) {
        dataList.add(studentData);
    }

    /**
     * @param pos position
     * @return get object of studentdata
     */
    public StudentData getElementInList(final int pos) {
        return dataList.get(pos);
    }

    /**
     * @param pos position
     */
    public void deleteElementAtPosition(final int pos) {
        dataList.remove(pos);
    }

    /**
     * @param sdata studentdata
     * @param pos   position
     */
    public void updateElementInList(final StudentData sdata, final int pos) {
        dataList.set(pos, sdata);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    /**
     * @return zp
     */
    public ArrayList<StudentData> getList() {
        return dataList;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvFirstName.setText(dataList.get(position).getFirstName());
        holder.tvLastName.setText(dataList.get(position).getLastName());
        holder.tvEmailAddress.setText(dataList.get(position).getEmail());
        holder.tvGender.setText(dataList.get(position).getGender());
        holder.tvRollNo.setText(String.valueOf(dataList.get(position).getRollNumber()));
        holder.tvSchoolNmae.setText(String.valueOf(dataList.get(position).getSchoolName()));

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * View holder subclass
     */
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvFirstName;
        private TextView tvLastName;
        private TextView tvEmailAddress;
        private TextView tvGender;
        private TextView tvRollNo;
        private TextView tvSchoolNmae;

        /**
         * @param itemView vbn
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvFirstName = (TextView) itemView.findViewById(R.id.first_name);
            tvLastName = (TextView) itemView.findViewById(R.id.last_name);
            tvEmailAddress = (TextView) itemView.findViewById(R.id.email);
            tvGender = (TextView) itemView.findViewById(R.id.gender);
            tvRollNo = (TextView) itemView.findViewById(R.id.roll_no);
            tvSchoolNmae = (TextView) itemView.findViewById(R.id.school_name_value);
            itemView.setOnClickListener(this);
        }

        /**
         * @return hgvh
         */
        public TextView getTvFirstName() {
            return tvFirstName;
        }

        /**
         * @param tvFirstName vg
         */
        public void setTvFirstName(final TextView tvFirstName) {
            this.tvFirstName = tvFirstName;
        }

        /**
         * @return last name
         */
        public TextView getTvLastName() {
            return tvLastName;
        }

        /**
         * @param tvLastName set last name
         */
        public void setTvLastName(final TextView tvLastName) {
            this.tvLastName = tvLastName;
        }

        /**
         * @return email
         */
        public TextView getTvEmailAddress() {
            return tvEmailAddress;
        }

        /**
         * @param tvEmailAddress set email
         */
        public void setTvEmailAddress(final TextView tvEmailAddress) {
            this.tvEmailAddress = tvEmailAddress;
        }

        /**
         * @return return gender
         */
        public TextView getTvGender() {
            return tvGender;
        }

        /**
         * @param tvGender set gender
         */
        public void setTvGender(final TextView tvGender) {
            this.tvGender = tvGender;
        }

        /**
         * @return roll no
         */
        public TextView getTvRollNo() {
            return tvRollNo;
        }

        /**
         * @param tvRollNo set roll no
         */
        public void setTvRollNo(final TextView tvRollNo) {
            this.tvRollNo = tvRollNo;
        }

        /**
         * @return school name
         */
        public TextView getTvSchoolNmae() {
            return tvSchoolNmae;
        }

        /**
         * @param tvSchoolNmae set school name
         */
        public void setTvSchoolNmae(final TextView tvSchoolNmae) {
            this.tvSchoolNmae = tvSchoolNmae;
        }


        @Override
        public void onClick(final View v) {
            int positionAdapter = getAdapterPosition();
            CustomDialogClass dialog = new CustomDialogClass(ctx, positionAdapter, recyclerAdapter);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();

        }
    }
}
