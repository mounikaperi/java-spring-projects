/** 2058
A critical point in a linked list is defined as either a local maxima or a local minima.

A node is a local maxima if the current node has a value strictly greater than the previous node and the next node.

A node is a local minima if the current node has a value strictly smaller than the previous node and the next node.

Note that a node can only be a local maxima/minima if there exists both a previous node and a next node.

Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] where minDistance is the minimum distance between any two distinct critical points and maxDistance is the maximum distance between any two distinct critical points. If there are fewer than two critical points, return [-1, -1].

*/
import java.util.*;

class MinMaxNoOfNodesBetweenCriticalPoints {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> criticalPointsList = new ArrayList<>();
        int previousValue = head.val;
        head = head.next;
        int index = 1;
        while (head != null) {
            int currentValue = head.val;
            if (head.next != null {
                int nextValue = head.next.val;
                if ((currentValue < previousValue && currentValue < nextValue) || (currentValue > previousValue && currentValue > nextValue)) {
                  criticalPointsList.add(index);
                }
                index++;
                head = head.next;
                previousValue = currentValue;
            }
        }   
        if (criticalPointsList.size() < 2) {
          return new int[] {-1, -1};
        }
        int minimum = Integer.MAX_VALUE;
        for (int i=0; i<criticalPointsList.size()-1; i++) {
            minimum = Math.min(minimum, criticalPointsList.get(i+1) - criticalPointsList.get(i));
        }
        int maximum = criticalPointsList.get(criticalPointsList.size()-1) - criticalPointsList.get(0);
        return new int[] { minimum, maximum };
    }
}
