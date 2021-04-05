package com.example.viewpagerdemo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.viewpagerdemo.ui.ScreenSlidePagerActivity
import com.example.viewpagerdemo.viewmodel.factory.SlideSharedViewModel
import kotlinx.android.synthetic.main.fragment_screen_slide_page.*

class ScreenSlidePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_screen_slide_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            page_number.text = it.getInt(ARGS_PAGER_POSITION).toString()
        }
        val activity = requireActivity() as ScreenSlidePagerActivity
        val viewModel =
            ViewModelProvider(activity, activity.viewModelFactory).get(SlideSharedViewModel::class.java)
        Log.d("viewModel", "$viewModel")
    }

    companion object {
        private const val ARGS_PAGER_POSITION = "args_pager_position"

        @JvmStatic
        fun newIntent(position: Int): ScreenSlidePageFragment {
            return ScreenSlidePageFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARGS_PAGER_POSITION, position)
                }
            }
        }
    }
}