package com.example.marvelapp.presentation.extensions

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

fun Fragment.showShortToast(@StringRes textRestId: Int) =
    Toast.makeText(requireContext(), textRestId, Toast.LENGTH_SHORT).show()