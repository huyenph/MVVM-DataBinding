package com.utildev.arch.basemvvm.viewmodel.activity;

import android.content.Intent;
import android.view.View;

import com.utildev.arch.basemvvm.common.base.BaseActivity;
import com.utildev.arch.basemvvm.common.base.BaseModel;
import com.utildev.arch.basemvvm.common.base.BaseViewModel;
import com.utildev.arch.basemvvm.model.rest.RestError;
import com.utildev.arch.basemvvm.view.activity.ListActivity;
import com.utildev.arch.basemvvm.view.fragment.MainFragment;

public class ActMainVM extends BaseViewModel {
    public void onClickRv(View view) {
        view.getContext().startActivity(new Intent(view.getContext(), ListActivity.class));
    }

    public void onClickRetrofit(View view) {
        if (view.getContext() instanceof BaseActivity) {
            ((BaseActivity) view.getContext()).addFragment(new MainFragment(), true, true);
        }
    }

    @Override
    public void onDataResponse(int code, BaseModel model) {
        dismissLoading(null);
    }

    @Override
    public void onDataError(int code, RestError error) {
        dismissLoading(null);
    }
}
