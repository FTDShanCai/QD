package com.example.administrator.ktdemo.util

import com.example.qd_base.R
import java.util.*

/**
 * @author ddc
 * 邮箱: 931952032@qq.com
 * <p>description:
 */
class RandomUtil {

    companion object {
        private val Material_design_colors = intArrayOf(
                R.color.red, R.color.pink, R.color.purple,
                R.color.deepPurple, R.color.indigo, R.color.blue,
                R.color.lightBlue, R.color.cyan, R.color.teal,
                R.color.green, R.color.lightGreen, R.color.lime,
                R.color.yellow, R.color.amber, R.color.orange,
                R.color.deepOrange, R.color.brown, R.color.grey,
                R.color.blueGrey
        )

        fun getColor(): Int {
            val size = Material_design_colors.size
            val random = Random()
            return Material_design_colors[random.nextInt(size)]
        }
    }
}