package com.bca.mp_lab_reports.Lab4;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bca.mp_lab_reports.R;
public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lab4_homefragment, container, false);
        Button btnKnowMore = view.findViewById(R.id.btnKnowMore);
        btnKnowMore.setOnClickListener(v ->
                Toast.makeText(getActivity(), "More features coming soon!", Toast.LENGTH_SHORT).show()
        );
        return view;
    }
}
