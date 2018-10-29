package com.utildev.arch.basemvvm.common.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {
    private FragmentResultListener fmResultListener;
    private int requestCode;

    // for receive
    public void setFragmentResult(int requestCode, FragmentResultListener listener) {
        this.requestCode = requestCode;
        this.fmResultListener = listener;
    }

    // for send callback
    public void callBackFragmentResult(Bundle bundle) {
        if (fmResultListener != null) {
            fmResultListener.onFragmentResult(requestCode, bundle);
        }
    }

    public void replaceFragment(BaseFragment fragment, boolean addToBackStack, boolean animation) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).replaceFragment(fragment, addToBackStack, animation);
        }
    }

    public void addFragment(BaseFragment fragment, boolean addToBackStack, boolean animation) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).addFragment(fragment, addToBackStack, animation);
        }
    }

    public void clearAllStack() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).clearAllStack();
        }
    }

    interface FragmentResultListener {
        void onFragmentResult(int code, Bundle bundle);
    }
}
