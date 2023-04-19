// Generated by view binder compiler. Do not edit!
package com.example.interfaces_pr.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.interfaces_pr.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPostCommentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FloatingActionButton addBtn;

  @NonNull
  public final ImageView backButton;

  @NonNull
  public final CardView cardView3;

  @NonNull
  public final EditText editTextTextPersonName5;

  @NonNull
  public final FloatingActionButton fileBtn;

  @NonNull
  public final FloatingActionButton galleryBtn;

  @NonNull
  public final ImageView publicationImg;

  @NonNull
  public final TextView publicationTitleTxt;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView17;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final ImageView userImg;

  @NonNull
  public final View view14;

  @NonNull
  public final View view15;

  private ActivityPostCommentBinding(@NonNull ConstraintLayout rootView,
      @NonNull FloatingActionButton addBtn, @NonNull ImageView backButton,
      @NonNull CardView cardView3, @NonNull EditText editTextTextPersonName5,
      @NonNull FloatingActionButton fileBtn, @NonNull FloatingActionButton galleryBtn,
      @NonNull ImageView publicationImg, @NonNull TextView publicationTitleTxt,
      @NonNull TextView textView16, @NonNull TextView textView17, @NonNull TextView textView5,
      @NonNull ImageView userImg, @NonNull View view14, @NonNull View view15) {
    this.rootView = rootView;
    this.addBtn = addBtn;
    this.backButton = backButton;
    this.cardView3 = cardView3;
    this.editTextTextPersonName5 = editTextTextPersonName5;
    this.fileBtn = fileBtn;
    this.galleryBtn = galleryBtn;
    this.publicationImg = publicationImg;
    this.publicationTitleTxt = publicationTitleTxt;
    this.textView16 = textView16;
    this.textView17 = textView17;
    this.textView5 = textView5;
    this.userImg = userImg;
    this.view14 = view14;
    this.view15 = view15;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPostCommentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPostCommentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_post_comment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPostCommentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.addBtn;
      FloatingActionButton addBtn = ViewBindings.findChildViewById(rootView, id);
      if (addBtn == null) {
        break missingId;
      }

      id = R.id.backButton;
      ImageView backButton = ViewBindings.findChildViewById(rootView, id);
      if (backButton == null) {
        break missingId;
      }

      id = R.id.cardView3;
      CardView cardView3 = ViewBindings.findChildViewById(rootView, id);
      if (cardView3 == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName5;
      EditText editTextTextPersonName5 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName5 == null) {
        break missingId;
      }

      id = R.id.fileBtn;
      FloatingActionButton fileBtn = ViewBindings.findChildViewById(rootView, id);
      if (fileBtn == null) {
        break missingId;
      }

      id = R.id.galleryBtn;
      FloatingActionButton galleryBtn = ViewBindings.findChildViewById(rootView, id);
      if (galleryBtn == null) {
        break missingId;
      }

      id = R.id.publication_Img;
      ImageView publicationImg = ViewBindings.findChildViewById(rootView, id);
      if (publicationImg == null) {
        break missingId;
      }

      id = R.id.publication_titleTxt;
      TextView publicationTitleTxt = ViewBindings.findChildViewById(rootView, id);
      if (publicationTitleTxt == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = ViewBindings.findChildViewById(rootView, id);
      if (textView16 == null) {
        break missingId;
      }

      id = R.id.textView17;
      TextView textView17 = ViewBindings.findChildViewById(rootView, id);
      if (textView17 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.userImg;
      ImageView userImg = ViewBindings.findChildViewById(rootView, id);
      if (userImg == null) {
        break missingId;
      }

      id = R.id.view14;
      View view14 = ViewBindings.findChildViewById(rootView, id);
      if (view14 == null) {
        break missingId;
      }

      id = R.id.view15;
      View view15 = ViewBindings.findChildViewById(rootView, id);
      if (view15 == null) {
        break missingId;
      }

      return new ActivityPostCommentBinding((ConstraintLayout) rootView, addBtn, backButton,
          cardView3, editTextTextPersonName5, fileBtn, galleryBtn, publicationImg,
          publicationTitleTxt, textView16, textView17, textView5, userImg, view14, view15);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
