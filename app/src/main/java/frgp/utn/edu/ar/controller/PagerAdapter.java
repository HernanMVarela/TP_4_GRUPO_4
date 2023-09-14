package frgp.utn.edu.ar.controller;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    int cantTabs;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.cantTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Alta();
            case 1:
                return new Modificar();
            case 2:
                return new Listar();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return cantTabs;
    }
}
