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

    public void addFragmentWithNoBackStack(FragmentManager fm,
                                            @IdRes int containerViewId,
                                            @NonNull Fragment fragment,
                                            @NonNull String fragmentTag){

        try{
                    fm
                    .beginTransaction()
                    .add(containerViewId, fragment, fragmentTag)
                    .disallowAddToBackStack()
                    .commit();
        }catch (Exception e){
            Log.d(TAG,"in add fragment with no back stack :"+e.getMessage());
            e.printStackTrace();
        }

    }

    public void addFragment(FragmentManager fm,
                            @IdRes int containerViewId,
                            @NonNull Fragment fragment,
                            @NonNull String fragmentTag,
                            @NonNull String fragmentNameInBackStack){
        try{
                    fm
                    .beginTransaction()
                    .add(containerViewId, fragment, fragmentTag)
                    .addToBackStack(fragmentNameInBackStack)
                    .commit();
        }catch (Exception e){
            Log.d(TAG,"in add fragment  :"+e.getMessage());
            e.printStackTrace();
        }

    }


    public void addSupportFragment(android.support.v4.app.FragmentManager fm,
                                   @IdRes int containerViewId,
                                   @NonNull android.support.v4.app.Fragment fragment,
                                   @NonNull String fragmentTag,
                                   @NonNull String fragmentNameInBackStack){
        try{
                    fm
                    .beginTransaction()
                    .add(containerViewId,fragment,fragmentTag)
                    .addToBackStack(fragmentNameInBackStack)
                    .commit();
        }catch (Exception e){
            Log.d(TAG,"in add fragment  :"+e.getMessage());
            e.printStackTrace();
        }

    }

    public void replaceFragmentWithNoBackStack(FragmentManager fm,@IdRes int containerViewId,
                                   @NonNull Fragment fragment,
                                   @NonNull String fragmentTag) {
        try{

                    fm
                    .beginTransaction()
                    .replace(containerViewId, fragment, fragmentTag)
                    .disallowAddToBackStack()
                    .commit();
        }catch (Exception e){
            Log.d(TAG,"in replace fragment with no back stack  :"+e.getMessage());
            e.printStackTrace();

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

    public void replaceSupportFragment(android.support.v4.app.FragmentManager fm,
                                @IdRes int containerViewId,
                                @NonNull android.support.v4.app.Fragment fragment,
                                @NonNull String fragmentTag,
                                @Nullable String fragmentNameInBackStack) {
        try{
            fm
                    .beginTransaction()
                    .replace(containerViewId, fragment, fragmentTag)
                    .addToBackStack(fragmentNameInBackStack)
                    .commit();

        }catch (Exception e){
            Log.d(TAG,"in replace fragment  :"+e.getMessage());
            e.printStackTrace();
        }
    }

    public String getFragmentAtImmediateBack(FragmentManager fm){
        return fm.getBackStackEntryAt(fm.getBackStackEntryCount()-1).getName();
    }

    public String getSupportFragmentAtImmediateBack(android.support.v4.app.FragmentManager fm){
        return fm.getBackStackEntryAt(fm.getBackStackEntryCount()-1).getName();
    }


    public void clearAll(android.support.v4.app.FragmentManager fm){
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }
}
