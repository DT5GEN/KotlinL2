package com.example.kotlinl2.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kotlinl2.R
import com.example.kotlinl2.databinding.FragmentDetailsBinding
import com.example.kotlinl2.model.Weather


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<Weather>(BUNDLE_EXTRA)?.let {
            it.city.also {
                binding.cityName.text = it.city
                binding.cityCoordinates.text = String.format(
                    getString(R.string.city_coordinates),
                    it.lat.toString(),
                    it.lon.toString()
                )

            }
            binding.temperatureValue.text = it.temperature.toString()
            binding.feelsLikeValue.text = it.feelsLike.toString()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        const val BUNDLE_EXTRA = "weather"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}