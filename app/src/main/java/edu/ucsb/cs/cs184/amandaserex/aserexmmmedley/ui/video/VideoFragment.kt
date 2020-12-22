package edu.ucsb.cs.cs184.amandaserex.aserexmmmedley.ui.video

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.fragment.app.Fragment
import edu.ucsb.cs.cs184.amandaserex.aserexmmmedley.R


class VideoFragment : Fragment() {

    var videoView: VideoView? = null

    companion object {
        fun newInstance() = VideoFragment()
    }

    private lateinit var viewModel: VideoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var videoView = requireActivity().findViewById(R.id.video) as VideoView
        val mediaController = MediaController(context)
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView!!.setVideoURI(
            Uri.parse(
                "android.resource://" + requireActivity().packageName + "/"
                        + R.raw.bigbuck
            )
        );

        videoView.start()
    }

}