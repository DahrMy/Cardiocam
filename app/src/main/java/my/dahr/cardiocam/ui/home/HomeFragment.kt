package my.dahr.cardiocam.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import my.dahr.cardiocam.R
import my.dahr.cardiocam.databinding.FragmentHomeBinding
import my.dahr.cardiocam.ui.measurement.MeasurementFragment


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setBarsColor()
        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.btMeasure.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .addToBackStack("")
                .replace(R.id.fragment_container_view, MeasurementFragment())
                .commit()
        }
    }

    private fun setBarsColor() {
        val window: Window = requireActivity().window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = resources.getColor(R.color.primary, null)
        window.navigationBarColor = resources.getColor(R.color.windowBackgroundSecondary, null)
    }

}