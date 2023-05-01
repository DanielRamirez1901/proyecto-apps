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

public final class PerfilfragmentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView bannerImg;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final CardView cardView2;

  @NonNull
  public final CardView cardView3;

  @NonNull
  public final TextView career;

  @NonNull
  public final ImageView celularIcon;

  @NonNull
  public final TextView celularLabel;

  @NonNull
  public final TextView descriptionNotification;

  @NonNull
  public final ImageView iconNotification;

  @NonNull
  public final TextView name;

  @NonNull
  public final ImageView perfilPhotoImg;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView titleNotification;

  private PerfilfragmentBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView bannerImg,
      @NonNull CardView cardView, @NonNull CardView cardView2, @NonNull CardView cardView3,
      @NonNull TextView career, @NonNull ImageView celularIcon, @NonNull TextView celularLabel,
      @NonNull TextView descriptionNotification, @NonNull ImageView iconNotification,
      @NonNull TextView name, @NonNull ImageView perfilPhotoImg, @NonNull TextView textView4,
      @NonNull TextView titleNotification) {
    this.rootView = rootView;
    this.bannerImg = bannerImg;
    this.cardView = cardView;
    this.cardView2 = cardView2;
    this.cardView3 = cardView3;
    this.career = career;
    this.celularIcon = celularIcon;
    this.celularLabel = celularLabel;
    this.descriptionNotification = descriptionNotification;
    this.iconNotification = iconNotification;
    this.name = name;
    this.perfilPhotoImg = perfilPhotoImg;
    this.textView4 = textView4;
    this.titleNotification = titleNotification;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static PerfilfragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static PerfilfragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.perfilfragment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static PerfilfragmentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.banner_img;
      ImageView bannerImg = ViewBindings.findChildViewById(rootView, id);
      if (bannerImg == null) {
        break missingId;
      }

      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.cardView2;
      CardView cardView2 = ViewBindings.findChildViewById(rootView, id);
      if (cardView2 == null) {
        break missingId;
      }

      id = R.id.cardView3;
      CardView cardView3 = ViewBindings.findChildViewById(rootView, id);
      if (cardView3 == null) {
        break missingId;
      }

      id = R.id.career;
      TextView career = ViewBindings.findChildViewById(rootView, id);
      if (career == null) {
        break missingId;
      }

      id = R.id.celular_icon;
      ImageView celularIcon = ViewBindings.findChildViewById(rootView, id);
      if (celularIcon == null) {
        break missingId;
      }

      id = R.id.celular_label;
      TextView celularLabel = ViewBindings.findChildViewById(rootView, id);
      if (celularLabel == null) {
        break missingId;
      }

      id = R.id.description_notification;
      TextView descriptionNotification = ViewBindings.findChildViewById(rootView, id);
      if (descriptionNotification == null) {
        break missingId;
      }

      id = R.id.icon_notification;
      ImageView iconNotification = ViewBindings.findChildViewById(rootView, id);
      if (iconNotification == null) {
        break missingId;
      }

      id = R.id.name;
      TextView name = ViewBindings.findChildViewById(rootView, id);
      if (name == null) {
        break missingId;
      }

      id = R.id.perfil_photo_img;
      ImageView perfilPhotoImg = ViewBindings.findChildViewById(rootView, id);
      if (perfilPhotoImg == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.title_notification;
      TextView titleNotification = ViewBindings.findChildViewById(rootView, id);
      if (titleNotification == null) {
        break missingId;
      }

      return new PerfilfragmentBinding((ConstraintLayout) rootView, bannerImg, cardView, cardView2,
          cardView3, career, celularIcon, celularLabel, descriptionNotification, iconNotification,
          name, perfilPhotoImg, textView4, titleNotification);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}