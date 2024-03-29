// Generated by view binder compiler. Do not edit!
package com.example.interfaces_pr.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class CourseScheduleBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView daytxt;

  @NonNull
  public final TextView hour1txt;

  @NonNull
  public final TextView hour2txt;

  @NonNull
  public final TextView teachertxt;

  @NonNull
  public final View view10;

  @NonNull
  public final View view13;

  @NonNull
  public final View view5;

  @NonNull
  public final View view7;

  private CourseScheduleBinding(@NonNull ConstraintLayout rootView, @NonNull TextView daytxt,
      @NonNull TextView hour1txt, @NonNull TextView hour2txt, @NonNull TextView teachertxt,
      @NonNull View view10, @NonNull View view13, @NonNull View view5, @NonNull View view7) {
    this.rootView = rootView;
    this.daytxt = daytxt;
    this.hour1txt = hour1txt;
    this.hour2txt = hour2txt;
    this.teachertxt = teachertxt;
    this.view10 = view10;
    this.view13 = view13;
    this.view5 = view5;
    this.view7 = view7;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CourseScheduleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CourseScheduleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.course_schedule, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CourseScheduleBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.daytxt;
      TextView daytxt = ViewBindings.findChildViewById(rootView, id);
      if (daytxt == null) {
        break missingId;
      }

      id = R.id.hour1txt;
      TextView hour1txt = ViewBindings.findChildViewById(rootView, id);
      if (hour1txt == null) {
        break missingId;
      }

      id = R.id.hour2txt;
      TextView hour2txt = ViewBindings.findChildViewById(rootView, id);
      if (hour2txt == null) {
        break missingId;
      }

      id = R.id.teachertxt;
      TextView teachertxt = ViewBindings.findChildViewById(rootView, id);
      if (teachertxt == null) {
        break missingId;
      }

      id = R.id.view10;
      View view10 = ViewBindings.findChildViewById(rootView, id);
      if (view10 == null) {
        break missingId;
      }

      id = R.id.view13;
      View view13 = ViewBindings.findChildViewById(rootView, id);
      if (view13 == null) {
        break missingId;
      }

      id = R.id.view5;
      View view5 = ViewBindings.findChildViewById(rootView, id);
      if (view5 == null) {
        break missingId;
      }

      id = R.id.view7;
      View view7 = ViewBindings.findChildViewById(rootView, id);
      if (view7 == null) {
        break missingId;
      }

      return new CourseScheduleBinding((ConstraintLayout) rootView, daytxt, hour1txt, hour2txt,
          teachertxt, view10, view13, view5, view7);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
