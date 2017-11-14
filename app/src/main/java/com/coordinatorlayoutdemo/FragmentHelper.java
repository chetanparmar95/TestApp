package com.coordinatorlayoutdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by osp130 on 9/2/17.
 */

public class FragmentHelper {

    public static FragmentHelper mFragmentHelper=null;
    private final String TAG="FRAGMENT_HELPER";

    public FragmentHelper(){}

    public static FragmentHelper getInstance(){
        if(mFragmentHelper==null){
            return new FragmentHelper();
        }else{
            return mFragmentHelper;
        }
    }



    public void replaceFragment(FragmentManager fm,
                                   @IdRes int containerViewId,
                                   @NonNull Fragment fragment,
                                   @NonNull String fragmentTag,
                                   @Nullable String fragmentNameInBackStack) {
        try{
                    fm
                    .beginTransaction()
                    .replace(containerViewId, fragment, fragmentTag)
//                    .addToBackStack(fragmentNameInBackStack)
                    .commit();

        }catch (Exception e){
            Log.d(TAG,"in replace fragment  :"+e.getMessage());
            e.printStackTrace();
        }
    }

}
