package br.concrete.trainingkotlin.data.model

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
class Item(val task: String,
           val description: String) : Parcelable