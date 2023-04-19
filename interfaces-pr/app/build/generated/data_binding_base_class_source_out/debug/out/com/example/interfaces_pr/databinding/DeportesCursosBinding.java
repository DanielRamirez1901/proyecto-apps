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

public final class DeportesCursosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView desarrolloImg;

  @NonNull
  public final ImageView futbolImg;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final ImageView tennisImg;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final ImageView tiroArcoImg;

  private DeportesCursosBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView desarrolloImg, @NonNull ImageView futbolImg, @NonNull ImageView imageView3,
      @NonNull ImageView tennisImg, @NonNull TextView textView2, @NonNull TextView textView3,
      @NonNull ImageView tiroArcoImg) {
    this.rootView = rootView;
    this.desarrolloImg = desarrolloImg;
    this.futbolImg = futbolImg;
    this.imageView3 = imageView3;
    this.tennisImg = tennisImg;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.tiroArcoImg = tiroArcoImg;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static DeportesCursosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static DeportesCursosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.deportes_cursos, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static DeportesCursosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.desarrolloImg;
      ImageView desarrolloImg = ViewBindings.findChildViewById(rootView, id);
      if (desarrolloImg == null) {
        break missingId;
      }

      id = R.id.futbolImg;
      ImageView futbolImg = ViewBindings.findChildViewById(rootView, id);
      if (futbolImg == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.tennisImg;
      ImageView tennisImg = ViewBindings.findChildViewById(rootView, id);
      if (tennisImg == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.tiroArcoImg;
      ImageView tiroArcoImg = ViewBindings.findChildViewById(rootView, id);
      if (tiroArcoImg == null) {
        break missingId;
      }

      return new DeportesCursosBinding((ConstraintLayout) rootView, desarrolloImg, futbolImg,
          imageView3, tennisImg, textView2, textView3, tiroArcoImg);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
