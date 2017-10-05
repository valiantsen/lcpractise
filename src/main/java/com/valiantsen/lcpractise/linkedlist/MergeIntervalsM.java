package main.java.com.valiantsen.lcpractise.linkedlist;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MergeIntervalsM {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start > o2.start) {
                    return 1;
                } else if (o1.start < o2.start) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        Iterator<Interval> iterator = intervals.iterator();
        Interval p = iterator.next();
        while (iterator.hasNext()) {
            Interval q = iterator.next();
            if (p.start <= q.end && p.end >= q.start) {
                p.start = p.start < q.start ? p.start : q.start;
                p.end = p.end > q.end ? p.end : q.end;
                iterator.remove();
            } else {
                p = q;
            }
        }
        return intervals;
    }

    public class Interval {
        int start;

        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
