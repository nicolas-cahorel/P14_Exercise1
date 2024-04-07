package com.kirabium.relayance.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kirabium.relayance.R
import com.kirabium.relayance.data.DummyData
import com.kirabium.relayance.databinding.ActivityDetailBinding
import com.kirabium.relayance.extension.DateExt.Companion.toHumanDate

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding


    companion object {
        const val EXTRA_CUSTOMER_ID = "customer_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupToolbar()
        setupUI()

    }

    private fun setupUI() {
        val customerId = intent.getIntExtra(EXTRA_CUSTOMER_ID, -1)
        DummyData.customers.find { it.id == customerId }?.let {
            with(binding) {
                emailTextView.text = it.email
                nameTextView.text = it.name
                dateTextView.text = getString(R.string.created_at, it.createdAt.toHumanDate())
                if (it.isNewCustomer()) {
                    newRibbonTextView.visibility = View.VISIBLE
                } else {
                    newRibbonTextView.visibility = View.GONE
                }
            }
        }
    }

    private fun setupBinding() {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}


