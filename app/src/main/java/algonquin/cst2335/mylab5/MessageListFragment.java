package algonquin.cst2335.mylab5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MessageListFragment extends Fragment {

    boolean isTablet = true;

    public MessageListFragment(boolean isT){
        isTablet = isT;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View thisLayout = inflater.inflate(R.layout.fragment_layout, container, false);

        Button add = thisLayout.findViewById(R.id.addButton);
        Button remove = thisLayout.findViewById(R.id.removeButton);

        add.setOnClickListener( addClicked -> {

            DetailFragment theFragment = new DetailFragment();

            MainActivity parentActivity = (MainActivity)getContext();

            FragmentManager fMgr = parentActivity.getSupportFragmentManager(); //getSupportFragmentManager(); // because it extends Fragment class
            FragmentTransaction tx = fMgr.beginTransaction();

            if(isTablet)
                tx.add(R.id.detailsLocation, theFragment);
            else
                tx.add(R.id.fragmentLocation, theFragment);

            tx.commit();

        });

        remove.setOnClickListener( addClicked -> {


        });

        return thisLayout;
    }
}

// 1024 x 768  smallest 768
// 768 x 1024  smallest 768 as well

//Pixel 3 API29   1080 x 2160
//Pixel 4XL API27 1440 X 3040