package com.bca.mp_lab_reports.Lab2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bca.mp_lab_reports.R;
public class Lab2Constraint extends AppCompatActivity {
    private ImageView profileImage;
    private TextView nameText, subtitleText;
    private Button messageButton, followButton;
    private boolean isFollowing = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constraintlayout); // Link to XML layout
        profileImage = findViewById(R.id.profileImage);
        nameText = findViewById(R.id.nameText);
        subtitleText = findViewById(R.id.subtitleText);
        messageButton = findViewById(R.id.messageButton);
        followButton = findViewById(R.id.followButton);
        nameText.setText("Teelesa Shrestha");
        subtitleText.setText("Full Stack Developer");
        // Set click listeners
        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Lab2Constraint.this, "Message clicked!", Toast.LENGTH_SHORT).show();
                // You could open a chat activity here
            }
        });
        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFollowing = !isFollowing;
                String message = isFollowing ? "You are now following Anup" : "Unfollowed Anup";
                followButton.setText(isFollowing ? "Unfollow" : "Follow");
                Toast.makeText(Lab2Constraint.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
