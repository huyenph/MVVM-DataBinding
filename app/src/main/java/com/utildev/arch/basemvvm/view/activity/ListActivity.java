package com.utildev.arch.basemvvm.view.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.utildev.arch.basemvvm.R;
import com.utildev.arch.basemvvm.common.base.adapter.BaseAdapter;
import com.utildev.arch.basemvvm.common.base.adapter.SingleTypeAdapter;
import com.utildev.arch.basemvvm.databinding.ActivityListBinding;
import com.utildev.arch.basemvvm.model.local.Contact;

public class ListActivity extends AppCompatActivity implements BaseAdapter.AdapterListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_list);
        ObservableList<Contact> contacts = new ObservableArrayList<>();
        for (int i = 0; i < 50; i++) {
            contacts.add(new Contact("app " + i, "Android",
                    "0123456789", "app" + i + "@gmail.com", "Development"));
        }
        SingleTypeAdapter<Contact> adapter = new SingleTypeAdapter<>(this, R.layout.item_recycler_1);
        adapter.addAll(contacts);
        adapter.setAdapterListener(this);
        binding.setLayoutManager(new LinearLayoutManager(this));
        binding.setAdapter(adapter);
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
