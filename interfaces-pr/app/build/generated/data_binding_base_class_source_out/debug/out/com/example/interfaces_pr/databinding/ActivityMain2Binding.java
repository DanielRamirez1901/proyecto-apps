// Generated by view binder compiler. Do not edit!
package com.example.interfaces_pr.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
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

public final class ActivityMain2Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FrameLayout frameLayout2;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView imageView3;

  @NonNull
  public final TextView iniciarSesiontxt;

  @NonNull
  public final ImageView loginBtn;

  @NonNull
  public final FrameLayout loginContainerFL;

  @NonNull
  public final FrameLayout nada;

  @NonNull
  public final TextView registrarsetxt;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView2;

  private ActivityMain2Binding(@NonNull ConstraintLayout rootView,
      @NonNull FrameLayout frameLayout2, @NonNull ImageView imageView,
      @NonNull ImageView imageView3, @NonNull TextView iniciarSesiontxt,
      @NonNull ImageView loginBtn, @NonNull FrameLayout loginContainerFL, @NonNull FrameLayout nada,
      @NonNull TextView registrarsetxt, @NonNull TextView textView, @NonNull TextView textView2) {
    this.rootView = rootView;
    this.frameLayout2 = frameLayout2;
    this.imageView = imageView;
    this.imageView3 = imageView3;
    this.iniciarSesiontxt = iniciarSesiontxt;
    this.loginBtn = loginBtn;
    this.loginContainerFL = loginContainerFL;
    this.nada = nada;
    this.registrarsetxt = registrarsetxt;
    this.textView = textView;
    this.textView2 = textView2;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMain2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMain2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.frameLayout2;
      FrameLayout frameLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (frameLayout2 == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.imageView3;
      ImageView imageView3 = ViewBindings.findChildViewById(rootView, id);
      if (imageView3 == null) {
        break missingId;
      }

      id = R.id.iniciarSesiontxt;
      TextView iniciarSesiontxt = ViewBindings.findChildViewById(rootView, id);
      if (iniciarSesiontxt == null) {
        break missingId;
      }

      id = R.id.loginBtn;
      ImageView loginBtn = ViewBindings.findChildViewById(rootView, id);
      if (loginBtn == null) {
        break missingId;
      }

      id = R.id.loginContainerFL;
      FrameLayout loginContainerFL = ViewBindings.findChildViewById(rootView, id);
      if (loginContainerFL == null) {
        break missingId;
      }

      id = R.id.nada;
      FrameLayout nada = ViewBindings.findChildViewById(rootView, id);
      if (nada == null) {
        break missingId;
      }

      id = R.id.registrarsetxt;
      TextView registrarsetxt = ViewBindings.findChildViewById(rootView, id);
      if (registrarsetxt == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      return new ActivityMain2Binding((ConstraintLayout) rootView, frameLayout2, imageView,
          imageView3, iniciarSesiontxt, loginBtn, loginContainerFL, nada, registrarsetxt, textView,
          textView2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
