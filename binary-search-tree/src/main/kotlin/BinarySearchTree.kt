import java.util.*

class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(val data: T, var left: Node<T>?, var right: Node<T>?)

    var root: Node<T>? = null
    var targetNode = root

    fun insert(value: T) {
        if (root == null) {
            root = Node(value, null, null)
            targetNode = root
            return
        }
        if (targetNode!!.data >= value) {
            if (targetNode!!.left == null) {
                targetNode!!.left = Node(value, null, null)
                targetNode = root
                return
            } else {
                targetNode = targetNode!!.left
                insert(value)
            }
        }
        if (targetNode!!.data < value) {
            if (targetNode!!.right == null) {
                targetNode!!.right = Node(value, null, null)
                targetNode = root
                return
            } else {
                targetNode = targetNode!!.right
                insert(value)
            }
        }
    }

    fun asSortedList(): List<T> {
        val list = asLevelOrderList()
        return list.sorted()
    }

    fun asLevelOrderList(): List<T> {
        val resultList = mutableListOf<T>()
        val queue = ArrayDeque<Node<T>>()
        queue.add(root)
        while (queue.size > 0) {
            val node = queue.remove()
            resultList.add(node.data)
            if (node.left != null) {
                queue.add(node.left)
            }
            if (node.right != null) {
                queue.add(node.right)
            }
        }
        return resultList
    }

}
