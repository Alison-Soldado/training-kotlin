package br.concrete.trainingkotlin.feature.item

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import br.concrete.trainingkotlin.R
import br.concrete.trainingkotlin.data.model.Item
import br.concrete.trainingkotlin.feature.home.JHomeActivity.ITEM_EXTRAS
import kotlinx.android.synthetic.main.activity_item.*

/**
 * @author Alison Soldado
 */
class JItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)
        setUpScreen()
    }

    private fun setUpScreen() {
        add_item!!.setOnClickListener {
            if (task!!.text.toString().isEmpty()) {
                AlertDialog.Builder(this)
                        .setTitle("Atenção")
                        .setMessage("O campo 'tarefa' é obrigatório!")
                        .setPositiveButton(android.R.string.ok) { dialog, i -> dialog.dismiss() }
                        .show()
            } else {
                setResult(Activity.RESULT_OK, Intent().putExtra(ITEM_EXTRAS, getFormItem()))
                finish()
            }
        }
    }

    private fun getFormItem(): Item {
        return Item(
                task!!.text.toString(),
                if (description!!.text.toString().isEmpty()) "-" else description!!.text.toString()
        )
    }
}