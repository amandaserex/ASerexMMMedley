package edu.ucsb.cs.cs184.amandaserex.aserexmmmedley.ui.imagescaling

import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.MotionEventCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.ucsb.cs.cs184.amandaserex.aserexmmmedley.R


class ImageScalingFragment : Fragment() {

    var scaleGestureDetector: ScaleGestureDetector? = null

    companion object {
        fun newInstance() = ImageScalingFragment()
    }

    private lateinit var viewModel: ImageScalingViewModel


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
            val view = inflater.inflate(R.layout.fragment_imagescaling, container, false);
            view.setOnTouchListener(object : View.OnTouchListener {
                override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                    scaleGestureDetector?.onTouchEvent(event)

                    return true;
                }
            })
        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        scaleGestureDetector = ScaleGestureDetector(
                context,
                MyOnScaleGestureListener()
        )

        val fab: FloatingActionButton =
            requireActivity().findViewById<FloatingActionButton>(R.id.fab1)
        var imageView: ImageView = requireActivity().findViewById<ImageView>(R.id.imageScalingView)


        fab.setOnClickListener {
            Glide.with(this)
                .load("https://picsum.photos/400/600")
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
        }


        Glide.with(this)
            .load("https://picsum.photos/400/600")
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(imageView);
        viewModel = ViewModelProvider(this).get(
                ImageScalingViewModel::
                class.java
        )

    }

        inner class MyOnScaleGestureListener : SimpleOnScaleGestureListener() {
            override fun onScale(detector: ScaleGestureDetector): Boolean {
                val myImageView : ImageView = requireActivity().findViewById<ImageView>(R.id.imageScalingView)
                val scaleFactor = detector.scaleFactor
                myImageView.scaleX = scaleFactor * myImageView.scaleX;
                myImageView.scaleY = scaleFactor * myImageView.scaleY;
                return true
            }

            override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
                return true
            }

            override fun onScaleEnd(detector: ScaleGestureDetector) {
            }


        }

}

