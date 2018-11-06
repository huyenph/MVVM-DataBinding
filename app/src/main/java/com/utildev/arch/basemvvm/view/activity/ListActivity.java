package com.utildev.arch.basemvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.utildev.arch.basemvvm.R;
import com.utildev.arch.basemvvm.common.base.BaseActivity;
import com.utildev.arch.basemvvm.common.base.adapter.BaseAdapter;
import com.utildev.arch.basemvvm.common.base.adapter.BindingAdapter;
import com.utildev.arch.basemvvm.databinding.ActivityListBinding;
import com.utildev.arch.basemvvm.model.local.Contact;

public class ListActivity extends BaseActivity implements BaseAdapter.AdapterListener {
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        ObservableList<Contact> contacts = new ObservableArrayList<>();
        for (int i = 0; i < 50; i++) {
            contacts.add(new Contact("app " + i, "Android",
                    "0123456789", "app" + i + "@gmail.com", "Development",
                    "https://www.popsci.com/sites/popsci.com/files/styles/1000_1x_/public/images/2018/01/00-samsung-galaxy.jpg?itok=vDyepAAI&fc=50,50"));
        }
        BindingAdapter<Contact> adapter = new BindingAdapter<>(this, R.layout.item_recycler);
        adapter.addAll(contacts);
        adapter.setAdapterListener(this);
        layoutManager = new GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false);
        binding.setLayoutManager(layoutManager);
        binding.setAdapter(adapter);

        binding.actListRvContent.addOnScrollListener(new RecyclerView.OnScrollListener() {
            int visibleItemCount, totalItemCount, firstVisibleItem;
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    visibleItemCount = layoutManager.getChildCount();
                    totalItemCount = layoutManager.getItemCount();
                    firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                    Log.d("aaa", "onScrolled: ");
                }
            }
        });
    }

    @Override
    public void onItemClick(String value) {
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(Object object) {
        if (object instanceof Contact) {
            Contact contact = (Contact) object;
            Toast.makeText(this, contact.getName() + "\n" + contact.getCompany() + "\n" + contact.getEmail() + "\n"
                    + contact.getMobile() + "\n" + contact.getGroupName(), Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
