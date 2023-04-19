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

public final class FormatPublicacionBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardView2;

  @NonNull
  public final TextView descipctionLabel;

  @NonNull
  public final ImageView imageCurso;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final TextView nameCursoLabel;

  @NonNull
  public final TextView pbDayTxt;

  @NonNull
  public final TextView pbMouthTxt;

  @NonNull
  public final TextView pbYearTxt;

  @NonNull
  public final ImageView perfilIconImg;

  @NonNull
  public final TextView textView6;

  private FormatPublicacionBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardView2,
      @NonNull TextView descipctionLabel, @NonNull ImageView imageCurso,
      @NonNull ImageView imageView5, @NonNull TextView nameCursoLabel, @NonNull TextView pbDayTxt,
      @NonNull TextView pbMouthTxt, @NonNull TextView pbYearTxt, @NonNull ImageView perfilIconImg,
      @NonNull TextView textView6) {
    this.rootView = rootView;
    this.cardView2 = cardView2;
    this.descipctionLabel = descipctionLabel;
    this.imageCurso = imageCurso;
    this.imageView5 = imageView5;
    this.nameCursoLabel = nameCursoLabel;
    this.pbDayTxt = pbDayTxt;
    this.pbMouthTxt = pbMouthTxt;
    this.pbYearTxt = pbYearTxt;
    this.perfilIconImg = perfilIconImg;
    this.textView6 = textView6;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FormatPublicacionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FormatPublicacionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.format_publicacion, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FormatPublicacionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardView2;
      CardView cardView2 = ViewBindings.findChildViewById(rootView, id);
      if (cardView2 == null) {
        break missingId;
      }

      id = R.id.descipction_label;
      TextView descipctionLabel = ViewBindings.findChildViewById(rootView, id);
      if (descipctionLabel == null) {
        break missingId;
      }

      id = R.id.image_curso;
      ImageView imageCurso = ViewBindings.findChildViewById(rootView, id);
      if (imageCurso == null) {
        break missingId;
      }

      id = R.id.imageView5;
      ImageView imageView5 = ViewBindings.findChildViewById(rootView, id);
      if (imageView5 == null) {
        break missingId;
      }

      id = R.id.name_curso_label;
      TextView nameCursoLabel = ViewBindings.findChildViewById(rootView, id);
      if (nameCursoLabel == null) {
        break missingId;
      }

      id = R.id.pb_dayTxt;
      TextView pbDayTxt = ViewBindings.findChildViewById(rootView, id);
      if (pbDayTxt == null) {
        break missingId;
      }

      id = R.id.pb_mouthTxt;
      TextView pbMouthTxt = ViewBindings.findChildViewById(rootView, id);
      if (pbMouthTxt == null) {
        break missingId;
      }

      id = R.id.pb_yearTxt;
      TextView pbYearTxt = ViewBindings.findChildViewById(rootView, id);
      if (pbYearTxt == null) {
        break missingId;
      }

      id = R.id.perfil_icon_img;
      ImageView perfilIconImg = ViewBindings.findChildViewById(rootView, id);
      if (perfilIconImg == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      return new FormatPublicacionBinding((ConstraintLayout) rootView, cardView2, descipctionLabel,
          imageCurso, imageView5, nameCursoLabel, pbDayTxt, pbMouthTxt, pbYearTxt, perfilIconImg,
          textView6);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
