package br.concrete.trainingkotlin.feature.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import br.concrete.trainingkotlin.R
import br.concrete.trainingkotlin.feature.item.JItemActivity
import kotlinx.android.synthetic.main.activity_home.*

class JHomeActivity : AppCompatActivity() {

    private val jHomeAdapter = JHomeAdapter()

    companion object {
        const val ITEM_EXTRAS = "ITEM.EXTRAS"
        const val ITEM_ACTIVITY_CODE = 0X123
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setUpScreen()
    }

    private fun setUpScreen() {
        setupRecyclerView()
        add_item.setOnClickListener { startActivityWaitingItem() }
    }

    private fun startActivityWaitingItem() {
        startActivityForResult(
                Intent(this, JItemActivity::class.java), ITEM_ACTIVITY_CODE)
    }

    private fun setupRecyclerView() {
        recycler_view.adapter = jHomeAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ITEM_ACTIVITY_CODE &&
                resultCode == RESULT_OK &&
                data != null && data.hasExtra(ITEM_EXTRAS)) {

            jHomeAdapter.addItem(data.getParcelableExtra(ITEM_EXTRAS))
        }
    }
}
