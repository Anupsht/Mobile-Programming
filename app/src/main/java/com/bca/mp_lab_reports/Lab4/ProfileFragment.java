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
public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle b) {
        View view = inflater.inflate(R.layout.lab4_profilefragment, container, false);
        Button btnEdit = view.findViewById(R.id.btnEditProfile);
        Button btnLogout = view.findViewById(R.id.btnLogout);
        btnEdit.setOnClickListener(v ->
                Toast.makeText(getActivity(), "Edit Profile Clicked", Toast.LENGTH_SHORT).show());
        btnLogout.setOnClickListener(v ->
                Toast.makeText(getActivity(), "Logged out successfully", Toast.LENGTH_SHORT).show());
        return view;
    }
}
