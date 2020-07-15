/*
 * Copyright (c) 2020. Ugljesa Jovanovic
 */

package com.ionspin.kotlin.bignum.integer.integer.util

import com.ionspin.kotlin.bignum.integer.util.mirrorBytes
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * Created by Ugljesa Jovanovic
 * ugljesa.jovanovic@ionspin.com
 * on 14-Jul-2020
 */
class EndianessTest {

    @Test
    fun testBigToLittle() {
        assertTrue {
            val source = ubyteArrayOf(
                0x00U, 0x11U, 0x22U, 0x33U, 0x44U, 0x55U, 0x66U, 0x77U, 0x88U, 0x99U, 0xAAU, 0xBBU, 0xCCU, 0xDDU, 0xEEU, 0xFFU
            )
            val expected = ubyteArrayOf(
                0x33U, 0x22U, 0x11U, 0x00U, 0x44U, 0x55U, 0x66U, 0x77U, 0x88U, 0x99U, 0xAAU, 0xBBU, 0xCCU, 0xDDU, 0xEEU, 0xFFU
            )
            val target = source.copyOf()
            mirrorBytes(source, 0, 4, target, 0)
            expected.contentEquals(target)
        }

        assertTrue {
            val source = ubyteArrayOf(
                0x00U, 0x11U, 0x22U, 0x33U, 0x44U, 0x55U, 0x66U, 0x77U, 0x88U, 0x99U, 0xAAU, 0xBBU, 0xCCU, 0xDDU, 0xEEU, 0xFFU
            )
            val expected = ubyteArrayOf(
                0x00U, 0x11U, 0x22U, 0x33U, 0xBBU, 0xAAU, 0x99U, 0x88U, 0x77U, 0x66U, 0x55U, 0x44U, 0xCCU, 0xDDU, 0xEEU, 0xFFU
            )
            val target = source.copyOf()
            mirrorBytes(source, 4, 12, target, 4)
            expected.contentEquals(target)
        }

        assertTrue {
            val source = ubyteArrayOf(
                0x00U, 0x11U, 0x22U, 0x33U, 0x44U, 0x55U, 0x66U, 0x77U, 0x88U, 0x99U, 0xAAU, 0xBBU, 0xCCU, 0xDDU, 0xEEU, 0xFFU
            )
            val expected = ubyteArrayOf(
                0xBBU, 0xAAU, 0x99U, 0x88U, 0x77U, 0x66U, 0x55U, 0x44U, 0x00U, 0x00U, 0x00U, 0x00U, 0x00U, 0x00U, 0x00U, 0x00U,
            )
            val target = UByteArray(16)
            mirrorBytes(source, 4, 12, target, 0)
            expected.contentEquals(target)
        }

    }

    @Test
    fun testLittleToBig() {
        assertTrue {
            val source = ubyteArrayOf(
                0x33U, 0x22U, 0x11U, 0x00U, 0x44U, 0x55U, 0x66U, 0x77U, 0x88U, 0x99U, 0xAAU, 0xBBU, 0xCCU, 0xDDU, 0xEEU, 0xFFU
            )
            val expected = ubyteArrayOf(
                0x00U, 0x11U, 0x22U, 0x33U, 0x44U, 0x55U, 0x66U, 0x77U, 0x88U, 0x99U, 0xAAU, 0xBBU, 0xCCU, 0xDDU, 0xEEU, 0xFFU
            )
            val target = source.copyOf()
            mirrorBytes(source, 0, 4, target, 0)
            expected.contentEquals(target)
        }

        assertTrue {
            val source = ubyteArrayOf(
                0x00U, 0x11U, 0x22U, 0x33U, 0xBBU, 0xAAU, 0x99U, 0x88U, 0x77U, 0x66U, 0x55U, 0x44U, 0xCCU, 0xDDU, 0xEEU, 0xFFU
            )
            val expected = ubyteArrayOf(
                0x00U, 0x11U, 0x22U, 0x33U, 0x44U, 0x55U, 0x66U, 0x77U, 0x88U, 0x99U, 0xAAU, 0xBBU, 0xCCU, 0xDDU, 0xEEU, 0xFFU
            )
            val target = source.copyOf()
            mirrorBytes(source, 4, 12, target, 4)
            expected.contentEquals(target)
        }

        assertTrue {
            val source = ubyteArrayOf(
                0x00U, 0x11U, 0x22U, 0x33U, 0x44U, 0x55U, 0x66U, 0x77U, 0x88U, 0x99U, 0xAAU, 0xBBU, 0xCCU, 0xDDU, 0xEEU, 0xFFU
            )
            val expected = ubyteArrayOf(
                0xBBU, 0xAAU, 0x99U, 0x88U, 0x77U, 0x66U, 0x55U, 0x44U, 0x00U, 0x00U, 0x00U, 0x00U, 0x00U, 0x00U, 0x00U, 0x00U,
            )
            val target = UByteArray(16)
            mirrorBytes(source, 4, 12, target, 0)
            expected.contentEquals(target)
        }

    }
}
