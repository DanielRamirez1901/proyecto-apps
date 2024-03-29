// Generated by view binder compiler. Do not edit!
package com.example.interfaces_pr.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.interfaces_pr.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TeamIcesiBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView playerNameTxt;

  @NonNull
  public final ImageView profileTeamImg;

  @NonNull
  public final TextView roleTeamTxt;

  @NonNull
  public final ImageView shieldTeamImg;

  private TeamIcesiBinding(@NonNull ConstraintLayout rootView, @NonNull TextView playerNameTxt,
      @NonNull ImageView profileTeamImg, @NonNull TextView roleTeamTxt,
      @NonNull ImageView shieldTeamImg) {
    this.rootView = rootView;
    this.playerNameTxt = playerNameTxt;
    this.profileTeamImg = profileTeamImg;
    this.roleTeamTxt = roleTeamTxt;
    this.shieldTeamImg = shieldTeamImg;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TeamIcesiBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TeamIcesiBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.team_icesi, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TeamIcesiBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.player_nameTxt;
      TextView playerNameTxt = ViewBindings.findChildViewById(rootView, id);
      if (playerNameTxt == null) {
        break missingId;
      }

      id = R.id.profile_teamImg;
      ImageView profileTeamImg = ViewBindings.findChildViewById(rootView, id);
      if (profileTeamImg == null) {
        break missingId;
      }

      id = R.id.role_teamTxt;
      TextView roleTeamTxt = ViewBindings.findChildViewById(rootView, id);
      if (roleTeamTxt == null) {
        break missingId;
      }

      id = R.id.shield_teamImg;
      ImageView shieldTeamImg = ViewBindings.findChildViewById(rootView, id);
      if (shieldTeamImg == null) {
        break missingId;
      }

      return new TeamIcesiBinding((ConstraintLayout) rootView, playerNameTxt, profileTeamImg,
          roleTeamTxt, shieldTeamImg);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
