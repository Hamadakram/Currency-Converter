package com.test.currencyconverter.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import com.test.currencyconverter.R
import com.test.currencyconverter.core.domain.model.Rate
import com.test.currencyconverter.core.domain.RateList
import com.test.currencyconverter.di.injector
import kotlinx.android.synthetic.main.fragment_rates.*
import javax.inject.Inject


/**
 * Created by Hammad Akram
 * hamadakram91@gmail.com
 */

class RatesFragment : Fragment() {

    companion object {
        fun newInstance() = RatesFragment()
        private const val DEFAULT_CURRENCY = "EUR"
        private const val REPEAT_TIME = 1L
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(RatesViewModel::class.java)
    }

    private lateinit var ratesAdapter: RatesAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_rates, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        ratesAdapter.onItemSelected = { item: Rate, position: Int ->
            viewModel.selectedPosition = position
            viewModel.selectedCurrency = item.currency
        }

        ratesAdapter.onValueChanged = {
            activity?.window?.decorView?.handler?.post {
                // Notify item changed except first position
                ratesAdapter.notifyItemsChanged(exceptPosition = 0)
            }
        }

        ratesAdapter.onMultiplierChange = {
            ratesAdapter.multiplier = it
        }

        // Progress bar state observer
        viewModel.progressBarState.observe(this, Observer<Boolean> { shouldShow ->
            progressBar.visibility = if (shouldShow) View.VISIBLE else View.GONE
        })

        // Rate list observer
        viewModel.ratesLiveData.observe(this, Observer<RateList> { rates ->
            ratesAdapter.updateList(rates.toList())

            if (viewModel.listUpdateType == RatesViewModel.ListUpdateType.MOVE_TO_TOP)
                ratesAdapter.notifyItemMoved(viewModel.selectedPosition, 0)
            else
                ratesAdapter.notifyDataChanged()
        })

        // Set initial currency to EUR
        viewModel.selectedCurrency = DEFAULT_CURRENCY
        viewModel.updateRates(atPeriod = REPEAT_TIME)
    }

    private fun setUpRecyclerView() {
        ratesAdapter = RatesAdapter()
        rateList.adapter = ratesAdapter
        rateList.layoutManager = LinearLayoutManager(context)
        (rateList.itemAnimator as? SimpleItemAnimator)?.supportsChangeAnimations = false
    }
}