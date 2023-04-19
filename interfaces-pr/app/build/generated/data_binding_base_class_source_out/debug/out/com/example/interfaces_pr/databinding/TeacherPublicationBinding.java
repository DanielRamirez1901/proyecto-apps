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

public final class TeacherPublicationBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardView2;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final TextView pbContentTxt;

  @NonNull
  public final TextView pbDayTxt;

  @NonNull
  public final ImageView pbImagepbImg;

  @NonNull
  public final TextView pbMouthTxt;

  @NonNull
  public final ImageView pbUserImg;

  @NonNull
  public final TextView pbUserNameTxt;

  @NonNull
  public final TextView pbYearTxt;

  @NonNull
  public final TextView textView6;

  private TeacherPublicationBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardView2,
      @NonNull ImageView imageView5, @NonNull TextView pbContentTxt, @NonNull TextView pbDayTxt,
      @NonNull ImageView pbImagepbImg, @NonNull TextView pbMouthTxt, @NonNull ImageView pbUserImg,
      @NonNull TextView pbUserNameTxt, @NonNull TextView pbYearTxt, @NonNull TextView textView6) {
    this.rootView = rootView;
    this.cardView2 = cardView2;
    this.imageView5 = imageView5;
    this.pbContentTxt = pbContentTxt;
    this.pbDayTxt = pbDayTxt;
    this.pbImagepbImg = pbImagepbImg;
    this.pbMouthTxt = pbMouthTxt;
    this.pbUserImg = pbUserImg;
    this.pbUserNameTxt = pbUserNameTxt;
    this.pbYearTxt = pbYearTxt;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TeacherPublicationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TeacherPublicationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.teacher_publication, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TeacherPublicationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView2;
      CardView cardView2 = ViewBindings.findChildViewById(rootView, id);
      if (cardView2 == null) {
        break missingId;
      }

      id = R.id.imageView5;
      ImageView imageView5 = ViewBindings.findChildViewById(rootView, id);
      if (imageView5 == null) {
        break missingId;
      }

      id = R.id.pb_contentTxt;
      TextView pbContentTxt = ViewBindings.findChildViewById(rootView, id);
      if (pbContentTxt == null) {
        break missingId;
      }

      id = R.id.pb_dayTxt;
      TextView pbDayTxt = ViewBindings.findChildViewById(rootView, id);
      if (pbDayTxt == null) {
        break missingId;
      }

      id = R.id.pb_imagepbImg;
      ImageView pbImagepbImg = ViewBindings.findChildViewById(rootView, id);
      if (pbImagepbImg == null) {
        break missingId;
      }

      id = R.id.pb_mouthTxt;
      TextView pbMouthTxt = ViewBindings.findChildViewById(rootView, id);
      if (pbMouthTxt == null) {
        break missingId;
      }

      id = R.id.pb_userImg;
      ImageView pbUserImg = ViewBindings.findChildViewById(rootView, id);
      if (pbUserImg == null) {
        break missingId;
      }

      id = R.id.pb_userNameTxt;
      TextView pbUserNameTxt = ViewBindings.findChildViewById(rootView, id);
      if (pbUserNameTxt == null) {
        break missingId;
      }

      id = R.id.pb_yearTxt;
      TextView pbYearTxt = ViewBindings.findChildViewById(rootView, id);
      if (pbYearTxt == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      return new TeacherPublicationBinding((ConstraintLayout) rootView, cardView2, imageView5,
          pbContentTxt, pbDayTxt, pbImagepbImg, pbMouthTxt, pbUserImg, pbUserNameTxt, pbYearTxt,
          textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}