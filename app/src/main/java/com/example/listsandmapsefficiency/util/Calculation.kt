package com.example.listsandmapsefficiency.util

import java.util.*
import java.util.concurrent.CopyOnWriteArrayList
import kotlin.collections.ArrayList

class Calculation {

    fun calculate(
        size: Int,
        codeOperation: String
    ): ArrayList<String> {

        when (codeOperation) {

            Constants.KEY_CALC_MAP_1 -> {
                val treeMap = TreeMap<Int, Int>()
                for (i in 1..size) {
                    treeMap[i] = 0
                }
                val startTime = System.currentTimeMillis()
                treeMap[0] = 0
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_MAP_2 -> {
                val treeMap = TreeMap<Int, Int>()
                for (i in 0 until size) {
                    treeMap[i] = 0
                }
                val startTime = System.currentTimeMillis()
                treeMap.containsKey(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_MAP_3 -> {
                val treeMap = TreeMap<Int, Int>()
                for (i in 0 until size) {
                    treeMap[i] = 0
                }
                val startTime = System.currentTimeMillis()
                treeMap.remove(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_MAP_4 -> {
                val hashMap = HashMap<Int, Int>()
                for (i in 1..size) {
                    hashMap[i] = 0
                }
                val startTime = System.currentTimeMillis()
                hashMap[0] = 0
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_MAP_5 -> {
                val hashMap = HashMap<Int, Int>()
                for (i in 0 until size) {
                    hashMap[i] = 0
                }
                val startTime = System.currentTimeMillis()
                hashMap.containsKey(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_MAP_6 -> {
                val hashMap = HashMap<Int, Int>()
                for (i in 0 until size) {
                    hashMap[i] = 0
                }
                val startTime = System.currentTimeMillis()
                hashMap.remove(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_1 -> {
                val arrayList = ArrayList<Int>()
                for (i in 0 until size) {
                    arrayList.add(i)
                }
                val startTime = System.currentTimeMillis()
                arrayList.add(0, 0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_2 -> {
                val arrayList = ArrayList<Int>()
                for (i in 0 until size) {
                    arrayList.add(i)
                }
                val startTime = System.currentTimeMillis()
                arrayList.add(size / 2, 0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_3 -> {
                val arrayList = ArrayList<Int>()
                for (i in 0 until size) {
                    arrayList.add(i)
                }
                val startTime = System.currentTimeMillis()
                arrayList.add(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_4 -> {
                val arrayList = ArrayList<Int>()
                for (i in 0 until size) {
                    arrayList.add(i)
                }
                val startTime = System.currentTimeMillis()
                arrayList.indexOf(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_5 -> {
                val arrayList = ArrayList<Int>()
                for (i in 0 until size) {
                    arrayList.add(i)
                }
                val startTime = System.currentTimeMillis()
                arrayList.removeAt(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_6 -> {
                val arrayList = ArrayList<Int>()
                for (i in 0 until size) {
                    arrayList.add(i)
                }
                val startTime = System.currentTimeMillis()
                arrayList.removeAt(size / 2)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_7 -> {
                val arrayList = ArrayList<Int>()
                for (i in 0 until size) {
                    arrayList.add(i)
                }
                val startTime = System.currentTimeMillis()
                arrayList.removeAt(size - 1)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_8 -> {
                val linkedList = LinkedList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                linkedList.addFirst(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_9 -> {
                val linkedList = LinkedList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                linkedList.add(size / 2, 0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_10 -> {
                val linkedList = LinkedList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                linkedList.addLast(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_11 -> {
                val linkedList = LinkedList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                linkedList.indexOf(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_12 -> {
                val linkedList = LinkedList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                linkedList.removeFirst()
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_13 -> {
                val linkedList = LinkedList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                linkedList.removeAt(size / 2)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_14 -> {
                val linkedList = LinkedList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                linkedList.removeLast()
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_15 -> {
                val cowArr = CopyOnWriteArrayList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                cowArr.add(0, 0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_16 -> {
                val cowArr = CopyOnWriteArrayList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                cowArr.add(size / 2, 0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_17 -> {
                val cowArr = CopyOnWriteArrayList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                cowArr.add(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_18 -> {
                val cowArr = CopyOnWriteArrayList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                cowArr.indexOf(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_19 -> {
                val cowArr = CopyOnWriteArrayList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                cowArr.removeAt(0)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_20 -> {
                val cowArr = CopyOnWriteArrayList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                cowArr.removeAt(size / 2)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
            Constants.KEY_CALC_LIST_21 -> {
                val cowArr = CopyOnWriteArrayList(Collections.nCopies(size, 0))
                val startTime = System.currentTimeMillis()
                cowArr.removeAt(size - 1)
                val resultTime = System.currentTimeMillis() - startTime
                val resultList = ArrayList<String>()
                resultList.add(resultTime.toString())
                resultList.add(codeOperation)
                return resultList
            }
        }

        // Some default values
        return arrayListOf(
            Constants.DEFAULT_SIZE,
            Constants.DEFAULT_CODE_OPERATION
        )
    }
}