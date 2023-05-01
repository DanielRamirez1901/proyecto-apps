// Generated by view binder compiler. Do not edit!
package com.example.interfaces_pr.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.interfaces_pr.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CommentStyleBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardView5;

  @NonNull
  public final ImageView imageView18;

  @NonNull
  public final ImageView imageView20;

  @NonNull
  public final ImageView likeIncommentImg;

  @NonNull
  public final TextView numerLikesIncommentTxt;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView timeIncommentTxt;

  @NonNull
  public final ImageView userIncommentImg;

  @NonNull
  public final TextView usercontIncommentTxt;

  @NonNull
  public final TextView usernameIncommentTxt;

  private CommentStyleBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardView5,
      @NonNull ImageView imageView18, @NonNull ImageView imageView20,
      @NonNull ImageView likeIncommentImg, @NonNull TextView numerLikesIncommentTxt,
      @NonNull TextView textView15, @NonNull TextView timeIncommentTxt,
      @NonNull ImageView userIncommentImg, @NonNull TextView usercontIncommentTxt,
      @NonNull TextView usernameIncommentTxt) {
    this.rootView = rootView;
    this.cardView5 = cardView5;
    this.imageView18 = imageView18;
    this.imageView20 = imageView20;
    this.likeIncommentImg = likeIncommentImg;
    this.numerLikesIncommentTxt = numerLikesIncommentTxt;
    this.textView15 = textView15;
    this.timeIncommentTxt = timeIncommentTxt;
    this.userIncommentImg = userIncommentImg;
    this.usercontIncommentTxt = usercontIncommentTxt;
    this.usernameIncommentTxt = usernameIncommentTxt;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CommentStyleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CommentStyleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.comment_style, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CommentStyleBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView5;
      CardView cardView5 = ViewBindings.findChildViewById(rootView, id);
      if (cardView5 == null) {
        break missingId;
      }

      id = R.id.imageView18;
      ImageView imageView18 = ViewBindings.findChildViewById(rootView, id);
      if (imageView18 == null) {
        break missingId;
      }

      id = R.id.imageView20;
      ImageView imageView20 = ViewBindings.findChildViewById(rootView, id);
      if (imageView20 == null) {
        break missingId;
      }

      id = R.id.like_incommentImg;
      ImageView likeIncommentImg = ViewBindings.findChildViewById(rootView, id);
      if (likeIncommentImg == null) {
        break missingId;
      }

      id = R.id.numerLikes_incommentTxt;
      TextView numerLikesIncommentTxt = ViewBindings.findChildViewById(rootView, id);
      if (numerLikesIncommentTxt == null) {
        break missingId;
      }

      id = R.id.textView15;
      TextView textView15 = ViewBindings.findChildViewById(rootView, id);
      if (textView15 == null) {
        break missingId;
      }

      id = R.id.time_incommentTxt;
      TextView timeIncommentTxt = ViewBindings.findChildViewById(rootView, id);
      if (timeIncommentTxt == null) {
        break missingId;
      }

      id = R.id.user_incommentImg;
      ImageView userIncommentImg = ViewBindings.findChildViewById(rootView, id);
      if (userIncommentImg == null) {
        break missingId;
      }

      id = R.id.usercont_incommentTxt;
      TextView usercontIncommentTxt = ViewBindings.findChildViewById(rootView, id);
      if (usercontIncommentTxt == null) {
        break missingId;
      }

      id = R.id.username_incommentTxt;
      TextView usernameIncommentTxt = ViewBindings.findChildViewById(rootView, id);
      if (usernameIncommentTxt == null) {
        break missingId;
      }

      return new CommentStyleBinding((ConstraintLayout) rootView, cardView5, imageView18,
          imageView20, likeIncommentImg, numerLikesIncommentTxt, textView15, timeIncommentTxt,
          userIncommentImg, usercontIncommentTxt, usernameIncommentTxt);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}