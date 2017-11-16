package com.example.anhkhoa.diffutil;

import java.util.List;

/**
 * Created by anh khoa on 11/16/2017.
 */

public class DiffUtil extends android.support.v7.util.DiffUtil.Callback {
    List<Student>newList;
    List<Student>oldList;

    public DiffUtil(List<Student> newList, List<Student> oldList) {
        this.newList = newList;
        this.oldList = oldList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).getTen()==newList.get(newItemPosition).getTen();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return oldList.get(oldItemPosition).equals(newList.get(newItemPosition).getTen());
    }
}
